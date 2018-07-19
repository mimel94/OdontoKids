package com.mimel.odontokids;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.lang.reflect.Array;

import utilidades.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 */
public class AtipicaDeglucionFragment extends Fragment {


    public AtipicaDeglucionFragment() {
        // Required empty public constructor
    }

    private ListView lv1;
    private VideoView videoView;
    private ImageView imageLogo;


    private String nameTherapy [] = {"1)Masaje con manos","2)Masajeador","3)Cepillado de lengua","4)Cauchito",
            "5)Dulce","6)AOI","7)Mover labios","8)Inflar bomba","9)Tarjeta","10)Caballo","11)Lalala!",
            "12)Circulos con la lengua"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_atipica_deglucion, container, false);

        lv1 = (ListView) rootView.findViewById(R.id.listPraxias);
        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        imageLogo = (ImageView)rootView.findViewById(R.id.imageView2);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_therapy, nameTherapy );
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageLogo.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                if (i == 0){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.masajeconmanos;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);


                }else if (i == 1){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.masajeador;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 2){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.cepilladoconlalengua;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);

                }else if (i == 3){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.cauchito;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 4){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.dulce;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 5){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.aoi;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }
                else if (i == 6){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.moverlabios;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 8){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.tarjeta;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 7){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.inflarbomba;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 10){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.lalala;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 9){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.caballo;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 11){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.circuloconlalengua;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else{
                    Toast.makeText(getActivity(),"Que estraño esta opción no esta :O", Toast.LENGTH_SHORT).show();
                }
                videoView.start();

            }
        });
        MediaController mediaController = new MediaController(getActivity());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                int nuevosPuntos = 10;
                ConexionSqlHelper conn = new ConexionSqlHelper(getActivity(), "Points", null,1);
                int misPuntos = consultarPuntos();
                sumarpuntos(misPuntos, nuevosPuntos);

            }
        });

        return rootView;
    }

    private void sumarpuntos(int misPuntos, int nuevosPuntos) {
        ConexionSqlHelper conn = new ConexionSqlHelper(getActivity(), "Points", null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String id = "1";
        String [] parametros = {id};
        ContentValues values = new ContentValues();
        int agregarPuntos = misPuntos + nuevosPuntos;
        values.put(Utilidades.CAMPO_PUNTOS, agregarPuntos);
        db.update(Utilidades.TABLA_PUNTO, values, Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getActivity(),"Felicidades a sumado "+nuevosPuntos+" puntos!.",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private int consultarPuntos() {
        ConexionSqlHelper conn = new ConexionSqlHelper(getActivity(), "Points", null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        String id = "1";
        String [] parametros = {id};
        String [] campos = {Utilidades.CAMPO_PUNTOS};
        try{
            Cursor cursor = db.query(Utilidades.TABLA_PUNTO,campos, Utilidades.CAMPO_ID+"=?",parametros, null, null, null);
            cursor.moveToFirst();
            String puntos = cursor.getString(0);
            cursor.close();
            return Integer.parseInt(puntos);
        }catch (Exception e){
            return 0;
        }

    }

}
