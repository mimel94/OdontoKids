package com.mimel.odontokids;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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
import android.widget.Toast;
import android.widget.VideoView;

import utilidades.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 */
public class PraxiasFragment extends Fragment {


    public PraxiasFragment() {
        // Required empty public constructor
    }

    private ListView lv1;
    private VideoView videoView;
    private ImageView imageLogo;
    private ImageButton soundButon;
    private MediaPlayer mp;


    private String nameTherapy [] = {"1) Lapiz","2) Arequipe","3) Froot","4) Cuchara","5) Pitillo","6) boton"};
            /*,"Morder","Lengua","Lengua a mejillas","Hacer beso","Vibrar labios","Cauchito",
            "Dulce","AOI","Mover labios","Tarjeta","Inflar bomba","Lalala!",
            "Caballo","Circulos con la lengua"*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_praxias, container, false);

        lv1 = (ListView)  rootView.findViewById(R.id.listPraxias);
        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        imageLogo = (ImageView) rootView.findViewById(R.id.imageView2);
        soundButon = (ImageButton) rootView.findViewById(R.id.objetivoSound);
        mp = MediaPlayer.create(getActivity(), R.raw.succion);
        soundButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getActivity(), R.layout.list_item_therapy, nameTherapy );
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                imageLogo.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                if (i == 0){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.lapiz;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);


                }else if (i == 1){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.arequipe;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 2){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.frootloops;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }
                else if (i == 3){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.cuchara;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 4){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.pitillo;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 5){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.boton;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 11){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.cauchito;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 12){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.dulce;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 13){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.aoi;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }
                else if (i == 14){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.moverlabios;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 15){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.tarjeta;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 16){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.inflarbomba;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 17){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.lalala;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 18){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.caballo;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 19){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.circuloconlalengua;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }
                else{
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
                Toast.makeText(getActivity(),"Se completo",Toast.LENGTH_SHORT).show();
            }
        });


        // Inflate the layout for this fragment
        return rootView ;



    }



}
