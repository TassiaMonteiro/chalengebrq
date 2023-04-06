package br.com.brq.chalengebrq.entrypoint.models;

import lombok.Data;

@Data
public class ProdutoInputAtualizar {

    private String nome;
    private String descricao;
    private String marca;
    private Double preco;
    private Boolean ativo;
    private Boolean ofertado;
    private Integer porcentagemOferta;

}
