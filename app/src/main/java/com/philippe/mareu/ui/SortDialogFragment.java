package com.philippe.mareu.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.philippe.mareu.R;
import com.philippe.mareu.di.DI;
import com.philippe.mareu.model.Place;
import com.philippe.mareu.service.MeetingApiService;
import java.util.List;
import static org.greenrobot.eventbus.EventBus.TAG;


public class MyDialogFragment extends DialogFragment {


    public interface MyDialogFragmentListener{
        public void onClickPlaceDialogCall(MyDialogFragment myDialogFragment, Place place);

    }

MyDialogFragmentListener mListener;

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        mListener = (MyDialogFragmentListener) getTargetFragment();
    }


    private TextView mActionCancel;
    private GridView mPlaceDialog;
    private List<Place> mPlaces;
    Place selectedplace;
    MeetingApiService mMeetingApiService;


    public static MyDialogFragment newInstance(int title) {
        MyDialogFragment dialog = new MyDialogFragment();
        Bundle args = new Bundle();
        args.putInt("title", title);
        dialog.setArguments(args);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_dialog);
        mMeetingApiService = DI.getMeetingApiService();
        mActionCancel = dialog.findViewById(R.id.action_cancel);
        mPlaceDialog = dialog.findViewById(R.id.place_input_dialog);
        mPlaces = mMeetingApiService.getPlaces();
        ArrayAdapter arrayAdapter = new ArrayAdapter<Place>(getActivity(), android.R.layout.simple_list_item_1, mPlaces);
        mPlaceDialog.setAdapter(arrayAdapter);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        mPlaceDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedplace = mPlaces.get(+position);
                mMeetingApiService.sortByPlaces(selectedplace);
                mListener.onClickPlaceDialogCall(MyDialogFragment.this, selectedplace);
                getDialog().dismiss();


            }
        });

        return dialog;
    }


}
