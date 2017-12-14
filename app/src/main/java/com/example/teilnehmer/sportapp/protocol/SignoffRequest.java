package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by Teilnehmer on 14.12.2017.
 */

public class SignoffRequest {
    private int station;

    public SignoffRequest(int station) {
        this.station = station;
    }

    public int getStation() {
        return station;
    }
}
