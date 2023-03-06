package br.com.brq.chalengebrq.entrypoint.mappers;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        produto.setPorcentagemOferta(produto.getPorcentagemOferta());
        return produtoDto;
    }
}
