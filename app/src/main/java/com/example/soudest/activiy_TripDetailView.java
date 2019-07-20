package com.example.soudest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.soudest.helper.trip;
import android.content.Intent;
import android.widget.Toast;

public class activiy_TripDetailView extends AppCompatActivity {

    trip activeTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiy_trip_detail_view);

        activeTrip = (trip) getIntent().getSerializableExtra("trip");


    }
}
