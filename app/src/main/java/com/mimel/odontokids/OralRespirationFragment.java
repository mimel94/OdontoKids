package com.mimel.odontokids;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class OralRespirationFragment extends Fragment {



    public OralRespirationFragment() {
        // Required empty public constructor
    }

    private ListView lv1;
    private VideoView videoView;
    private ImageView imageLogo;
    private ImageButton soundButon;
    private MediaPlayer mp;



    private String nameTherapy [] = {"1)Velas","2)Cantar","3)Soplar pelota","4)Morder",
            "5)Lengua","6)Lengua a mejillas","7)Hacer beso","8)Vibrar labios"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_oral_respiration, container, false);
        lv1 = (ListView) rootView.findViewById(R.id.listPraxias);
        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        imageLogo = (ImageView)rootView.findViewById(R.id.imageView2);
        soundButon = (ImageButton) rootView.findViewById(R.id.objetivoSound);
        mp = MediaPlayer.create(getActivity(), R.raw.oral);
        soundButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });



        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getActivity(), R.layout.list_item_therapy, nameTherapy );
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageLogo.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                if (i == 0){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.apagarvela;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);

                }else if (i == 1){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.cantarconlabocacerrada;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }else if (i == 2){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.soplarpelota;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                }
                else if (i == 4){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.lenaguaanarizyluegoabarbilla;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);

                }else if (i == 5){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.lenguaenmejillas;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);

                }
                else if (i == 6){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.hacerbeso;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);

                }
                else if (i == 3){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.morder;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);

                }else if (i == 7){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.vibrarlabios;
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




        return rootView;
    }

}
