package com.example.soudest.uimain;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.example.soudest.R;
import com.example.soudest.uimain.PageViewModel;
import com.example.soudest.*;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.title_tab_planning, R.string.title_tab_tickets,R.string.title_tab_profile};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {

            case 0:
                //Planner Site
                return planner.newInstance(0);
            case 1:
                //Ticket Overview Site
                return fragment_ticket.newInstance(1);
            case 2:
                //Profile Site
                return MyProfile.newInstance();
            default:
                Toast.makeText(mContext, "Fehler bei Navigationselementauswahl!", Toast.LENGTH_SHORT).show();
                //TODO Log Error
                return null;
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}