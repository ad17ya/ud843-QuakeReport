package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeObject> {

    public EarthquakeAdapter(Activity context, ArrayList<EarthquakeObject> EarthquakeObjects) {
        super(context, 0, EarthquakeObjects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent,false);
        }

        EarthquakeObject currentObject = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(currentObject.getMagnitude());

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(currentObject.getLocation());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(currentObject.getDate());

        return listItemView;
    }
}
