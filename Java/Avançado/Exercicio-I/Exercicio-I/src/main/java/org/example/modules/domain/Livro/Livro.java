package org.example.modules.domain.Livro;

import org.example.modules.domain.ItemBiblioteca;
import org.example.modules.exception.ItemNaoDisponivelException;

public class Livro extends ItemBiblioteca {

    public Livro(String titulo, String autor) {
        super();
        this.titulo = titulo;
        this.autor = autor;
        this.isDisponivel = true;
    }

    @Override
    public void emprestar() {
        if(!isDisponivel){
            throw new ItemNaoDisponivelException("Livro emprestado");
        }
        this.isDisponivel = false;
    }

    @Override
    public void devolver() {
        this.isDisponivel = true;
    }
}
