package com.mimel.odontokids;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StrengthMusclekFragment extends Fragment {


    public StrengthMusclekFragment() {
        // Required empty public constructor
    }

    private ListView lv1;
    private VideoView videoView;
    private ImageView imageLogo;


    private String nameTherapy [] = {"Cepillado de lengua"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_strength_musclek, container, false);
        lv1 = (ListView) rootView.findViewById(R.id.listPraxias);
        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        imageLogo = (ImageView)rootView.findViewById(R.id.imageView2);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getActivity(), R.layout.list_item_therapy, nameTherapy );
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageLogo.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                if (i == 0){
                    String videoPath = "android.resource://"+getActivity().getPackageName() + "/" + R.raw.cepilladoconlalengua;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);


                } else{
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
