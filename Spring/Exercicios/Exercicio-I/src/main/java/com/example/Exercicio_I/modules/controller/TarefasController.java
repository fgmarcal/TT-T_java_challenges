package com.example.Exercicio_I.modules.controller;

import com.example.Exercicio_I.modules.database.Database;
import com.example.Exercicio_I.modules.dto.CreateTarefaDTO;
import com.example.Exercicio_I.modules.entity.Tarefa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class TarefasController {

    Database database = new Database();

    @GetMapping("/tarefas/all")
    public List<Tarefa> getListaTarefas(){
        var list = List.copyOf(database.retrieveAll());
        return ResponseEntity.ok().body(list).getBody();
    }

    @PostMapping("/tarefas/create")
    public void createTarefa(@RequestBody CreateTarefaDTO dto){
        Tarefa tarefa = new Tarefa(dto.descricao());
        database.add(tarefa);
    }

    //atualiza status (feito ou não feito)
    @PutMapping("/tarefas/{id}")
    public void updateTarefa(@PathVariable("id") int id){
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

    @DeleteMapping("/tarefas/{id}")
    public void deleteTarefa(@PathVariable int id){
        for(Tarefa t: database.retrieveAll()){
            if(t.getId() == id){
                database.remove(t);
            }
        }
    }
}
