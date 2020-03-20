package com.example.databaselearning;

import java.io.Serializable;

// Cria atributos que são as colunas do banco de dados.
// A classe implementa serializable porque transmite informações do objeto contato para outra tela

public class Three_Contacts implements Serializable {

    private int ID;
    private String Name;
    private String Telefone;

    public Three_Contacts(int ID, String name, String telefone) {
        this.ID = ID;
        Name = name;
        Telefone = telefone;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getTelefone() {
        return Telefone;
    }
}
