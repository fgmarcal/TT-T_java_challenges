package org.example.exercicioiii.modules.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.exercicioiii.modules.entity.Produto.CreateProdutoDTO;
import org.example.exercicioiii.modules.entity.Produto.Produto;
import org.example.exercicioiii.modules.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "Endpoint de cadastro de produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("produtos/all")
    public ResponseEntity<List<Produto>> getAllProdutos() {
        var produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping("produtos/create")
    public ResponseEntity<String> createProduto(@RequestBody CreateProdutoDTO createProdutoDTO) {
        try {
            produtoService.createProduto(createProdutoDTO);
            return ResponseEntity.ok().body("Created");
        }catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
