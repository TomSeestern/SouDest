package com.example.soudest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.soudest.helper.ticketOBJ;
import com.example.soudest.helper.trip;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activiy_TripDetailView extends AppCompatActivity implements View.OnClickListener{


    Button myDetailViewBackButton;
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


        myDetailViewBackButton = (Button) this.findViewById(R.id.DetailViewBackButton);
        Log.e("ERROR", "onCreateView: myDetailViewBackButton "+myDetailViewBackButton);
        if (myDetailViewBackButton != null) myDetailViewBackButton.setOnClickListener(this);


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.DetailViewBackButton:
                this.finish();
                break;
            default:
                Toast.makeText(this.getApplicationContext(), "Unknown button! Dafak!", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
