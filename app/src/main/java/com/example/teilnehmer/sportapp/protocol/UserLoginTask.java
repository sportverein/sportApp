package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by Teilnehmer on 14.12.2017.
 */

import android.widget.Toast;

import com.example.teilnehmer.sportapp.BaseHttpRequestTask;
import com.example.teilnehmer.sportapp.LoginActivity;

/**
 * Represents an asynchronous login/registration task used to authenticate
 * the user.
 */
public class UserLoginTask extends BaseHttpRequestTask {

    private final String mHost;
    private final String mStation;
    private final LoginActivity loginActivity;

    public UserLoginTask(String host, String station, LoginActivity activity) {
        mHost = host;
        mStation = station;
        loginActivity = activity;
    }

    protected void execute() {
        // TODO: attempt authentication against a network service.
        SignonRequest lr = new SignonRequest(mHost, Integer.parseInt(mStation));
        String json = serialize(lr);

        super.execute(mHost, Command.signon, json);
    }

    @Override
    protected void onPostExecute(String json) {

        SignonResponse signonResponse = (SignonResponse)deserialize(json, SignonResponse.class);
        if(signonResponse.isSuccess()) {
            Toast.makeText(loginActivity, "Login erfolgreich!", Toast.LENGTH_LONG).show();
            loginActivity.showMainActivity();
        } else {
            Toast.makeText(loginActivity, "Login fehlgeschlagen!", Toast.LENGTH_LONG).show();
        }


    }

}