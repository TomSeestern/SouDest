package com.example.soudest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.soudest.fragment_ticket.OnListFragmentInteractionListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.example.soudest.helper.ticketOBJ;
import com.example.soudest.helper.trip;
import com.example.soudest.helper.tickets;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class planner_pullup_trippicker extends Fragment {

    private fragment_ticket.OnListFragmentInteractionListener mListener;
    private List<ticketOBJ> TrippsList = new ArrayList<ticketOBJ>();
    MyticketRecyclerViewAdapter MyAdapter;

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

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;


            LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(context) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };

            recyclerView.setLayoutManager(myLinearLayoutManager);

            MyAdapter = new MyticketRecyclerViewAdapter(TrippsList, mListener);
            recyclerView.setAdapter(MyAdapter);

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (fragment_ticket.OnListFragmentInteractionListener) context;
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

    public void getTrips(String source,String dest){

        String TripID="PLACEHOLDER";
        String starttime="PLACEHOLDER";
        String arivaltime="PLACEHOLDER";
        String totalprice="PLACEHOLDER";
        String startpoint="PLACEHOLDER";
        String endpoint="PLACEHOLDER";

        //TrippsList.add(new trip("0",TripID,TripID,starttime,arivaltime,totalprice,startpoint,endpoint));
        TrippsList.add(tickets.getPossibleConnections(startpoint,endpoint,starttime,endpoint).get(0));
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
        void onListFragmentInteraction(ticketOBJ item);
    }
}
