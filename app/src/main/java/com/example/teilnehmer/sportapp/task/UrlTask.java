package com.example.teilnehmer.sportapp.task;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Teilnehmer on 15.12.2017.
 */

public class UrlTask extends AsyncTask<String, String, Boolean>  {
    private boolean valid;

    public UrlTask() {

    }

    @Override
    protected Boolean doInBackground(String... urls) {
        try {
            URL url = new URL("http://"+urls[0]);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
        } catch (Exception e) {
            valid = false;
            return valid;
        }
        valid = true;
        return valid;
    }

    @Override
    protected void onPostExecute(Boolean s) {

    }

    public boolean isValid() {
        return valid;
    }
}
