package org.example.modules.Entity.User;

public class User {

    private int id;
    private String nome;
    private String email;
    private int idade;

    private static int counter;

    public User(String nome, String email, int idade) {
        counter++;
        this.id = counter;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getId(){
        return id;
    }

    @Override
    public int hashCode() {
        return email == null && nome == null ? 0 : this.email.hashCode()+this.nome.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return user != null && user.getNome() == ((User) obj).getNome() && user.getEmail() == ((User) obj).getEmail();
    }

    @Override
    public String toString() {
        return "\nUsuário: "+ "\nid: "+ this.getId() +  "\nNome: " + this.getNome() + "\nE-mail: " + this.getEmail();
    }
}
