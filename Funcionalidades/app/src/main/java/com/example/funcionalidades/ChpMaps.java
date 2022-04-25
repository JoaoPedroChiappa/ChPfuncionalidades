package com.example.funcionalidades;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class ChpMaps extends AppCompatActivity implements LocationListener{

    LocationManager locationManager;
    EditText rspLatitude, rspLongitude, rspAltitude, rspLocalAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_maps);

        Button btnUltimaLoc = (Button) findViewById(R.id.btnUltimaLoc);
        Button btnLocalAtual = (Button) findViewById(R.id.btnLocalAtual);
        Button btnLatitude = (Button) findViewById(R.id.btnLatitude);
        Button btnLongitude = (Button) findViewById(R.id.btnLongitude);
        Button btnAltitude = (Button) findViewById(R.id.btnAltitude);
        Button btnRotaUniube = (Button) findViewById(R.id.btnRotaUniube);
        Button btnVoltar4 = (Button) findViewById(R.id.btnVoltar4);

        rspLatitude = findViewById(R.id.rspLatitude);
        rspLongitude = findViewById(R.id.rspLongitude);
        rspAltitude = findViewById(R.id.rspAltitude);
        rspLocalAtual = findViewById(R.id.rspLocalAtual);

        if (ContextCompat.checkSelfPermission(ChpMaps.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(ChpMaps.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        btnVoltar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChpMaps.this, ChpMain.class));
            }
        });

        btnLocalAtual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLocation();
            }
        });

        btnLatitude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rspLatitude.setText(Double.toString());
            }
        });

        btnLongitude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rspLongitude.setText(Double.toString(longitude));
            }
        });

        btnAltitude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rspAltitude.setText(Double.toString(altitude));
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation(){

        try{
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, ChpMaps.this);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, ""+location.getLatitude()+", "+location.getLongitude(), Toast.LENGTH_SHORT).show();

        try {
            Geocoder geocoder = new Geocoder(ChpMaps.this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getAltitude(), location.getLongitude(), 1);
            String adress = addresses.get(0).getAddressLine(0);

            rspLocalAtual.setText(adress);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}