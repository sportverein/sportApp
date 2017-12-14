package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by F. Jetzinger on 14.12.2017.
 */

public class SenddataRequest {
    private int station;
    private String schoolclass;
    private int points;



    public SenddataRequest(int station, String schoolclass, int points) {

        this.station = station;
        this.schoolclass = schoolclass;
        this.points = points;
    }

    public int getStation() {
        return station;
    }

    public String getSchoolclass() {
        return schoolclass;
    }

    public int getPoints() {
        return points;
    }
}
