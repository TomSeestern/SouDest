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

import com.example.soudest.dummy.DummyContent;
import com.example.soudest.dummy.DummyContent.DummyItem;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
    private List<DummyItem> TrippsList = new ArrayList<DummyItem>();
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
        JSONObject trips = trip.gettrip(1.0,2.5);
        try {
             //TripID = (String)trips.getString("TripID");
            TripID = trips.getJSONObject("Trip").getString("TripID");
        }catch (Exception e){
            //Do nothing //TODO
             TripID="FEHLER";
        }

        TrippsList.add(new DummyItem(TripID,TripID,TripID));
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
        void onListFragmentInteraction(DummyItem item);
    }
}
