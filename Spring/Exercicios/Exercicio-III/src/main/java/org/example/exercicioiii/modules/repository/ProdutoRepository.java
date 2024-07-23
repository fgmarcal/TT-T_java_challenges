package org.example.exercicioiii.modules.repository;

import org.example.exercicioiii.modules.entity.Produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findById(long id);
    void deleteById(long id);
}
