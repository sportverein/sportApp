package com.example.teilnehmer.sportapp.task;

import android.widget.Toast;

import com.example.teilnehmer.sportapp.MainActivity;
import com.example.teilnehmer.sportapp.protocol.Command;
import com.example.teilnehmer.sportapp.protocol.GrouplistRequest;
import com.example.teilnehmer.sportapp.protocol.GrouplistResponse;
import com.example.teilnehmer.sportapp.protocol.SignonRequest;
import com.example.teilnehmer.sportapp.protocol.SignonResponse;

/**
 * Created by F. Jetzinger on 14.12.2017.
 */

public class GrouplistTask extends BaseHttpRequestTask {
    private int station;
    private MainActivity mainActivity;
    private String host;

    public GrouplistTask(int station, MainActivity mainActivity, String host) {
        this.station = station;
        this.mainActivity = mainActivity;
        this.host = host;
    }

    public void execute() {
        // TODO: attempt authentication against a network service.
        GrouplistRequest grouplistRequest = new GrouplistRequest(station);
        String json = serialize(grouplistRequest);

        super.execute(host, Command.grouplist, json);
    }

    @Override
    protected void onPostExecute(String json) {

        GrouplistResponse grouplistResponse = (GrouplistResponse) deserialize(json, GrouplistResponse.class);

        if (grouplistResponse.isSuccess()) {
            Toast.makeText(mainActivity, "Klassen erfogreich übertragen", Toast.LENGTH_LONG).show();
            mainActivity.RefreshSchoolclasses();
        } else {
            Toast.makeText(mainActivity, "Klassenübertragung fehlgeschlagen!", Toast.LENGTH_LONG).show();
        }

    }
}
