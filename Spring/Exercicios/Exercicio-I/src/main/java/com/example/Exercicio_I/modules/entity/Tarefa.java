package com.example.Exercicio_I.modules.entity;

public class Tarefa {

    private long id;
    private String descricao;
    private boolean completa;

    private static long counter;

    public Tarefa(String descricao) {
        counter++;
        this.id = counter;
        this.descricao = descricao;
        this.completa = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public boolean isCompleta() {
        return this.completa;
    }
    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

}
