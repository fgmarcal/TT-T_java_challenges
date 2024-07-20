package org.example.modules.domain;

public abstract class ItemBiblioteca {

    protected String titulo;
    protected String autor;
    protected boolean isDisponivel;

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract void emprestar();

    public abstract void devolver();

    @Override
    public String toString() {
        return "Título: " + this.titulo +"\nAutor: " + this.autor + "\nDisponível para retirada: " + this.isDisponivel;
    }
}
