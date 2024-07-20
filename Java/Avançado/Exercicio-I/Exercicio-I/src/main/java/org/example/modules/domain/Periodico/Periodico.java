package org.example.modules.domain.Periodico;

import org.example.modules.domain.ItemBiblioteca;
import org.example.modules.exception.ItemNaoDisponivelException;

public class Periodico extends ItemBiblioteca {

    public Periodico(String titulo, String autor) {
        super();
        this.titulo = titulo;
        this.autor = autor;
        this.isDisponivel = true;
    }

    @Override
    public void emprestar() {
        if(!isDisponivel){
            throw new ItemNaoDisponivelException("Periodico emprestado");
        }
        this.isDisponivel = false;
    }

    @Override
    public void devolver() {
        this.isDisponivel = true;
    }
}
