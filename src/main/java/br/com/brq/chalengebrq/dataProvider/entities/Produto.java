package br.com.brq.chalengebrq.dataProvider.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Produto {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private String marca;
    private Double preco;
    private String dataCadastro;
    private String dataAtualizacao;
    private Boolean ativo;
    private Boolean ofertado;
    private Integer porcentagemOferta;

    public void normalizarNome() {
        if (nome == null){
            return;
        }
        String nomeNormalizado = nome.trim();
        nome =  nomeNormalizado.replaceAll("\\s+", " ");
    }

}
