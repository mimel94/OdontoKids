package com.mimel.odontokids;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    ImageView logoSonido;
    MediaPlayer mp;
    ImageView imgSound;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        logoSonido = (ImageView)rootView.findViewById(R.id.imageView3);
        imgSound = (ImageView)rootView.findViewById(R.id.img_sound);
        mp = MediaPlayer.create(getActivity(), R.raw.introduccion);
        logoSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               playAndPauseSound();
            }
        });
        imgSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAndPauseSound();
            }
        });



        return rootView;
    }
    public void playAndPauseSound(){
        if(mp.isPlaying()){
            mp.pause();
            imgSound.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
        }else {
            mp.start();
            imgSound.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imgSound.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
            }
        });
    }

}
