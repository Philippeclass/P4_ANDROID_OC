package com.philippe.mareu.ui;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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
import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.service.MeetingApiService;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.philippe.mareu.ui.MainActivity.BUNDLE_EXTRA_NEIGHBOUR;

public class AddMeetingFragment extends AppCompatActivity {

    private EditText mMeetingEdit;
    private EditText mEntrantEdit;
    private Button mOkButton;
    private DatePicker mDatePicker;
    private TimePicker mTimePicker;




    public Drawable mStarWhite;

    @BindView(R.id.avatar_img)
    ImageView mAvatarImg;

    Meeting mMeeting;

    MeetingApiService mMeetingApiService;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_meeting_fragment);
        ButterKnife.bind(this);
        mMeetingApiService = DI.getMeetingApiService();
        mMeeting = (Meeting) getIntent().getSerializableExtra(BUNDLE_EXTRA_NEIGHBOUR);
        Glide.with(this).load(mMeeting.getAvatarColor()).into(mAvatarImg);




    }




}