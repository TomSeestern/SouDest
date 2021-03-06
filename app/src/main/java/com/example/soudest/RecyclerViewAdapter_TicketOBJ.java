package com.example.soudest;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.soudest.Fragment_MyTicketsTab.OnListFragmentInteractionListener;
import com.example.soudest.helper.connectionOBJ;
import com.example.soudest.helper.ticketOBJ;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ticketOBJ} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class RecyclerViewAdapter_TicketOBJ extends RecyclerView.Adapter<RecyclerViewAdapter_TicketOBJ.ViewHolder> {

    private final List<ticketOBJ> mValues;
    private final OnListFragmentInteractionListener mListener;

    public RecyclerViewAdapter_TicketOBJ(List<ticketOBJ> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ticketoverview_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTotalTime.setText((mValues.get(position).TotalTime.intValue() / 60) / 60 + "h " + (((mValues.get(position).TotalTime.intValue() / 60) % 60) + 1) + "min");
        holder.mTotalPrice.setText(String.format("%.2f", mValues.get(position).TotalPrice) + " €");

        holder.mStartTime.setText(new SimpleDateFormat("HH:mm").format(new Date(mValues.get(position).StartTime.longValue() * 1000)));
        holder.mEndTime.setText(new SimpleDateFormat("HH:mm").format(new Date(mValues.get(position).EndTime.longValue() * 1000)));
        holder.mStartLoc.setText((mValues.get(position).connections.get(0).StartLocName));
        holder.mEndLoc.setText((mValues.get(position).connections.get(0).EndLocName));

        holder.mLinearLayout.removeAllViews();  //Reset the Layout
        for (connectionOBJ conni : mValues.get(position).connections) {

            TextView txt1 = new TextView(holder.mView.getContext());
            txt1.setText(conni.Description);
            txt1.setTextSize(16);
            txt1.setGravity(Gravity.LEFT);

            txt1.setPadding(16, 16, 16, 16);
            txt1.setClipToOutline(true);

            txt1.setTextColor(holder.mView.getContext().getResources().getColor(R.color.colorPrimary));


            Drawable myBackground = holder.mView.getContext().getDrawable(R.drawable.connectionbar);

            switch (conni.TransportType) {
                case "Bus":
                    txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_directions_bus_black_24dp, 0, 0, 0);
                    myBackground.setColorFilter(holder.mView.getContext().getResources().getColor(R.color.color_transport_bus), PorterDuff.Mode.SRC);
                    break;
                case "Train":
                    txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_directions_railway_black_24dp, 0, 0, 0);
                    myBackground.setColorFilter(holder.mView.getContext().getResources().getColor(R.color.color_transport_train), PorterDuff.Mode.SRC);
                    break;
                case "Subway":
                    txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_directions_subway_black_24dp, 0, 0, 0);
                    myBackground.setColorFilter(holder.mView.getContext().getResources().getColor(R.color.color_transport_subway), PorterDuff.Mode.SRC);
                    break;
                case "Walk":
                    txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_directions_walk_black_24dp, 0, 0, 0);
                    myBackground.setColorFilter(holder.mView.getContext().getResources().getColor(R.color.color_transport_walk), PorterDuff.Mode.SRC);
                    break;
                default:
                    txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_priority_high_black_24dp, 0, 0, 0);
                    myBackground.setColorFilter(holder.mView.getContext().getResources().getColor(R.color.color_transport_walk), PorterDuff.Mode.SRC);
                    break;
            }

            holder.mLinearLayout.addView(txt1);

            txt1.setBackground(myBackground);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    //mListener.onListFragmentInteraction(holder.mItem);
                }
                Intent myIntent = new Intent(v.getContext(), Activiy_TripDetailView.class);
                myIntent.putExtra("ticket", holder.mItem);
                v.getContext().startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView mTicketId;
        public ticketOBJ mItem;

        public LinearLayout mLinearLayout;
        public TextView mTotalTime;
        public TextView mTotalPrice;
        public TextView mStartTime;
        public TextView mEndTime;
        public TextView mStartLoc;
        public TextView mEndLoc;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            //mTicketId = (TextView) view.findViewById(R.id.traveldate);
            mLinearLayout = mView.findViewById(R.id.stations);
            mTotalTime = view.findViewById(R.id.totalTime);
            mTotalPrice = view.findViewById(R.id.TotalPrice);
            mStartTime = view.findViewById(R.id.starttime);
            mEndTime = view.findViewById(R.id.arivalTime);
            mStartLoc = view.findViewById(R.id.startLocation2);
            mEndLoc = view.findViewById(R.id.endLocation);
        }

       /* @Override
        public String toString() {
            return super.toString() + " '" + mTicketId.getText() + "'";
        }
        */
    }
}
