package br.com.brq.chalengebrq.entrypoint.mappers;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import br.com.brq.chalengebrq.entrypoint.models.ProdutoInput;
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

}
