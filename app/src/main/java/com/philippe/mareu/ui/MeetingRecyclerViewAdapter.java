package com.philippe.mareu.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;
import com.philippe.mareu.events.DeleteMeetingEvent;
import com.philippe.mareu.model.Meeting;
import org.greenrobot.eventbus.EventBus;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeetingRecyclerViewAdapter extends RecyclerView.Adapter<MeetingRecyclerViewAdapter.ViewHolder> {


    private final List<Meeting> mMeetings;

    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mFloatingActionButton;

    public MeetingRecyclerViewAdapter(List<Meeting> items) {
        mMeetings = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting, parent, false);
        return new ViewHolder(view);
    }

// Show Meetings
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);
        holder.mMeetingName.setText(meeting.getName() + " - " + meeting.getEntrantMail() + " - " + meeting.getTimeFormated());
        holder.mMeetingColor.getDrawable().setTint(Color.parseColor(meeting.getPlace().getColor()));
        holder.mplaceText.setText(meeting.getPlace().getName());
        holder.mplaceDate.setText(meeting.getDateFormated());
        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteMeetingEvent(meeting));
            }
        });


    }


    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_avatar)
        public ImageView mMeetingColor;
        @BindView(R.id.item_list_name)
        public TextView mMeetingName;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;
        @BindView(R.id.place_text)
        public TextView mplaceText;
        @BindView(R.id.place_date)
        public TextView mplaceDate;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
