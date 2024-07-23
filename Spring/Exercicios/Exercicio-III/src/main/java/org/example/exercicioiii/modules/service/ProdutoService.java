package org.example.exercicioiii.modules.service;

import org.example.exercicioiii.modules.dto.ProdutoDTO.CreateProdutoDTO;
import org.example.exercicioiii.modules.entity.Produto.Produto;
import org.example.exercicioiii.modules.dto.ProdutoDTO.UpdateProdutoDTO;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    void createProduto(CreateProdutoDTO dto);
    void updateProdutoById(long id, UpdateProdutoDTO dto);
    void deleteProdutoById(long id);

}
