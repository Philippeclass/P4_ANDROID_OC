package com.philippe.mareu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mAddMeetingButton;
    @BindView(R.id.list_meeting)
    RecyclerView mRecyclerViewMeeting;
    public static final String BUNDLE_EXTRA_MEETING = "BUNDLE_EXTRA_MEETING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MeetingFragment meetingFragment = new MeetingFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, meetingFragment).commit();

        mAddMeetingButton = findViewById(R.id.btn_add_meeting);
        mAddMeetingButton.setOnClickListener(v -> {
            {

                Intent intent = new Intent(MainActivity.this, AddMeetingFragment.class);
                startActivity(intent);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;

    }

}
