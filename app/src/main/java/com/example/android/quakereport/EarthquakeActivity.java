/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<EarthquakeObject> earthquakes = new ArrayList<>();
        earthquakes.add(new EarthquakeObject("7.2", "San Fransisco", "Feb 2, 2016"));
        earthquakes.add(new EarthquakeObject("8.2", "London", "Feb 2, 2016"));
        earthquakes.add(new EarthquakeObject("1.6", "Mumbai", "July 29, 2013"));
        earthquakes.add(new EarthquakeObject("8.3", "Moon", "Sept 21, 2012"));
        earthquakes.add(new EarthquakeObject("2.2", "Mexico", "Oct 12, 2006"));
        earthquakes.add(new EarthquakeObject("6.3", "Tokyo ", "Aug 12, 2001"));
        earthquakes.add(new EarthquakeObject("5.9", "Paris", "Jan 9, 2002"));
        earthquakes.add(new EarthquakeObject("2.9", "Moscow", "Dec 1, 2000"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
