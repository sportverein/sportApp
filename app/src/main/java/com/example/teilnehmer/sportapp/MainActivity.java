package com.example.teilnehmer.sportapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import android.widget.Spinner;
import android.widget.TextView;

import com.example.teilnehmer.sportapp.task.GrouplistTask;

public class MainActivity extends AppCompatActivity {

    private Spinner view_schoolclasses;
    private ArrayList<String> schoolclasses;

    private TextView tvStation;
    private String station;

    private String host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        station = getIntent().getExtras().getString(LoginActivity.STATION);
        host = getIntent().getExtras().getString(LoginActivity.HOST);

        tvStation = (TextView) findViewById(R.id.tv_station);
        view_schoolclasses = (Spinner) findViewById(R.id.s_schoolclasses);

        tvStation.setText(getString(R.string.tv_station)+" "+station);

        RefreshSchoolclasses();
    }

    public void RefreshSchoolclasses(){
        GrouplistTask grouplistTask = new GrouplistTask(Integer.parseInt(station),this, host);
        grouplistTask.execute();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, schoolclasses);
        view_schoolclasses.setAdapter(adapter);
        for(String s: schoolclasses){
            adapter.add(s);
            adapter.notifyDataSetChanged();
        }

    }
}
