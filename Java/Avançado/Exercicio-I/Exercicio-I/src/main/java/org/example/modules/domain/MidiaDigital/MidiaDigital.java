package org.example.modules.domain.MidiaDigital;

import org.example.modules.domain.ItemBiblioteca;
import org.example.modules.exception.ItemNaoDisponivelException;

public class MidiaDigital extends ItemBiblioteca {

    public MidiaDigital(String titulo, String autor) {
        super();
        this.titulo = titulo;
        this.autor = autor;
        this.isDisponivel = true;
    }

    @Override
    public void emprestar() {
        if(!isDisponivel){
            throw new ItemNaoDisponivelException("Midia emprestada");
        }
        this.isDisponivel = false;
    }

    @Override
    public void devolver() {
        this.isDisponivel = true;
    }
}
