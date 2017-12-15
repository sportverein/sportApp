package com.example.teilnehmer.sportapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teilnehmer.sportapp.task.GrouplistTask;
import com.example.teilnehmer.sportapp.task.SenddataTask;
import com.example.teilnehmer.sportapp.task.SignoffTask;

public class MainActivity extends AppCompatActivity {

    private Spinner view_schoolclasses;
    private ArrayList<String> schoolclasses;
    private Button btnSignoff;
    private ProgressBar pbProgress;

    private TextView tvStation;
    private String station;
    private EditText etPoints;
    private Button btnSend;

    private String host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnSend.setActivated(false);

        station = getIntent().getExtras().getString(LoginActivity.STATION);
        host = getIntent().getExtras().getString(LoginActivity.HOST);



        tvStation = (TextView) findViewById(R.id.tv_station);
        view_schoolclasses = (Spinner) findViewById(R.id.s_schoolclasses);
        btnSignoff = (Button) findViewById(R.id.btn_signoff);
        etPoints = (EditText) findViewById(R.id.et_punkte);
        pbProgress = (ProgressBar) findViewById(R.id.pb_progress);

        tvStation.setText(getString(R.string.tv_station)+" "+station);

        GrouplistTask grouplistTask = new GrouplistTask(Integer.parseInt(station),this, host);
        grouplistTask.execute();
    }



    public void setSchoolclasses(ArrayList<String> schoolclasses) {
        this.schoolclasses = schoolclasses;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, schoolclasses);
        view_schoolclasses.setAdapter(adapter);
        if(schoolclasses.isEmpty()){
            btnSend.setVisibility(View.INVISIBLE);
            btnSend.setActivated(false);
            Toast.makeText(this, "Alle Stationen eingetragen", Toast.LENGTH_LONG).show();
        }else {
            btnSend.setActivated(true);
        }
        adapter.notifyDataSetChanged();

    }

    public void setProgressbar(int progress) {
        pbProgress.setProgress(progress);
    }

    public void signoff() {
        this.finish();
    }

    public void onClickSignoff(View view) {
        SignoffTask signoffTask = new SignoffTask(host, this,Integer.parseInt(station));
        signoffTask.execute();
    }

    public void onClickSenddata(View view) {
        String actItem = view_schoolclasses.getSelectedItem().toString();
        String actPoints = etPoints.getText().toString();
        if(actPoints.length()>0){
            etPoints.setText("");
            SenddataTask senddataTask = new SenddataTask(Integer.parseInt(station), actItem, Integer.parseInt(actPoints),host,this);
            senddataTask.execute();
        }
        else{
            Toast.makeText(this, "Bitte Punkte eingeben!", Toast.LENGTH_LONG).show();
        }
    }
}
