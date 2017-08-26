package com.example.segundoauqui.w4d44.view.mainactivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.segundoauqui.w4d44.Injection.DaggerMainActivityComponent;
import com.example.segundoauqui.w4d44.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity  implements  MainActivityContract.View{


    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 10;
    EditText etText1, etText2;
    Button btnSend;
    @Inject
    MainActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        etText1 = (EditText) findViewById(R.id.etText1);
        etText2 = (EditText) findViewById(R.id.etText2);
        DaggerMainActivityComponent.create().inject(this);
        presenter.attachView(this);
        presenter.getContext(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void checkPermissions(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }

        }else{


        }
    }
    @Override
    public void showerror(String s) {

    }

    @Override
    public void isPersonSaved(boolean isSaved) {

    }

    public void goToLocation(View view) {

        if(etText1.getText().toString().isEmpty() || etText2.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter a Latitude and Longitude", Toast.LENGTH_SHORT).show();
        }
        else {
            presenter.getLocation(etText1.getText().toString(), etText2.getText().toString());
        }


    }
}
