package com.philippe.mareu.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.philippe.mareu.R;
import com.philippe.mareu.di.DI;
import com.philippe.mareu.events.AddMeetingEvent;
import com.philippe.mareu.events.DeleteMeetingEvent;
import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.service.MeetingApiService;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private DatePicker mDatePicker;
    private TimePicker mTimePicker;
    EditText date_in;
    EditText time_in;
    TextView date_time_in;

    Meeting mMeeting;

    MeetingApiService mMeetingApiService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_meeting_fragment);
        ButterKnife.bind(this);
        mMeetingApiService = DI.getMeetingApiService();
        mMeeting = (Meeting) getIntent().getSerializableExtra(BUNDLE_EXTRA_MEETING);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meeting meeting = new Meeting(1, mMeetingEdit.getText().toString(), Calendar.getInstance().getTime(), mGridView.toString(), mEntrantEdit.getText().toString());
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
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm");

                        date_time_in.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };

                new TimePickerDialog(AddMeetingFragment.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
            }
        };

        new DatePickerDialog(AddMeetingFragment.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

    }


}