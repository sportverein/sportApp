package com.example.teilnehmer.sportapp.protocol;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by F. Jetzinger on 14.12.2017.
 */

public class GrouplistRequest {
    private int station;


    public GrouplistRequest(int station) {
        this.station = station;

    }

    public int getStation() {
        return station;
    }


}
