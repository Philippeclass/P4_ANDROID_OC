package com.philippe.mareu.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;
import com.philippe.mareu.events.DeleteMeetingEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MeetingFragment meetingFragment = new MeetingFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, meetingFragment).commit();

        /**
        FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, new Fragment());
        fragmentTransaction.commit();
         **/


    }







}
