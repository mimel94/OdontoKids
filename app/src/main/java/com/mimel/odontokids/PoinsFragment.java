package com.mimel.odontokids;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import utilidades.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 */
public class PoinsFragment extends Fragment {


    public PoinsFragment() {
        // Required empty public constructor
    }

    private TextView mensajePuntos;
    private Button resetPoints;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_poins, container, false);

        mensajePuntos = (TextView) rootview.findViewById(R.id.txtPoints);
        resetPoints = (Button) rootview.findViewById(R.id.resetBtn);
        resetPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPoin();
                ponerPuntosTxt(0);
            }
        });

        int puntos =consultarPuntos();

        ponerPuntosTxt(puntos);

        return rootview;
    }

    private void ponerPuntosTxt(int puntos) {

        if(puntos==0){
            mensajePuntos.setText("Actualmente Tienes "+puntos+" Puntos!\n animate y empieza a hacer las practicas!");
        }else {
            mensajePuntos.setText("Actualmente Tienes "+puntos+" Puntos!\n Sigue asi!");
        }
    }

    private void resetPoin() {
        ConexionSqlHelper conn = new ConexionSqlHelper(getActivity(),"Points",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String id =  "1";
        String [] parametros = {id};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_PUNTOS, 0);
        db.update(Utilidades.TABLA_PUNTO, values, Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getActivity(),"Sus puntos han vuelto a 0",Toast.LENGTH_SHORT).show();
        db.close();
    }

    public int consultarPuntos() {
        ConexionSqlHelper conn = new ConexionSqlHelper(getActivity(), "Points", null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        String id = "1";
        String [] parametros = {id};
        String [] campos = {Utilidades.CAMPO_PUNTOS};
        try{
            Cursor cursor = db.query(Utilidades.TABLA_PUNTO,campos, Utilidades.CAMPO_ID+"=?",parametros, null, null, null);
            cursor.moveToFirst();
            String puntos = cursor.getString(0);
            //Toast.makeText(getActivity(),"entro"+puntos,Toast.LENGTH_SHORT).show();
            cursor.close();
            return Integer.parseInt(puntos);
        }catch (Exception e){
            //Toast.makeText(getActivity(),"no entro",Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

}
