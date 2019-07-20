package com.example.soudest;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soudest.TicketDetailView.OnListFragmentInteractionListener;
import com.example.soudest.helper.ticketOBJ;
import com.example.soudest.helper.connectionOBJ;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link connectionOBJ} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTicketConnectionRecyclerViewAdapter extends RecyclerView.Adapter<MyTicketConnectionRecyclerViewAdapter.ViewHolder> {

    private final List<connectionOBJ> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final ticketOBJ myTicket;

    public MyTicketConnectionRecyclerViewAdapter(ticketOBJ para_Ticket, OnListFragmentInteractionListener listener) {
        myTicket = para_Ticket;
        mValues = myTicket.connections;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ticketconnection, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        //holder.mContentView.setText(mValues.get(position).content);

        holder.mStartTime.setText(holder.mItem.StartTime.toString());
        holder.mEndTime.setText(holder.mItem.EndTime.toString());
        holder.mStartStation.setText(holder.mItem.StartLocName.toString());
        holder.mEndStation.setText(holder.mItem.EndLocName.toString());
        holder.mStationNum.setText("?");
        holder.mtimediv.setText(holder.mItem.TotalTime.toString());
        holder.mLineDetailName.setText(holder.mItem.Description.toString());

        Log.e("HELP", "onBindViewHolder: mValues.size()"+mValues.size());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mStartTime;
        public final TextView mEndTime;
        public final TextView mStartStation;
        public final TextView mEndStation;

        public final TextView mStationNum;
        public final TextView mtimediv;

        public final TextView mLineDetailName;
        //public final TextView mContentView;
        public connectionOBJ mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mStartTime = (TextView) view.findViewById(R.id.startTime);
            mStartStation = (TextView) view.findViewById(R.id.startStation2);
            mEndStation = (TextView) view.findViewById(R.id.endStation);
            mStationNum = (TextView) view.findViewById(R.id.stationNumber);
            mLineDetailName = (TextView) view.findViewById(R.id.LineDetailName);
            mtimediv = (TextView) view.findViewById(R.id.timediv);
            mEndTime = (TextView) view.findViewById(R.id.EndTime);
        }

    }
}
