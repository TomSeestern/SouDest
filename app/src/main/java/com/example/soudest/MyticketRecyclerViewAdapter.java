package com.example.soudest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soudest.fragment_ticket.OnListFragmentInteractionListener;
import com.example.soudest.helper.ticketOBJ;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ticketOBJ} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyticketRecyclerViewAdapter extends RecyclerView.Adapter<MyticketRecyclerViewAdapter.ViewHolder> {

    private final List<ticketOBJ> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyticketRecyclerViewAdapter(List<ticketOBJ> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ticket, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTicketId.setText(mValues.get(position).TicketID);

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
        public final TextView mTicketId;
        public ticketOBJ mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            mTicketId = (TextView) view.findViewById(R.id.traveldate);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTicketId.getText() + "'";
        }
    }
}
