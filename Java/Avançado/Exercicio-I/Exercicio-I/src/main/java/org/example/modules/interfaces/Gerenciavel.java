package org.example.modules.interfaces;

import org.example.modules.domain.ItemBiblioteca;

public interface Gerenciavel {

    void adicionarItem(ItemBiblioteca item);
    void removerItem(ItemBiblioteca item);
    ItemBiblioteca buscarItem(String titulo);
}
