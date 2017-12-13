package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by Teilnehmer on 13.12.2017.
 */

public class LoginResponse {
    private boolean success;
    private String message;

    public LoginResponse(boolean success, String message) {
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
