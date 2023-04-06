package br.com.brq.chalengebrq.entrypoint.mappers;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoInput;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoInputAtualizar;
import org.springframework.stereotype.Component;

@Component
public class ProdutoEntryPointMappersRequest {

    public Produto toEntity(ProdutoInput produtoInput) {
        Produto produto = new Produto();
        produto.setNome(produtoInput.getNome());
        produto.setDescricao(produtoInput.getDescricao());
        produto.setMarca(produtoInput.getMarca());
        produto.setPreco(produtoInput.getPreco());

        return produto;
    }

    public Produto copyToEntity(ProdutoInputAtualizar produtoInputAtualizar, Produto produto) {
        produto.setNome(produtoInputAtualizar.getNome());
        produto.setDescricao(produtoInputAtualizar.getDescricao());
        produto.setMarca(produtoInputAtualizar.getMarca());
        produto.setPreco(produtoInputAtualizar.getPreco());
        produto.setAtivo(produtoInputAtualizar.getAtivo());
        produto.setOfertado(produtoInputAtualizar.getOfertado());
        produto.setPorcentagemOferta(produtoInputAtualizar.getPorcentagemOferta());

        return produto;
    }

}
