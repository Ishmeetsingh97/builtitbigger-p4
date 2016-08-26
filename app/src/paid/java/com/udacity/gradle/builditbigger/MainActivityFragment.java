package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myandroidlibrary.MainActivitylib;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivityFragment extends Fragment implements JokeListener {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        Button button = (Button) root.findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startJokeActivity();
            }
        });


        return root;
    }

    @Override
    public void onReceived(String joke) {
        Intent intent = new Intent(getActivity(), MainActivitylib.class);
        intent.putExtra(MainActivitylib.JOKE_KEY, joke);
        startActivity(intent);
    }

    public void startJokeActivity(){
        new EndpointAsync().execute(this);
    }
}
