package br.com.brq.chalengebrq.entrypoint.mappers;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoDto;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoDtoResumo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoEntryPointMappersResponse {

    public ProdutoDto toDto(Produto produto) {
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setId(produto.getId());
        produtoDto.setNome(produto.getNome());
        produtoDto.setDescricao(produto.getDescricao());
        produtoDto.setMarca(produto.getMarca());
        produtoDto.setPreco(produto.getPreco());
        produtoDto.setDataCadastro(produto.getDataCadastro());
        produtoDto.setDataAtualizacao(produto.getDataAtualizacao());
        produtoDto.setAtivo(produto.getAtivo());
        produtoDto.setOfertado(produto.getOfertado());
        produtoDto.setPorcentagemOferta(produto.getPorcentagemOferta());
        return produtoDto;
    }

    public ProdutoDtoResumo toDtoResumo(Produto produto){
        ProdutoDtoResumo produtoDtoResumo = new ProdutoDtoResumo();
        produtoDtoResumo.setId(produto.getId());
        produtoDtoResumo.setNome(produto.getNome());
        produtoDtoResumo.setMarca(produto.getMarca());
        produtoDtoResumo.setPreco(produto.getPreco());

        return produtoDtoResumo;
    }

    public List<ProdutoDtoResumo> toCollectionDto(List<Produto> produtos){
        return produtos.stream()
                .map(produto -> toDtoResumo(produto))
                .collect(Collectors.toList());
    }
}
