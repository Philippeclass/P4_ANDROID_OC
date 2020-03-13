package com.philippe.mareu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;
import com.philippe.mareu.events.DeleteMeetingEvent;
import com.philippe.mareu.model.Meeting;

import org.greenrobot.eventbus.EventBus;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mAddMeetingButton;
    public static final String BUNDLE_EXTRA_MEETING = "BUNDLE_EXTRA_MEETING";
    private List<Meeting> mMeetingList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MeetingFragment meetingFragment = new MeetingFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, meetingFragment).commit();

        mAddMeetingButton = findViewById(R.id.btn_add_meeting);
        mAddMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    Intent intent = new Intent(MainActivity.this, AddMeetingFragment.class);
                    startActivity(intent);

                }
            }
        });



        /**
         FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
         fragmentTransaction.add(R.id.container, new Fragment());
         fragmentTransaction.commit();
         **/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.menu_activity_main, menu);
         return true;

    }
}
