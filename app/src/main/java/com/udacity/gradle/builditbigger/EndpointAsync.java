package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.warmachine.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


public class EndpointAsync extends AsyncTask<JokeListener,Void,String> {

    private static MyApi myApiService = null;
    private JokeListener listener;

    @Override
    protected String doInBackground(JokeListener... params) {

        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://reflected-flux-141512.appspot.com/_ah/api/");


            myApiService = builder.build();
        }

        listener = params[0];

        try {
            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        listener.onReceived(result);
    }

}
