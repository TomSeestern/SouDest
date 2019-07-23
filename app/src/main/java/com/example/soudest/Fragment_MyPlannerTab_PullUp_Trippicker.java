package com.example.soudest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soudest.helper.ticketOBJ;
import com.example.soudest.helper.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class Fragment_MyPlannerTab_PullUp_Trippicker extends Fragment {

    RecyclerViewAdapter_TicketOBJ MyAdapter;
    private List<ticketOBJ> TrippsList = new ArrayList<ticketOBJ>();
    private Fragment_MyTicketsTab.OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Fragment_MyPlannerTab_PullUp_Trippicker() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static Fragment_MyPlannerTab_PullUp_Trippicker newInstance(int columnCount) {
        Fragment_MyPlannerTab_PullUp_Trippicker fragment = new Fragment_MyPlannerTab_PullUp_Trippicker();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticketoverview_list, container, false);

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

            MyAdapter = new RecyclerViewAdapter_TicketOBJ(TrippsList, mListener);
            recyclerView.setAdapter(MyAdapter);

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (Fragment_MyTicketsTab.OnListFragmentInteractionListener) context;
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
