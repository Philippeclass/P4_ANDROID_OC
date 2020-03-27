package com.philippe.mareu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;
import com.philippe.mareu.model.Meeting;

import java.util.List;

import butterknife.BindView;


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




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;

    }


 // private void showDialog() {
 //     FragmentManager fm = getSupportFragmentManager();
 //     MyDialogFragment showDialogFragment = MyDialogFragment.newInstance(0);
 //     showDialogFragment.show(fm, "fragment_sort");
 // }

}
