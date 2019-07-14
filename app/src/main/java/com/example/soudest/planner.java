package com.example.soudest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.CameraPosition;

import android.util.Log;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.MapStyleOptions;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.view.View;
import android.view.Menu;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link planner} factory method to
 * create an instance of this fragment.
 */
public class planner extends Fragment implements View.OnClickListener {



    private GoogleMap mMap;
    private static final String TAG = planner.class.getSimpleName();

    public planner() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this)*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_planner, container, false);


        //Things for the MAP
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frag_planner_map);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                try {
                    // Customise the styling of the base map using a JSON object defined
                    // in a raw resource file.
                    boolean success = mMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(
                                    planner.this.getContext(), R.raw.map_style));

                    if (!success) {
                        Log.e(TAG, "Style parsing failed.");
                    }
                } catch (Resources.NotFoundException e) {
                    Log.e(TAG, "Can't find style. Error: ", e);
                }

                mMap.clear(); //clear old markers

                CameraPosition startLocation = CameraPosition.builder()
                        .target(new LatLng(47.808,9.639))
                        .zoom(13)
                        .bearing(0)
                        .tilt(0)
                        .build();

                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(startLocation));
                /*
                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(37.4629101,-122.2449094))
                        .title("Iron Man")
                        .snippet("His Talent : Plenty of money"));
                */

                setMMap(mMap);
            }
        });


        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public void onClick(View v) {

    }

    private void setMMap(GoogleMap paramap){
        mMap=paramap;
    }

    public boolean addMyMarker(int id,LatLng pos,String title,String snippet){
        //TODO Check if id exsists, if yes remove...

        mMap.addMarker(new MarkerOptions()
                .position(pos)
                .title(title)
                .snippet(snippet)
                        );

        CameraPosition Location = CameraPosition.builder()
                .target(pos)
                .zoom(13)
                .bearing(0)
                .tilt(0)
                .build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(Location));

        return true;
    }
}
