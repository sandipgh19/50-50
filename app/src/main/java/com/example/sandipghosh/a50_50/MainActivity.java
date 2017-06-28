package com.example.sandipghosh.a50_50;

import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.sandipghosh.a50_50.FingerLine.pointsList;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    FingerLine frame;

    ImageView image;

    static TextView text1, text2;

    private GoogleMap mMap;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);

        frame = (FingerLine) findViewById(R.id.frame);

        text1 = (TextView) findViewById(R.id.text1);

        text2 = (TextView) findViewById(R.id.text2);

        //  frame.setOnClickListener(this);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        calculate();
                    }
                });
            }
        }, 1000, 1000);

        List<LatLng> latLngs = new ArrayList<>();
        latLngs.add(new LatLng(51.893728, -8.491865));
        latLngs.add(new LatLng(51.893550, -8.492479));
        latLngs.add(new LatLng(51.893216, -8.492224));
        latLngs.add(new LatLng(51.893404, -8.491598));
        // Log.i("Image1", "computeArea " + SphericalUtil.computeArea(latLngs));
        //  Log.i("Image1", "computeArea " + SphericalUtil.computeLength(latLngs));

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.getBaseContext());

        // Showing status
        if (status != ConnectionResult.SUCCESS) { // Google Play Services are not available

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();

        } else { // Google Play Services are available

            // Getting reference to the SupportMapFragment of activity_main.xml

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            //  mapFragment.getMapAsync(this);

        }

    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...

        Config.getBottom = image.getBottom();
        Config.getTop = image.getTop();
        Config.getLeft = image.getLeft();
        Config.getRight = image.getRight();

        Log.i("Image1buttom", String.valueOf(Config.getBottom));
        Log.i("Image1left", String.valueOf(Config.getLeft));
        Log.i("Image1right", String.valueOf(Config.getRight));
        Log.i("Image1top", String.valueOf(Config.getTop));

        Log.i("Image1X", String.valueOf(image.getX()));

        Log.i("Image1Y", String.valueOf(image.getY()));


    }

    public void calculate() {

        Config.getBottom = image.getBottom();
        Config.getTop = image.getTop();
        Config.getLeft = image.getLeft();
        Config.getRight = image.getRight();

        Log.i("Image1buttom", String.valueOf(Config.getBottom));
        Log.i("Image1left", String.valueOf(Config.getLeft));
        Log.i("Image1right", String.valueOf(Config.getRight));
        Log.i("Image1top", String.valueOf(Config.getTop));

        Log.i("Image1X", String.valueOf(frame.getX()));

        Log.i("Image1Y", String.valueOf(frame.getY()));

        timer.cancel();
    }

    @Override
    public void onLocationChanged(Location location) {

        // Getting latitude of the current location
        double latitude = location.getLatitude();

        // Getting longitude of the current location
        double longitude = location.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Showing the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,11));

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;


        double latit = 28.365398;//Double.parseDouble(profileSharedPreferences.getString("lat",""));
        double longit = 75.586105;//Double.parseDouble(profileSharedPreferences.getString("lng",""));

        LatLng latLng = new LatLng(latit, longit);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,11));

    }
}
