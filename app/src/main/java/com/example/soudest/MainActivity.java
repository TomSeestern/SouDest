package com.example.soudest;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // update the main content by replacing fragments
            switch (item.getItemId()) {
                case R.id.planning:
                    planner plannerfragment = new planner();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentframe,plannerfragment,"planner");
                    fragmentTransaction.commit();
                    break;
                case R.id.tickets:
                    fragment_ticket ticketsfragment = new fragment_ticket();
                    FragmentTransaction fragment_tickets_transaction = getSupportFragmentManager().beginTransaction();
                    fragment_tickets_transaction.replace(R.id.fragmentframe,ticketsfragment,"tickets");
                    fragment_tickets_transaction.commit();
                    break;
                case R.id.profile:
                    break;
                    default:
                        return false;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navView.getMenu().performIdentifierAction(R.id.planning, 0); //Navigates to the First Menu Item on Startup
    }

}
