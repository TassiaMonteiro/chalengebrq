package br.com.brq.chalengebrq.entrypoint.models;

import lombok.Data;

@Data
public class ProdutoInput {

    private String nome;
    private String descricao;
    private String marca;
    private Double preco;
}
