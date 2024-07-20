package org.example.modules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formulario {

    private String name;
    private String lastName;
    private String cpf;
    private String email;

    public Formulario(){}

    public boolean isNameValid(String name){
        String regexForName = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
        Pattern namePattern = Pattern.compile(regexForName);
        Matcher nameMatcher = namePattern.matcher(name);

        return nameMatcher.find();
    }

    public boolean isLastNameValid(String lastName){
        String regexForLastName = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
        Pattern namePattern = Pattern.compile(regexForLastName);
        Matcher lastNameMatcher = namePattern.matcher(lastName);

        return lastNameMatcher.find();
    }

    public boolean isEmailValid(String email){
        String regexForEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern emailPattern = Pattern.compile(regexForEmail);
        Matcher emailMatcher = emailPattern.matcher(email);

        return emailMatcher.find();
    }

    public boolean isCPFValid(String cpf){
        String regexForCPF = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        Pattern cpfPattern = Pattern.compile(regexForCPF);
        Matcher cpfMatcher = cpfPattern.matcher(cpf);

        return cpfMatcher.find();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dados Cadastrais: \n" + "Nome: " + this.name
                + "\nSobrenome: " + this.lastName
                + "\nCPF: " + this.cpf
                + "\nE-mail: " + this.email;
    }
}
