package com.example.Exercicio_I.modules.controller;

import com.example.Exercicio_I.modules.database.Database;
import com.example.Exercicio_I.modules.dto.CreateTarefaDTO;
import com.example.Exercicio_I.modules.entity.Tarefa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class TarefasController {

    Database database = new Database();

    @GetMapping("/tarefas/all")
    @Operation(description = "Lista todas as tarefas criadas")
    @ApiResponse(responseCode = "200")
    public List<Tarefa> getListaTarefas(){
        var list = List.copyOf(database.retrieveAll());
        return ResponseEntity.ok().body(list).getBody();
    }

    @Operation(description = "Cria uma nova tarefa, requer apenas descrição da mesma.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna a tarefa criada")
    })
    @PostMapping("/tarefas/create")
    public ResponseEntity<Tarefa> createTarefa(@RequestBody CreateTarefaDTO dto){
        Tarefa tarefa = new Tarefa(dto.descricao());
        database.add(tarefa);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(tarefa);
    }

    @Operation(description = "Marca uma terefa como 'Completa' ou 'não completa'")
    @ApiResponse(responseCode = "200", description = "Ok quando a alteração foi realizada")
    @PutMapping("/tarefas/{id}")
    public void updateTarefa(@PathVariable("id") long id){
        for(Tarefa t: database.retrieveAll()){
            if(t.getId() == id){
                if(t.isCompleta()){
                    t.setCompleta(false);
                }else{
                    t.setCompleta(true);
                }
            }
        }
    }

    @Operation(description = "Apaga uma tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa apagada corretamente")
    @DeleteMapping("/tarefas/{id}")
    public void deleteTarefa(@PathVariable int id){
        for(Tarefa t: database.retrieveAll()){
            if(t.getId() == id){
                database.remove(t);
            }
        }
    }
}
