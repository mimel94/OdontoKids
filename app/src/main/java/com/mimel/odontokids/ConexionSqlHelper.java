package com.mimel.odontokids;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import utilidades.Utilidades;

/**
 * Created by mimel on 6/04/18.
 */

public class ConexionSqlHelper extends SQLiteOpenHelper {


    public ConexionSqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_PUNTO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int VersionNueva) {
        db.execSQL("DROP TABLE IF EXISTS puntos");
        onCreate(db);
    }
}
