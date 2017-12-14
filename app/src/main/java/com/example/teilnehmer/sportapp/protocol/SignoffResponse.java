package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by Teilnehmer on 14.12.2017.
 */

public class SignoffResponse {
    private boolean success;

    public SignoffResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
