package com.philippe.mareu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.philippe.mareu.R;

public class AddMeetingDialogFragment extends DialogFragment {

    private EditText mMeetingEdit;
    private EditText mEntrantEdit;
    private Button mOkButton;
    private NumberPicker mHourPicker;
    private  NumberPicker mMinutesPicker;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.dialog_fragment, container);
    }






}
