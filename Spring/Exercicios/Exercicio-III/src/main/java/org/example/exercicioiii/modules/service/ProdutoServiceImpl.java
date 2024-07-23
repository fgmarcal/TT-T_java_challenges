package org.example.exercicioiii.modules.service;

import org.example.exercicioiii.modules.entity.Produto.CreateProdutoDTO;
import org.example.exercicioiii.modules.entity.Produto.Produto;
import org.example.exercicioiii.modules.entity.Produto.UpdateProdutoDTO;
import org.example.exercicioiii.modules.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        var produtoList = produtoRepository.findAll();
        return produtoList;
    }

    @Override
    public Optional<Produto> findById(Long id) {
        var found = produtoRepository.findById(id);
        return Optional.of(found.orElseThrow());
    }

    @Override
    public void createProduto(CreateProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produtoRepository.save(produto);
    }

    @Override
    public void updateProdutoById(UpdateProdutoDTO dto) {
        Optional<Produto> found = Optional.of(produtoRepository.findById(dto.id()).orElseThrow());
        if(found.isPresent() && !found.get().getNome().equals(dto.nome()) && !(dto.nome() == null)) {
            found.get().setNome(dto.nome());
        }
        if(found.isPresent() && found.get().getPreco() != dto.preco() && dto.preco()!= 0.0) {
            found.get().setPreco(dto.preco());
        }
        produtoRepository.save(found.get());
    }

    @Override
    public void deleteProdutoById(long id) {
        var found = produtoRepository.findById(id).orElseThrow();
        produtoRepository.delete(found);
    }
}
