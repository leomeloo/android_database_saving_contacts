package com.example.databaselearning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

//Evita abrir varias conexões no banco de dados, no padrao singleton
//Abre uma conexão que pode ser editada ( WritetableDatabase )

public class Two_DbGateway {

    private static Two_DbGateway gw;
    private SQLiteDatabase db;

    private Two_DbGateway(Context ctx){
        One_DBhelper helper = new One_DBhelper(ctx);
        db = helper.getWritableDatabase();
    }

    public static Two_DbGateway getInstance(Context ctx){
        if(gw == null)
            gw = new Two_DbGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }

}
