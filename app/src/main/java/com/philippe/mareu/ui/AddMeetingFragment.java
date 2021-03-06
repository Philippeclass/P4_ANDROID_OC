package com.philippe.mareu.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.philippe.mareu.R;
import com.philippe.mareu.di.DI;
import com.philippe.mareu.events.AddMeetingEvent;
import com.philippe.mareu.events.DeleteMeetingEvent;
import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.model.Place;
import com.philippe.mareu.service.MeetingApiService;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.philippe.mareu.ui.MainActivity.BUNDLE_EXTRA_MEETING;

public class AddMeetingFragment extends AppCompatActivity {


    @BindView(R.id.name_input)
    EditText mMeetingEdit;
    @BindView(R.id.entrants_input)
    EditText mEntrantEdit;
    @BindView(R.id.place_input)
    GridView mGridView;
    @BindView(R.id.confirm_button)
    Button mOkButton;
    @BindView(R.id.select_room_message)
    TextView mSelect_room;

    private MeetingApiService mApiService;
    private List<Meeting> mMeetings;
    private RecyclerView mRecyclerView;
    Calendar mCalendar = Calendar.getInstance();
    private List<Place> mPlaces;

    TextView date_time_in;

    Meeting mMeeting;

    MeetingApiService mMeetingApiService;

    Place selectedplace;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_meeting_fragment);
        ButterKnife.bind(this);
        mMeetingApiService = DI.getMeetingApiService();
        mMeeting = (Meeting) getIntent().getSerializableExtra(BUNDLE_EXTRA_MEETING);
        mPlaces = mMeetingApiService.getPlaces();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Place>(this, android.R.layout.simple_list_item_1, mPlaces);
        mGridView.setAdapter(arrayAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedplace = mPlaces.get(+position);
                Toast.makeText(getApplicationContext(), "You choose " + selectedplace.getName(), Toast.LENGTH_SHORT).show();
                mSelect_room.setText("you have chosen " + selectedplace.getName());
            }
        });

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Meeting meeting = new Meeting(1, mMeetingEdit.getText().toString(), mCalendar.getTime(), selectedplace, mEntrantEdit.getText().toString());
                EventBus.getDefault().post(new AddMeetingEvent(meeting));
            }
        });


        date_time_in = findViewById(R.id.date_time_input);

        date_time_in.setInputType(InputType.TYPE_NULL);


        date_time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(date_time_in);
            }
        });
    }


    private void showDateTimeDialog(final TextView date_time_in) {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, month);
                mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                       mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        mCalendar.set(Calendar.MINUTE, minute);



                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm");

                        date_time_in.setText(simpleDateFormat.format(mCalendar.getTime()));

                    }
                };

                new TimePickerDialog(AddMeetingFragment.this, timeSetListener, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE), true).show();
            }
        };

        new DatePickerDialog(AddMeetingFragment.this, dateSetListener,mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();

    }


}