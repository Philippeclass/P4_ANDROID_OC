package com.philippe.mareu.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;
import com.philippe.mareu.di.DI;
import com.philippe.mareu.events.AddMeetingEvent;
import com.philippe.mareu.events.DeleteMeetingEvent;
import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.model.Place;
import com.philippe.mareu.service.MeetingApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

public class MeetingFragment extends Fragment implements MyDialogFragment.MyDialogFragmentListener {

    private MeetingApiService mApiService;
    private List<Meeting> mMeetings;
    private RecyclerView mRecyclerView;
    private MeetingRecyclerViewAdapter mAdapter;
    private Meeting mMeeting;
    private AddMeetingFragment mAddMeetingFragment;
    private static final String TAG = "MainFragment";
    @BindView(R.id.sort_By_Place)
    public MenuItem mMenuItem;
    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mAddMeetingButton;



    private static final String SELECTED_ITEM_POSITION = "ItemPosition";
    private int mPosition;

    /**
     * Create and return a new instance
     * is created at each fragment change
     *
     * @return @{@link MeetingFragment}
     */
    public static MeetingFragment newInstance() {
        MeetingFragment fragment = new MeetingFragment();
        Bundle args = new Bundle();
        // pass BUNDLE variable in Fragment
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getMeetingApiService();
        setHasOptionsMenu(true);


    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        return view;

    }


    private void showDateTimeDialog() {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Date date = calendar.getTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                initList(mApiService.sortByDates(simpleDateFormat.format(date)));


            }
        };

        new DatePickerDialog(getContext(), dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

    private void showPlaceDialog() {

        FragmentManager fm = getFragmentManager();
        MyDialogFragment showDialogFragment = new MyDialogFragment();
        showDialogFragment.setTargetFragment(MeetingFragment.this, 0);
        showDialogFragment.show(fm, "fragment_sort");

    }


    /**
     * Init the List of meetings
     */
    private void initList(List<Meeting> meetings) {

        mRecyclerView.setAdapter(new MeetingRecyclerViewAdapter(meetings));

    }

    private void sortList() {
        Collections.sort(mMeetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.sort_By_Date:

                Log.d("message", "test");

                showDateTimeDialog();
                return true;
            case R.id.sort_By_Place:
                Log.d("message2", "test2");
                showPlaceDialog();
                return true;

            case R.id.reset_sort:
                Log.d("message3", "test3");
                initList(mApiService.getMeetings());
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        initList(mApiService.getMeetings());
    }

    /**
     * Fired if the user clicks on a delete button
     *
     * @param event
     */
    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event) {
        mApiService.deleteMeeting(event.meeting);
        initList(mApiService.getMeetings());
    }

    /**
     * Fired if the user clicks on a delete button
     *
     * @param event
     */
    @Subscribe
    public void onAddMeeting(AddMeetingEvent event) {
        mApiService.addMeeting(event.meeting);
        initList(mApiService.getMeetings());
    }


    @Override
    public void onClickPlaceDialogCall(MyDialogFragment myDialogFragment, Place place) {
        initList(mApiService.sortByPlaces(place));
    }
}











