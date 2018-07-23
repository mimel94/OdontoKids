package com.mimel.odontokids;


import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import utilidades.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 */
public class AtipicaDeglucionFragment extends Fragment {


    public AtipicaDeglucionFragment() {
        // Required empty public constructor
    }

    private Spinner options;
    private VideoView videoView;
    private ImageView imageLogo;
    Dialog customDialog;
    Button negativePopupBtn;


    private String nameTherapy [] = {"1)Masaje con manos","2)Masajeador","3)Cepillado de lengua","4)Cauchito",
            "5)Dulce","6)AOI","7)Mover labios","8)Inflar bomba","9)Tarjeta","10)Caballo","11)Lalala!",
            "12)Circulos con la lengua"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_atipica_deglucion, container, false);

        options = (Spinner) rootView.findViewById(R.id.listPraxias);
        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        imageLogo = (ImageView)rootView.findViewById(R.id.imageView2);
        customDialog = new Dialog(getActivity());




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.videos_deglution_atipical, android.R.layout.simple_spinner_dropdown_item);
        options.setAdapter(adapter);

        options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageLogo.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                if(i == 0){
                    imageLogo.setVisibility(View.VISIBLE);
                    videoView.setVisibility(View.INVISIBLE);
                }else if (i == 1){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.masajeconmanos;
                    playVideo(videoPath);
                }else if (i == 2){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.masajeador;
                    playVideo(videoPath);
                }else if (i == 3){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.cepilladoconlalengua;
                    playVideo(videoPath);
                }else if (i == 4){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.cauchito;
                    showNegativePopup(videoPath);
                }else if (i == 5){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.dulce;
                    playVideo(videoPath);
                }else if (i == 6){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.aoi;
                    playVideo(videoPath);
                }
                else if (i == 7){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.moverlabios;
                    playVideo(videoPath);
                }else if (i == 9){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.tarjeta;
                    playVideo(videoPath);
                }else if (i == 8){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.inflarbomba;
                    showNegativePopup(videoPath);
                }else if (i == 11){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.lalala;
                    playVideo(videoPath);
                }else if (i == 10){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.caballo;
                    playVideo(videoPath);
                }else if (i == 12){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.circuloconlalengua;
                    playVideo(videoPath);
                }else{
                    Toast.makeText(getActivity(),"Que estraño esta opción no esta :O", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

    private void playVideo(String videoPath) {
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();
    }

    private void showNegativePopup(final String videoPath) {
        videoView.pause();
        customDialog.setContentView(R.layout.custom_popup_negative);
        negativePopupBtn = (Button) customDialog.findViewById(R.id.negativeContinueBtn);
        negativePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
                Uri uri = Uri.parse(videoPath);
                videoView.setVideoURI(uri);
                videoView.start();
            }
        });
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.show();
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
