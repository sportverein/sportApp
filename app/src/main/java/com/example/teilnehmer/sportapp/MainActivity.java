package com.example.teilnehmer.sportapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner view_schoolclasses;
    private ArrayList<String> schoolclasses;

    private TextView tvStation;
    private String station;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_schoolclasses = (Spinner) findViewById(R.id.schoolclasses);
    }

    public void RefreshSchoolclasses(){

    }
}
