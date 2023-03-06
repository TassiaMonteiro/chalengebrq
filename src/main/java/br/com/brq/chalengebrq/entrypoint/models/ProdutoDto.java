package br.com.brq.chalengebrq.entrypoint.models;

import lombok.Data;

@Data
public class ProdutoDto {

    private String id;
    private String nome;
    private String descricao;
    private String marca;
    private Double preco;
    private String DataCadastro;
    private String DataAtualizacao;
    private Boolean ativo;
    private Boolean ofertado;
    private Integer porcentagemOferta;
}
