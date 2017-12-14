package com.example.teilnehmer.sportapp.task;

import com.example.teilnehmer.sportapp.protocol.SignoffRequest;

/**
 * Created by Teilnehmer on 14.12.2017.
 */

public class SignoffTask extends BaseHttpRequestTask {
    private final String station;

    public SignoffTask(String station) {
        this.station = station;
    }

    public void execute() {
        SignoffRequest sr = new SignoffRequest(station);
        String json = serialize(sr);
    }

    @Override
    protected void onPostExecute(String json) {

    }
}
