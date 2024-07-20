package org.example.modules;

public class Calculadora {

    public Calculadora(){

    }

    public double adicionar(double primeiroFator, double segundoFator){
        return primeiroFator + segundoFator;
    }

    public double subtrair(double primeiroFator, double segundoFator){
        return primeiroFator - segundoFator;
    }

    public double multiplicar(double primeiroFator, double segundoFator){
        return primeiroFator * segundoFator;
    }

    public double dividir(double primeiroFator, double segundoFator){
        if(segundoFator == 0){
            return 0;
        }
        return primeiroFator / segundoFator;
    }

}
