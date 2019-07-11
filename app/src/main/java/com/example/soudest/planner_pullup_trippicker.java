package com.example.soudest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.example.soudest.helper.trip;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class planner_pullup_trippicker extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private List<trip> TrippsList = new ArrayList<trip>();
    MytripRecyclerViewAdapter MyAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public planner_pullup_trippicker() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static planner_pullup_trippicker newInstance(int columnCount) {
        planner_pullup_trippicker fragment = new planner_pullup_trippicker();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trip_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            MyAdapter = new MytripRecyclerViewAdapter(TrippsList, mListener);
            recyclerView.setAdapter(MyAdapter);

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            //TODO Implement Listener
            //throw new RuntimeException(context.toString()
            //        + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void getTrips(String p1,String p2){

        String TripID="PLACEHOLDER";
        String starttime="PLACEHOLDER";
        String arivaltime="PLACEHOLDER";
        String totalprice="PLACEHOLDER";
        String startpoint="PLACEHOLDER";
        String endpoint="PLACEHOLDER";
        JSONObject trips = trip.gettrip(1.0,2.5);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM HH:mm"); // the format of your date

        try {
             //TripID = (String)trips.getString("TripID");
            TripID = trips.getJSONObject("Trip").getString("TripID");
            Date date = new Date(trips.getJSONObject("Trip").getLong("StartTime")*1000L); // convert seconds to milliseconds
            starttime = dateFormat.format(date);
            date = new Date(trips.getJSONObject("Trip").getLong("EndTime")*1000L); // convert seconds to milliseconds
            arivaltime = dateFormat.format(date);
            totalprice = trips.getJSONObject("Trip").getString("TotalPrice");
            //startpoint = trips.getJSONObject("Trip").getString("EndTime");
            //endpoint = trips.getJSONObject("Trip").getString("EndTime");
        }catch (Exception e){
            //Do nothing //TODO
             TripID="FEHLER";
        }

        TrippsList.add(new trip("0",TripID,TripID,starttime,arivaltime,totalprice,startpoint,endpoint));
        MyAdapter.notifyDataSetChanged();


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(trip item);
    }
}
