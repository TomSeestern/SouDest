package com.example.soudest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soudest.planner_pullup_trippicker.OnListFragmentInteractionListener;
import java.util.List;
import com.example.soudest.helper.trip;

/**
 * {@link RecyclerView.Adapter} that can display a {@link trip} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MytripRecyclerViewAdapter extends RecyclerView.Adapter<MytripRecyclerViewAdapter.ViewHolder> {

    private final List<trip> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MytripRecyclerViewAdapter(List<trip> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_trip, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mstarttime.setText(mValues.get(position).starttime);
        holder.marivaltime.setText(mValues.get(position).arivaltime);
        holder.mtotalprice.setText(mValues.get(position).totalprice);
        holder.mstartpoint.setText(mValues.get(position).startpoint);
        holder.mendpoint.setText(mValues.get(position).endpoint);

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
        public final TextView mContentView;
        public trip mItem;

        public final TextView mstarttime;
        public final TextView marivaltime;
        public final TextView mtotalprice;
        public final TextView mstartpoint;
        public final TextView mendpoint;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
            mstarttime = (TextView) view.findViewById(R.id.starttime);
            marivaltime = (TextView) view.findViewById(R.id.arivaltime);
            mtotalprice = (TextView) view.findViewById(R.id.totalprice);
            mstartpoint = (TextView) view.findViewById(R.id.startpoint);
            mendpoint = (TextView) view.findViewById(R.id.endpoint);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
