package com.philippe.mareu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;
import com.philippe.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mAddMeetingButton;
    @BindView(R.id.list_meeting)
    RecyclerView mRecyclerViewMeeting;
    public static final String BUNDLE_EXTRA_MEETING = "BUNDLE_EXTRA_MEETING";
    private List<Meeting> mMeetingList;
    public static  String LIST_STATE_MEETING = "BUNDLE_STATE_MEETING";
private ArrayList<Meeting> mMeetingArrayList = new  ArrayList<>();
private Parcelable mSavedRecyclerLayoutState;

    private static final String SELECTED_ITEM_POSITION = "ItemPosition";
    private int mPosition;
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
