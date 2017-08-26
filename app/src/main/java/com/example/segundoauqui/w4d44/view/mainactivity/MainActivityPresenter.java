package com.example.segundoauqui.w4d44.view.mainactivity;

import android.app.Activity;
import android.content.Intent;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by segundoauqui on 8/26/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {



    MainActivityContract.View view;
    LatLng location;
    double newLat;
    double newLog;
    Activity act;


    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;


    }

    @Override
    public void removeView() {
        this.view = null;

    }

    @Override
    public void getLocation(String lat, String log) {
        newLat = Double.parseDouble(lat.toString());
        newLog = Double.parseDouble(log.toString());

        location = new LatLng(newLat, newLog);
        Intent intent = new Intent(act, MapsActivity.class);
        intent.putExtra("location", location);
        act.startActivity(intent);







    }

    @Override
    public void getContext(Activity activity) {
        this.act = activity;

    }
}
