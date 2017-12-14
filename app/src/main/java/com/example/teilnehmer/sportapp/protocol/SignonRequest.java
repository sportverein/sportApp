package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by Teilnehmer on 13.12.2017.
 */

public class SignonRequest {
    private String host;
    private int station;

    public SignonRequest(String host, int station) {
        this.host = host;
        this.station = station;
    }

    public String getHost() {
        return host;
    }

    public int getStation() {
        return station;
    }
}
