package com.example.databaselearning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//Classe responsavel por criar o banco de dados

public class One_DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="MY_DB.db";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE = "CREATE TABLE Agenda (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nome TEXT NOT NULL, Telefone TEXT NOT NULL);";

    public One_DBhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
