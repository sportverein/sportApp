package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by Teilnehmer on 14.12.2017.
 */

public class SignoffResponse {
    private boolean success;
    private String message;

    public SignoffResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
