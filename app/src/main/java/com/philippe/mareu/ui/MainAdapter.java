package com.philippe.mareu.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.philippe.mareu.R;

public class MainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] numberWord;
    private int[] numberImage;

    public MainAdapter(Context c, String[] numberWord, int[] numberImage) {
        context = c;
        this.numberWord = numberWord;
        this.numberImage = numberImage;
    }

    @Override
    public int getCount() {
        return numberWord.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.create_meeting_fragment, null);
        }
            ImageView imageView = convertView.findViewById(R.id.image_view);
            TextView textView = convertView.findViewById(R.id.text_view_place);

            imageView.setImageResource(numberImage[position]);

            return convertView;


        }

}
