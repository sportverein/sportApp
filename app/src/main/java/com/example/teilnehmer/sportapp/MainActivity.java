package com.example.teilnehmer.sportapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import android.widget.Button;
import android.widget.EditText;
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

    private TextView tvStation;
    private String station;
    private EditText etPoints;

    private String host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        station = getIntent().getExtras().getString(LoginActivity.STATION);
        host = getIntent().getExtras().getString(LoginActivity.HOST);

        tvStation = (TextView) findViewById(R.id.tv_station);
        view_schoolclasses = (Spinner) findViewById(R.id.s_schoolclasses);
        btnSignoff = (Button) findViewById(R.id.btn_signoff);
        etPoints = (EditText) findViewById(R.id.et_punkte);

        tvStation.setText(getString(R.string.tv_station)+" "+station);

        GrouplistTask grouplistTask = new GrouplistTask(Integer.parseInt(station),this, host);
        grouplistTask.execute();
    }



    public void setSchoolclasses(ArrayList<String> schoolclasses) {
        this.schoolclasses = schoolclasses;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, schoolclasses);
        view_schoolclasses.setAdapter(adapter);

        adapter.notifyDataSetChanged();

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
        Toast.makeText(this, actItem, Toast.LENGTH_LONG).show();
        String actPoints = etPoints.getText().toString();
        if(actPoints.length()>0){
            SenddataTask senddataTask = new SenddataTask(Integer.parseInt(station), actItem, Integer.parseInt(actPoints),host,this);
            senddataTask.execute();
        }
        else{
            Toast.makeText(this, "Bitte Punkte eingeben!", Toast.LENGTH_LONG).show();
        }
    }
}
