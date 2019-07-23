package com.example.soudest.helper;

import com.google.android.gms.maps.model.LatLng;

import java.util.Random;

public final class location {
    static Random r = new Random();

    private location() {
        throw new IllegalStateException("No instances allowed!");
    }

    //Returns Fake Coordinates for a given Adress within Weingarten
    public static LatLng getFakeCordsToLocation(String adress) {

        double north = 47.808 + ((double) getRandomNumberInRange(0, 1) / 100);
        double east = 9.639 + ((double) getRandomNumberInRange(0, 1) / 100);
        LatLng pos = new LatLng(north, east);
        return pos;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }


        return r.nextInt((max - min) + 1) + min;
    }

}


