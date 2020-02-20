package com.philippe.mareu.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MeetingFragment meetingFragment = new MeetingFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, meetingFragment).commit();


    }










}
