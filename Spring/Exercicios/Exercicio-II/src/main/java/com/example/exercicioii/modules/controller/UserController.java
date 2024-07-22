package com.example.exercicioii.modules.controller;

import com.example.exercicioii.modules.entity.CreateUserDTO;
import com.example.exercicioii.modules.entity.Usuario;
import com.example.exercicioii.modules.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
@Tag(name = "User Controller")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/usuarios/create")
    @Operation(summary = "Realiza a criação do usuário", method = "POST")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    public ResponseEntity createUsuario(@RequestBody CreateUserDTO createUserDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(createUserDTO.nome());
        usuario.setEmail(createUserDTO.email());
        userRepository.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/usuarios")
    @Operation(summary = "Retorna uma lista completa de usuários", method = "GET")
    @ApiResponse(responseCode = "200", description = "Lista gerada com sucesso")
    public List<Usuario> getAllUsuarios() {
        var result = userRepository.findAll();
        return ResponseEntity.ok(result).getBody();
    }

    @GetMapping("/usuarios/{id}")
    @Operation(summary = "Retorna um usuário especificado pelo Id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public ResponseEntity<Usuario> getUsuario(@PathVariable long id) {

        try {
            Usuario usuario = userRepository.findById(id).orElseThrow();
            return ResponseEntity.ok(usuario);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/usuarios/{id}")
    @Operation(summary = "Remove um usuário especificado pelo Id", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar usuário")
    })
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable long id) {
        try {
            userRepository.findById(id).orElseThrow();
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
