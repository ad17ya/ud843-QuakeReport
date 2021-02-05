package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeObject> {

    private  static final String LOCATION_SEPARATOR = " of ";

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
        String formattedMagnitude = formatMagnitude(currentObject.getMagnitude());
        magnitudeTextView.setText(formattedMagnitude);

//        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
 //       locationTextView.setText(currentObject.getLocation());


        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        Date dateObject = new Date(currentObject.getmTimeInMilliseconds());

        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);


        //creating desired strings

        String originalLocation = currentObject.getLocation();
        String primaryLocation, locationOffset;

        if(originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);


        return listItemView;
    }

//    private int getMagnitudeColor(double magnitude) {
//        int magnitudeColorRId;
//        int magnitudeFloor = (int) Math.floor(magnitude);
//
//        switch (magnitudeFloor) {
//            case 0:
//            case 1:
//                magnitudeColorRId = R.color.magnitude1;
//                break;
//            case 2:
//                magnitudeColorRId = R.color.magnitude2;
//                break;
//            case 3:
//                magnitudeColorRId = R.color.magnitude3;
//                break;
//            case 4:
//                magnitudeColorRId = R.color.magnitude4;
//                break;
//            case 5:
//                magnitudeColorRId = R.color.magnitude5;
//                break;
//            case 6:
//                magnitudeColorRId = R.color.magnitude6;
//                break;
//            case 7:
//                magnitudeColorRId = R.color.magnitude7;
//                break;
//            case 8:
//                magnitudeColorRId = R.color.magnitude8;
//                break;
//            case 9:
//                magnitudeColorRId = R.color.magnitude9;
//                break;
//            default:
//                magnitudeColorRId = R.color.magnitude10plus;
//                break;
//        }
//
//        return ContextCompat.getColor(getContext(), magnitudeColorRId);
//    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
