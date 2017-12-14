package com.example.teilnehmer.sportapp.protocol;

/**
 * Created by Teilnehmer on 13.12.2017.
 */


public enum Command {

    signon("signon"), grouplist("grouplist"), senddata("senddata"), message(
            "message"), signoff("signoff");

    private String text;

    private Command(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static Command fromString(String text) {

        if (text == null) {
            return null;
        }

        for (Command c : Command.values()) {
            if (c.text.equals(text)) {
                return c;
            }
        }

        return null;

    }

}

