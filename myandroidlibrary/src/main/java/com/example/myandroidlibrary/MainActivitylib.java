package com.example.myandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivitylib extends AppCompatActivity {

    public static String JOKE_KEY = "Joke key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitylib);

        Intent i = getIntent();
        String joke= i.getStringExtra(JOKE_KEY);
        TextView tv = (TextView) findViewById(R.id.tv1);
        if(tv!=null)
        {
            tv.setText(joke);
        }

    }
}
