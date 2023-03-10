package br.com.brq.chalengebrq.dataProvider.service;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import br.com.brq.chalengebrq.dataProvider.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void validar(Produto produto) {
        produto.setId(UUID.randomUUID().toString());
        produto.normalizarNome();
        produto.setAtivo(true);
        produto.setOfertado(false);
        LocalDateTime date = LocalDateTime.now();
        produto.setDataCadastro(String.valueOf(date));
        produto.setPorcentagemOferta(0);

        if (produtoRepository.existsByNome(produto.getNome())){
            throw new RuntimeException("Nome ja existe");
        }

        if (produto.getPreco() <= 0 ){
            throw new RuntimeException("Preço não pode ser 0 ou negativo");
        }
    }

    @Transactional
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscar(String id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    public void remover(Produto produto){
        if(produto.getAtivo()) {
            throw new RuntimeException("Produto ativo, não pode ser removido.");
        }
        produtoRepository.deleteById(produto.getId());
    }
}
