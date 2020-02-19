package com.philippe.mareu.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.dialog_fragment, container);
    }



    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Set pickers
        mMinutesPicker.setMinValue(0);
        mMinutesPicker.setMaxValue(50);
        mHourPicker.setMinValue(0);
        mHourPicker.setMaxValue(23);

    }

  

}
