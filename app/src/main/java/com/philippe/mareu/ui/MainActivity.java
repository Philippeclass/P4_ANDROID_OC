package com.philippe.mareu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philippe.mareu.R;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @BindView(R.id.btn_add_meeting)
    public FloatingActionButton mAdd_meeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView_meeting);


        mAdd_meeting.setOnClickListener(view -> {
            mNeighbourApiService.changeFavStatus(mNeighbour);
            mNeighbour.toggleFavoriteButton();
            setFavoriteButton();

        });


    }
}
