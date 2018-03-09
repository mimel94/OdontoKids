package com.mimel.odontokids;


import android.media.Image;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;




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


    private String nameTherapy [] = {"Lapiz","Arequipe","Froot","Cuchara","Pitillo","boton","Lengua",
                                    "Lengua a mejillas","Hacer beso","Morder","Vibrar labios","Cauchito",
                                    "Dulce","AOI","Mover labios","Tarjeta","Inflar bomba","Lalala!",
                                    "Caballo","Circulos con la lengua"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_praxias, container, false);

        lv1 = (ListView)  rootView.findViewById(R.id.listPraxias);
        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        imageLogo = (ImageView) rootView.findViewById(R.id.imageView2);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getActivity(), R.layout.list_item_praxias, nameTherapy );
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
                }
                else if (i == 6){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.lenaguaanarizyluegoabarbilla;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 7){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.lenguaenmejillas;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }
                else if (i == 8){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.hacerbeso;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }
                else if (i == 9){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.morder;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.setBackground(null);
                }else if (i == 10){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.vibrarlabios;
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









        // Inflate the layout for this fragment
        return rootView ;



    }

}
