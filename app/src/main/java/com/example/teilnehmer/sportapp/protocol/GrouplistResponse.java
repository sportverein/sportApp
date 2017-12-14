package com.example.teilnehmer.sportapp.protocol;

import java.util.ArrayList;

/**
 * Created by F. Jetzinger on 14.12.2017.
 */

public class GrouplistResponse {
    private ArrayList<String> schoolclasses;
    private boolean success;

    public GrouplistResponse(ArrayList<String> schoolclasses, boolean success) {
        this.schoolclasses = schoolclasses;
        this.success = success;
    }

    public ArrayList<String> getSchoolclasses() {
        return schoolclasses;
    }

    public boolean isSuccess() {
        return success;
    }
}
