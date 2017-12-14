package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by Teilnehmer on 14.12.2017.
 */

public class SignoffRequest {
    private String station;

    public SignoffRequest(String station) {
        this.station = station;
    }

    public String getStation() {
        return station;
    }
}
