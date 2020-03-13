package com.philippe.mareu.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;
import com.philippe.mareu.di.DI;
import com.philippe.mareu.events.AddMeetingEvent;
import com.philippe.mareu.events.DeleteMeetingEvent;
import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.service.MeetingApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;

public class MeetingFragment extends Fragment {

    private MeetingApiService mApiService;
    private List<Meeting> mMeetings;
    private RecyclerView mRecyclerView;
    private MeetingRecyclerViewAdapter mAdapter;
    private Meeting mMeeting;



    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mAddMeetingButton;


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



        /**
         mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {

        FragmentTransaction frag = getFragmentManager().beginTransaction();
        frag.replace(R.id.btn_add_meeting, new AddMeetingFragment());
        frag.commit();
        }
        });
         **/

/**
 mSortButton.setOnClickListener(new View.OnClickListener() {
@Override public void onClick(View v) {
sortFromAToZ();

}
});
 **/
        //initList();
        return view;

    }
/**
 public void sortFromAToZ() {
 Collections.sort(mApiService.getMeetings(), Meeting.fromAtoZ);
 initList();

 }
 **/

    /**
     * Init the List of neighbours
     */
    private void initList() {

        mMeetings = mApiService.getMeetings();
        mRecyclerView.setAdapter(new MeetingRecyclerViewAdapter(mMeetings));


    }

    private void sortList() {
        Collections.sort(mMeetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }
    public static void SortDates(List<String> dateList){
        Collections.sort(dateList, new Comparator<String>() {
            DateFormat mDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.FRANCE);
            @Override
            public int compare(String e1, String e2) {
                try {
                    return mDateFormat.parse(e1).compareTo(mDateFormat.parse(e2));
                } catch (ParseException e) {
                    throw  new IllegalArgumentException(e);
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.sort_By_Date:

                Log.d("message", "test");
sortList();

//SortDates();

            return true;
            case R.id.sort_By_Place:
                Log.d("message2", "test2");

                return true;
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
        initList();
    }

    /**
     * Fired if the user clicks on a delete button
     *
     * @param event
     */
    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event) {
        mApiService.deleteMeeting(event.meeting);
        initList();
    }

    /**
     * Fired if the user clicks on a delete button
     *
     * @param event
     */
    @Subscribe
    public void onAddMeeting(AddMeetingEvent event) {
        mApiService.addMeeting(event.meeting);
        initList();
    }


}











