package org.example;

import com.sun.source.tree.WhileLoopTree;
import org.example.modules.Formulario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Formulario form = new Formulario();
        boolean val1 = true, val2 = true, val3 = true, val4 = true;

        System.out.println("############ FORMULARIO ###############");
        System.out.println("INSIRA SEUS DADOS");
        Scanner input = new Scanner(System.in);

        while(val1){
            System.out.println("CPF: ");
            var cpf = input.nextLine();
            if(form.isCPFValid(cpf)) {
                form.setCpf(cpf);
                val1 = false;
            }else {
                System.out.println("CPF INVÁLIDO");
            }
        }

        while(val2){
            System.out.println("E-mail: ");
            var email = input.nextLine();
            if(form.isEmailValid(email)) {
                form.setEmail(email);
                val2 = false;
            }else{
                System.out.println("E-MAIL INVÁLIDO");
            }
        }

        while(val3){
            System.out.printf("Nome: ");
            var name = input.nextLine();
            if(form.isNameValid(name)) {
                form.setName(name);
                val3 = false;
            }else {
                System.out.println("NOME INVÁLIDO");
            }
        }

        while(val4){
            System.out.println("Sobrenome: ");
            var lastName = input.nextLine();
            if(form.isLastNameValid(lastName)){
                form.setLastName(lastName);
                val4 = false;
            }else {
                System.out.println("SOBRENOME INVÁLIDO");
            }
        }

        System.out.println(form.toString());
    }
}