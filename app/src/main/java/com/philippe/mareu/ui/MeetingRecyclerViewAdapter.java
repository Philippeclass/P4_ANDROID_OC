package com.philippe.mareu.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;
import com.philippe.mareu.events.AddMeetingEvent;
import com.philippe.mareu.events.DeleteMeetingEvent;
import com.philippe.mareu.model.Meeting;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.philippe.mareu.ui.MainActivity.BUNDLE_EXTRA_MEETING;

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

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);
        Glide.with(holder.mMeetingColor.getContext())
                .load(meeting.getAvatarColor())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mMeetingColor);

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteMeetingEvent(meeting));
            }
        });

       holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(holder.itemView.getContext(), AddMeetingFragment.class);
                intent.putExtra(BUNDLE_EXTRA_MEETING, meeting);
                holder.itemView.getContext().startActivity(intent);

            }
        });

        holder.mAddMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new AddMeetingEvent(meeting));
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
        @BindView(R.id.btn_add_meeting)
        public ImageButton mAddMeetingButton;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }











}
