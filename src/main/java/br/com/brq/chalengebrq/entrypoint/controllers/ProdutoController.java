package br.com.brq.chalengebrq.entrypoint.controllers;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import br.com.brq.chalengebrq.dataProvider.service.ProdutoService;
import br.com.brq.chalengebrq.entrypoint.mappers.ProdutoEntryPointMappersRequest;
import br.com.brq.chalengebrq.entrypoint.mappers.ProdutoEntryPointMappersResponse;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoDto;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/challengebrq/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoEntryPointMappersRequest produtoEntryPointMappersRequest;

    @Autowired
    private ProdutoEntryPointMappersResponse produtoEntryPointMappersResponse;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDto criar(@RequestBody ProdutoInput produtoInput){
        Produto produto = produtoEntryPointMappersRequest.toEntity(produtoInput);
        ProdutoDto produtoDto = produtoEntryPointMappersResponse.toDto(produtoService.salvar(produto));

        return produtoDto;
    }
}