package com.example.soudest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import android.support.v7.widget.AppCompatAutoCompleteTextView;

import android.widget.ArrayAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link planner_pullup_menu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link planner_pullup_menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class planner_pullup_menu extends Fragment implements View.OnClickListener {

    private TextView dateText;
    private TextView timeText;

    private int year, month, day;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    private String[] vorschlage = {"Apple", "Appy", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear", "Weingarten","Weingarten Berg 'Weingarten'","Weingarten (Baden)","Weingarten Charlottenplatz", "Basilika St. Martin 'Weingarten'"};
    private AppCompatAutoCompleteTextView p1autotext,p2autotext;


    private OnFragmentInteractionListener mListener;

    public planner_pullup_menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment planner_pullup_menu.
     */
    // TODO: Rename and change types and number of parameters
    public static planner_pullup_menu newInstance(String param1, String param2) {
        planner_pullup_menu fragment = new planner_pullup_menu();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_planner_pullup_menu, container, false);

        //For auto complete
        p1autotext = (AppCompatAutoCompleteTextView) rootView.findViewById(R.id.p1text);
        p2autotext = (AppCompatAutoCompleteTextView) rootView.findViewById(R.id.p2text);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.select_dialog_item , vorschlage);
        p1autotext.setThreshold(1); //will start working from first character
        p1autotext.setAdapter(adapter);
        p2autotext.setThreshold(1); //will start working from first character
        p2autotext.setAdapter(adapter);


        //Date and Timepicker
        dateText = (TextView) rootView.findViewById(R.id.dateButton);
        dateText.setText("keine Datum");
        dateText.setOnClickListener(this);
        timeText = (TextView) rootView.findViewById(R.id.timeButton);
        timeText.setText("keine Zeit");
        timeText.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this.getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        dateText.setText("Datum: " + day + "." + month + "." + year);
                    }
                }, year, month, day );

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

        timePickerDialog = new TimePickerDialog(this.getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                timeText.setText( "Zeit:"+ selectedHour + ":" + selectedMinute);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true);

        // Inflate the layout for this fragment
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            //TODO implement Fragment Listener
            //throw new RuntimeException(context.toString()
            //        + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.letsgobutton:
                Toast.makeText(getActivity(), "This is my Toast message!", Toast.LENGTH_LONG).show();
                break;
            case R.id.dateButton:
                datePickerDialog.show();
                break;
            case R.id.timeButton:
                timePickerDialog.show();
                break;
        }
    }
}
