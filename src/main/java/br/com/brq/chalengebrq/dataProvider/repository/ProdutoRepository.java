package br.com.brq.chalengebrq.dataProvider.repository;

import br.com.brq.chalengebrq.dataProvider.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

        boolean existsByNome(String nome);
}
