package org.example.exercicioiii.modules.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.exercicioiii.modules.dto.ProdutoDTO.CreateProdutoDTO;
import org.example.exercicioiii.modules.entity.Produto.Produto;
import org.example.exercicioiii.modules.dto.ProdutoDTO.UpdateProdutoDTO;
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
    @Operation(description = "Lista todos os produtos", method = "GET")
    @ApiResponse(responseCode = "200", description = "Buscou todos os produtos")
    public ResponseEntity<List<Produto>> getAllProdutos() {
        var produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/produtos/{id}")
    @Operation(description = "Lista um produto específico", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "400", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "401", description = "Sem permissão para processar requisição")
    })
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        try {
            var produto = produtoService.findById(id);
            return ResponseEntity.ok().body(produto.get());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("produtos/create")
    @Operation(description = "Cria produtos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado"),
            @ApiResponse(responseCode = "400", description = "Produto não existe"),
            @ApiResponse(responseCode = "401", description = "Sem autorização")
    })
    public ResponseEntity<String> createProduto(@RequestBody CreateProdutoDTO createProdutoDTO) {
        try {
            produtoService.createProduto(createProdutoDTO);
            return ResponseEntity.status(201).body("Created");
        }catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/produtos/{id}")
    @Operation(description = "Deleta um produto da lista", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Produto não existe"),
            @ApiResponse(responseCode = "401", description = "Sem autorização para processar requisição")
    })
    public ResponseEntity<String> deleteProduto(@PathVariable Long id) {
        try {
            produtoService.deleteProdutoById(id);
            return ResponseEntity.status(200).body("Produto deletado com sucesso");
        }catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/produtos/{id}")
    @Operation(description = "Atualiza o nome ou preço do produto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Produto não existe"),
            @ApiResponse(responseCode = "401", description = "Sem autorização para processar requisição")
    })
    public ResponseEntity updateProduto(@PathVariable long id, @RequestBody UpdateProdutoDTO updateProdutoDTO) {
        try{
            produtoService.updateProdutoById(id, updateProdutoDTO);
            return ResponseEntity.ok().body("Produto atualizado com sucesso");
        }catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
