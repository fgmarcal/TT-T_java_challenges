package org.example.exercicioiii.modules.service;

import org.example.exercicioiii.modules.entity.Produto.CreateProdutoDTO;
import org.example.exercicioiii.modules.entity.Produto.Produto;
import org.example.exercicioiii.modules.entity.Produto.UpdateProdutoDTO;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    void createProduto(CreateProdutoDTO dto);
    void updateProdutoById(UpdateProdutoDTO dto);
    void deleteProdutoById(long id);

}
