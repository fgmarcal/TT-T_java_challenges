package org.example;

import org.example.modules.Calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("####################### Calculadora ##############################\n");
        Calculadora calc = new Calculadora();

        System.out.println("1-Adicionar");
        System.out.println("2-Subtrair");
        System.out.println("3-Multiplicar");
        System.out.println("4-Dividir");
        System.out.println("\n");
        System.out.println(" >> ");

        Scanner selection = new Scanner(System.in);
        int selected = selection.nextInt();

        System.out.println("Insira o primeiro valor: ");
        Scanner input1 = new Scanner(System.in);
        double valor1 = input1.nextDouble();
        System.out.println("Insira o segundo valor: ");
        Scanner input2 = new Scanner(System.in);
        double valor2 = input2.nextDouble();

        switch (selected){
            case 1:
                System.out.println("## ADIÇÃO ##");
                var result = calc.adicionar(valor1, valor2);
                System.out.println("Resultado: " + result);
                break;
            case 2:
                System.out.println("## SUBTRAIR ##");
                result = calc.subtrair(valor1, valor2);
                System.out.println("Resultado: " + result);
                break;
            case 3:
                System.out.println("## MULTIPLICAR ##");
                result = calc.multiplicar(valor1, valor2);
                System.out.println("Resultado: " + result);
                break;
            case 4:
                System.out.println("## DIVIDIR ##");
                result = calc.dividir(valor1, valor2);
                System.out.println("Resultado: " + result);
                break;
            default:
                System.out.printf("OPÇÃO INVÁLIDA");

        }

    }
}