package com.example.databaselearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


//Faz toda operação do banco de dados, cadastra, alterar e remove os contatos.

public class Four_ContactsDAO {

    private final String Table_Agenda = "Agenda";
    private Two_DbGateway gw;

    public Four_ContactsDAO(Context ctx){
        gw = Two_DbGateway.getInstance(ctx);
    }

    public boolean Cadastrar(String nome, String telefone){

        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Telefone",telefone);

        return gw.getDatabase().insert(Table_Agenda, null, cv) > 0;
    }

    public boolean Alterar(int id, String nome, String telefone){

        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Telefone",telefone);

        return gw.getDatabase().update(Table_Agenda, cv, "ID=?", new String[]{id+""}) > 0;
    }

    public boolean Remover(int id){

        return gw.getDatabase().delete(Table_Agenda, "ID=?", new String[]{id+""}) > 0;
    }

    //Leitura do banco de dados,  trás tudo que está cadastrado.

    List<Three_Contacts> contacts = new ArrayList<>();

    public List<Three_Contacts> getContacts() {

        try{
            Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Agenda", null );

            //Agendas com mais de 1 resultado
            while (cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String nome = cursor.getString(cursor.getColumnIndex("Nome"));
                String telefone = cursor.getString(cursor.getColumnIndex("Telefone"));

                contacts.add(new Three_Contacts(id,nome,telefone));
                }
            cursor.close();
        }catch (Exception error){
            Log.d("erro", error.getMessage().toString());
        }
        return contacts;
    }
}