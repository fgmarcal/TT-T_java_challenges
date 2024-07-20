package org.example;

import org.example.modules.Banco;
import org.example.modules.ContaBancaria;

public class Main {
    public static void main(String[] args) {

        Banco banco1 = new Banco();

        ContaBancaria conta1 = new ContaBancaria("José da Silva", 999);
        ContaBancaria conta2 = new ContaBancaria("Joana da Silva", 1000);

        banco1.adicionarConta(conta1);
        banco1.adicionarConta(conta2);

        banco1.listarContas();

        var result = banco1.buscarConta(999);
        System.out.println(result);

        conta1.depositar(100);
        System.out.println(conta1.verificarSaldo());

        conta1.transferir(conta2, 200);
        System.out.println(conta1.verificarSaldo());

        System.out.println(conta2.verificarSaldo());

        conta1.sacar(90);
        System.out.println(conta1.verificarSaldo());

    }
}