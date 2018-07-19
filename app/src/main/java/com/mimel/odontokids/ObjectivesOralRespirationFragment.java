package com.mimel.odontokids;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectivesOralRespirationFragment extends Fragment  {

    private MediaPlayer mp;
    private ImageButton soundButon;
    private CardView cardView;
    private CardView cardView1;
    private CardView cardView2;


    public ObjectivesOralRespirationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_objectives_oral_respiration, container, false);

        mp = MediaPlayer.create(getActivity(), R.raw.oral);
        soundButon = (ImageButton)rootview.findViewById(R.id.objetivoSound);
        soundButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAndPauseSound();
            }
        });
        cardView = (CardView)rootview.findViewById(R.id.cardViewObjectives);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAndPauseSound();
            }
        });
        cardView1 = (CardView)rootview.findViewById(R.id.cardViewObjectives1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAndPauseSound();
            }
        });
        cardView2 = (CardView)rootview.findViewById(R.id.cardViewObjectives2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAndPauseSound();
            }
        });
        return rootview;
    }
    public void playAndPauseSound(){
        if(mp.isPlaying()){
            mp.pause();
            soundButon.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
        }else {
            mp.start();
            soundButon.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                soundButon.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
            }
        });
    }


}
