package com.example.soudest;

import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.soudest.uimain.PageViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_MyPlannerTab} factory method to
 * create an instance of this fragment.
 */
public class Fragment_MyPlannerTab extends Fragment implements View.OnClickListener, View.OnTouchListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;

    private Button mygobutton;

    private GoogleMap mMap;
    private static final String TAG = Fragment_MyPlannerTab.class.getSimpleName();

    public Fragment_MyPlannerTab() {
        // Required empty public constructor
    }

    public static Fragment_MyPlannerTab newInstance(int index) {
        Fragment_MyPlannerTab fragment = new Fragment_MyPlannerTab();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this)*/
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
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
                                    Fragment_MyPlannerTab.this.getContext(), R.raw.map_style));

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

        //LetsGoButton
        mygobutton = rootView.findViewById(R.id.letsgobutton);
        mygobutton.setOnTouchListener(this);
        mygobutton.setOnClickListener(this);

        SlidingUpPanelLayout slidingUpPanelLayout = rootView.findViewById(R.id.slidingUpPanelLayout);
        slidingUpPanelLayout.setPanelHeight(0);

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.letsgobutton:
                /*
                if (src.getText().toString().equals("") || dest.getText().toString().equals("")) {
                    Toast.makeText(getContext().getApplicationContext(), "Bitte Ziel und Startort angeben.", Toast.LENGTH_SHORT).show();
                } else {
                    Fragment_MyPlannerTab_PullUp_Trippicker trippicker_fragment = (Fragment_MyPlannerTab_PullUp_Trippicker) getChildFragmentManager().findFragmentById(R.id.TripPickFragment);
                    trippicker_fragment.getTrips(src.getText().toString(), dest.getText().toString());
                }*/

                SlidingUpPanelLayout slidingUpPanelLayout = v.getRootView().findViewById(R.id.slidingUpPanelLayout);
                slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);

                break;
            default:
                Toast.makeText(getContext().getApplicationContext(), "Unknown button! Dafak!", Toast.LENGTH_SHORT).show();
                break;
        }
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //Log.e("LOL", "onTouch: "+v.getId() );

        if (event.getAction() == MotionEvent.ACTION_UP){
            SlidingUpPanelLayout slidingUpPanelLayout = v.getRootView().findViewById(R.id.slidingUpPanelLayout);
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        }
        else if (event.getAction() == MotionEvent.ACTION_DOWN){
            SlidingUpPanelLayout slidingUpPanelLayout = v.getRootView().findViewById(R.id.slidingUpPanelLayout);
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }




        return false;
    }
}
