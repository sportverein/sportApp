package com.example.teilnehmer.sportapp.task;

import android.widget.Toast;

import com.example.teilnehmer.sportapp.MainActivity;
import com.example.teilnehmer.sportapp.protocol.Command;
import com.example.teilnehmer.sportapp.protocol.SenddataRequest;
import com.example.teilnehmer.sportapp.protocol.SenddataResponse;
import com.example.teilnehmer.sportapp.protocol.SignonResponse;

/**
 * Created by F. Jetzinger on 14.12.2017.
 */

public class SenddataTask extends BaseHttpRequestTask{
    private int station;
    private String schoolclass;
    private int points;
    private String host;
    private final MainActivity mainActivity;

    public SenddataTask(int station, String schoolclass, int points, String host, MainActivity mainActivity) {
        this.station = station;
        this.schoolclass = schoolclass;
        this.points = points;
        this.host = host;
        this.mainActivity = mainActivity;
    }

    public void execute(){
        SenddataRequest senddataRequest = new SenddataRequest(station, schoolclass, points);
        String json = serialize(senddataRequest);

        super.execute(host, Command.senddata, json);
    }
    @Override
    protected void onPostExecute(String json) {

        SenddataResponse senddataResponse = (SenddataResponse) deserialize(json, SenddataResponse.class);
        if(senddataResponse.isSuccess()) {
            Toast.makeText(mainActivity, "Punkte erfolgreich eingetragen", Toast.LENGTH_LONG).show();
            mainActivity.RefreshSchoolclasses();
        } else {
            Toast.makeText(mainActivity, "eintragen fehlgeschlagen!", Toast.LENGTH_LONG).show();
        }


    }
}
