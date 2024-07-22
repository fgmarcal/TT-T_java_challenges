package com.example.Exercicio_I.modules.database;

import com.example.Exercicio_I.modules.entity.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class Database {

   private static List<Tarefa> database;

   public Database(){
       database = new ArrayList<>();
   }

   public void add(Tarefa tarefa){
       database.add(tarefa);
   }

   public void remove(Tarefa tarefa){
       database.remove(tarefa);
   }

   public List<Tarefa> retrieveAll(){
       return database;
   }
}
