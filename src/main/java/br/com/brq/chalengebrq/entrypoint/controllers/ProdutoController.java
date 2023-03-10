package br.com.brq.chalengebrq.entrypoint.controllers;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import br.com.brq.chalengebrq.dataProvider.repository.ProdutoRepository;
import br.com.brq.chalengebrq.dataProvider.service.ProdutoService;
import br.com.brq.chalengebrq.entrypoint.mappers.ProdutoEntryPointMappersRequest;
import br.com.brq.chalengebrq.entrypoint.mappers.ProdutoEntryPointMappersResponse;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoDto;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoDtoResumo;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/challengebrq/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoEntryPointMappersRequest produtoEntryPointMappersRequest;

    @Autowired
    private ProdutoEntryPointMappersResponse produtoEntryPointMappersResponse;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDto criar(@RequestBody ProdutoInput produtoInput){
        Produto produto = produtoEntryPointMappersRequest.toEntity(produtoInput);
        produtoService.validar(produto);
        ProdutoDto produtoDto = produtoEntryPointMappersResponse.toDto(produtoService.salvar(produto));

        return produtoDto;
    }

    @GetMapping
    public List<ProdutoDtoResumo> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtoEntryPointMappersResponse.toCollectionDto(produtos);
    }

    @GetMapping("/{id}")
    public ProdutoDto buscar(@PathVariable String id){
        Produto produto = produtoService.buscar(id);
        return produtoEntryPointMappersResponse.toDto(produto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String id){
        Produto produto = produtoService.buscar(id);
        produtoService.remover(produto);
    }

}
