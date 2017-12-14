package com.example.teilnehmer.sportapp.task;

import com.example.teilnehmer.sportapp.MainActivity;
import com.example.teilnehmer.sportapp.protocol.Command;
import com.example.teilnehmer.sportapp.protocol.SignoffRequest;
import com.example.teilnehmer.sportapp.protocol.SignoffResponse;
import com.example.teilnehmer.sportapp.protocol.SignonResponse;

/**
 * Created by Teilnehmer on 14.12.2017.
 */

public class SignoffTask extends BaseHttpRequestTask {
    private final String host;
    private final int station;
    private MainActivity mainActivity;

    public SignoffTask(String host, MainActivity mainActivity, int station) {
        this.host = host;
        this.mainActivity = mainActivity;
        this.station = station;
    }

    public void execute() {
        SignoffRequest signoffRequest = new SignoffRequest(station);
        String json = serialize(signoffRequest);

        super.execute(host, Command.signoff, json);
    }

    @Override
    protected void onPostExecute(String json) {
        SignoffResponse signonResponse = (SignoffResponse) deserialize(json, SignoffResponse.class);

        if(signonResponse.isSuccess()) {
            mainActivity.signoff();
        }
    }
}
