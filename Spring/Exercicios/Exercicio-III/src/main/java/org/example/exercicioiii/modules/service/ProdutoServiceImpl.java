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
        Optional<Produto> found = Optional.of(produtoRepository.findById(id).orElseThrow());
        return found;
    }

    @Override
    public void createProduto(CreateProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produtoRepository.save(produto);
    }

    @Override
    public void updateProdutoById(long id, UpdateProdutoDTO dto) {
        Optional<Produto> found = Optional.of(produtoRepository.findById(id).orElseThrow());
        if(checaNomeProduto(dto, found)) {
            found.get().setNome(dto.nome());
        }
        if(checaPrecoProduto(dto, found)) {
            found.get().setPreco(dto.preco());
        }
        produtoRepository.save(found.get());
    }

    @Override
    public void deleteProdutoById(long id) {
        Optional<Produto> found = Optional.of(produtoRepository.findById(id).orElseThrow());
        produtoRepository.delete(found.get());
    }

    private boolean checaNomeProduto(UpdateProdutoDTO dto, Optional<Produto> produto) {
        if(produto.isPresent() && !produto.get().getNome().equals(dto.nome()) && !(dto.nome() == null) && !(dto.nome() == "")) {
            return true;
        }
        return false;
    }

    private boolean checaPrecoProduto(UpdateProdutoDTO dto, Optional<Produto> produto) {
        if(produto.isPresent() && produto.get().getPreco() != dto.preco() && dto.preco()!= 0.0) {
            return true;
        }
        return false;
    }
}
