package org.example;

import org.example.modules.Controller.UserController;
import org.example.modules.Entity.User.CreateUserDTO;

import java.util.Scanner;

public class Main {

    private static CreateUserDTO criarUsuario(String nome, String email, int idade){
        return new CreateUserDTO(nome, email, idade);
    }

    private static UserController chamaController(){
        return new UserController();
    }

    public static void main(String[] args) {
        System.out.println("######################################## SISTEMA DE REGISTRO DE USUARIO ########################################");
        CreateUserDTO dto;
        UserController controller = new UserController();
        while (true){
            System.out.println("Selecione uma opção");
            System.out.println("1- Cadastrar um usuário");
            System.out.println("2- Deletar um usuário");
            System.out.println("3- Buscar um usuário por nome");
            System.out.println("4- Buscar um usuário por email");
            System.out.println("5- Listar todos os usuários");
            System.out.println("6- Sair");

            int option = new Scanner(System.in).nextInt();


            switch (option){
                case 1:
                    System.out.println("Insira o nome: ");
                    String inputName = new Scanner(System.in).nextLine();
                    System.out.println("Insira o email: ");
                    String inputEmail = new Scanner(System.in).nextLine();
                    System.out.println("Insira a idade: ");
                    int inputIdade = new Scanner(System.in).nextInt();
                    dto = new CreateUserDTO(inputName, inputEmail, inputIdade);
                    controller.createUser(dto);
                    break;
                case 2:
                    System.out.println("Selecione o id do usuário que deseja deletar: ");
                    var list = controller.getAllUsers();
                    System.out.println(list);
                    int inputId = new Scanner(System.in).nextInt();
                    controller.deleteUser(inputId);
                    break;
                case 3:
                    System.out.println("Escreva o nome que deseja buscar");
                    inputName = new Scanner(System.in).nextLine();
                    var name = controller.getUserByName(inputName);
                    System.out.println(name);
                    break;
                case 4:
                    System.out.println("Escreva o email que deseja buscar");
                    inputEmail = new Scanner(System.in).nextLine();
                    var email = controller.getUserByName(inputEmail);
                    System.out.println(email);
                    break;
                case 5:
                    var getAllUsers = controller.getAllUsers();
                    System.out.println(getAllUsers);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}