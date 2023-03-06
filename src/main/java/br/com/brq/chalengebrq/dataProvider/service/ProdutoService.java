package br.com.brq.chalengebrq.dataProvider.service;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import br.com.brq.chalengebrq.dataProvider.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto){
        produto.setId(UUID.randomUUID().toString());
        return produtoRepository.save(produto);
    }
}
