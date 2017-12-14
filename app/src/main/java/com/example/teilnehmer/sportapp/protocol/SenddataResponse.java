package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by F. Jetzinger on 14.12.2017.
 */

public class SenddataResponse {
    private boolean success;

    public SenddataResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
