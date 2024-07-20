package org.example.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Banco {

    private List<ContaBancaria> contas;

    public Banco(){
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta){
        this.contas.add(conta);
    }

    public ContaBancaria buscarConta(int numeroConta){
        for(var c:contas){
            if(c.getNumeroConta() == numeroConta){
                return c;
            }
        }
        return null;
    }

    public void listarContas(){
        for(var c:this.contas){
            System.out.println(c.toString());
        }
    }
}
