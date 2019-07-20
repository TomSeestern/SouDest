package com.example.soudest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.soudest.helper.ticketOBJ;
import com.example.soudest.helper.trip;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class activiy_TripDetailView extends AppCompatActivity {

    ticketOBJ activeTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiy_trip_detail_view);

        activeTrip = (ticketOBJ) getIntent().getSerializableExtra("ticket");

        Bundle bundle = new Bundle();
        bundle.putSerializable("ticket", activeTrip);
        // set Fragmentclass Arguments
        TicketDetailView fragobj = new TicketDetailView();
        fragobj.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragTicketDetailListHolder,fragobj).commit();


    }
}
