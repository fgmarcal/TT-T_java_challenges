package org.example;

import org.example.modules.domain.ItemBiblioteca;
import org.example.modules.domain.Livro.Livro;
import org.example.modules.domain.MidiaDigital.MidiaDigital;
import org.example.modules.domain.Periodico.Periodico;
import org.example.modules.exception.ItemNaoDisponivelException;
import org.example.modules.exception.ItemNaoEncontradoException;
import org.example.modules.interfaces.Gerenciavel;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements Gerenciavel {

    private List<ItemBiblioteca> acervo;

    public Biblioteca(){
        this.acervo = new ArrayList<>();
    }

    @Override
    public void adicionarItem(ItemBiblioteca item) {
        this.acervo.add(item);
        item.devolver();
    }

    @Override
    public void removerItem(ItemBiblioteca item) {
        this.acervo.remove(item);
    }

    public void emprestarItem(ItemBiblioteca item){
        item.emprestar();
    }

    public void devolverItem(ItemBiblioteca item){
        item.devolver();
    }

    @Override
    public ItemBiblioteca buscarItem(String titulo) throws ItemNaoEncontradoException {
       List<ItemBiblioteca> temp = new ArrayList<>();
        for (ItemBiblioteca itemBiblioteca : this.acervo) {
            if ((itemBiblioteca.getTitulo().equals(titulo) || itemBiblioteca.getTitulo().contains(titulo))) {
                temp.add(itemBiblioteca);
            }
        }
        if(temp.isEmpty()) throw new ItemNaoEncontradoException("Item não existe no acervo");
        return temp.getFirst();
    }


    public static void main(String[] args) {

        Biblioteca lib = new Biblioteca();

        ItemBiblioteca livro1 = new Livro("O senhor dos aneis", "Tolkien");
        ItemBiblioteca periodico1 = new Periodico("Sessão de Esportes", "Folha de São Paulo");
        ItemBiblioteca midiaDigital1 = new MidiaDigital("Enciclopédia Barça", "Barça");


        lib.adicionarItem(livro1);
        lib.adicionarItem(periodico1);
        lib.adicionarItem(midiaDigital1);

        lib.emprestarItem(periodico1);

        try {
            ItemBiblioteca esportes = lib.buscarItem("Sessão");
            System.out.println(esportes);
        }catch (ItemNaoEncontradoException | ItemNaoDisponivelException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }



    }
}