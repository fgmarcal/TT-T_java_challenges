package org.example.modules;

public class ContaBancaria {

    private String titular;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String titular, int numeroConta){
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0;
    }

    public int getNumeroConta(){
        return this.numeroConta;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente para operação");
        }else{
            this.saldo -= valor;

        }
    }

    public double verificarSaldo(){
        return this.saldo;
    }

    public void transferir(ContaBancaria contaDestino, double valor){
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente para operação");
        }else{
            this.saldo -= valor;
            contaDestino.depositar(valor);
        }
    }

    @Override
    public String toString() {
        return "Titular: " + this.titular + "\nConta: " + this.numeroConta;
    }
}
