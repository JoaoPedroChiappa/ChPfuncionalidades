package com.example.funcionalidades;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ChpMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_main);

        Button btnWifi = (Button) findViewById(R.id.btnWifi);
        Button btnDadosMoveis = (Button) findViewById(R.id.btnDadosMoveis);
        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        Button btnAudio = (Button) findViewById(R.id.btnAudio);
        Button btnBluetooth = (Button) findViewById(R.id.btnBluetooth);
        Button btnMaps = (Button) findViewById(R.id.btnMaps);
        Button btnSensores = (Button) findViewById(R.id.btnSensores);
        Button btnFinalizar = (Button) findViewById(R.id.btnFinalizar);

        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if(wifi.isWifiEnabled()){
            btnWifi.setText("Desativar");
        }else {
            btnWifi.setText("Ativar");
        }

        btnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ChpMain.this, Manifest.permission.CHANGE_WIFI_STATE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ChpMain.this, new String[]{
                            Manifest.permission.CHANGE_WIFI_STATE
                    }, 100);
                } else {
                    if (wifi.isWifiEnabled()) {
                        btnWifi.setText("Ativar");
                        wifi.setWifiEnabled(true);
                    } else {
                        btnWifi.setText("Desativar");
                        wifi.setWifiEnabled(false);
                    }
                }
            }
        });

        btnDadosMoveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(getApplicationContext(), ChpCamera.class);
                startActivity(camera);
            }
        });

        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent audio = new Intent(getApplicationContext(), ChpAudio.class);
                startActivity(audio);
            }
        });

        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bluetooth = new Intent(getApplicationContext(), ChpBluetooth.class);
                startActivity(bluetooth);
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maps = new Intent(getApplicationContext(), ChpMaps.class);
                startActivity(maps);
            }
        });

        btnSensores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sensores = new Intent(getApplicationContext(), ChpSensores.class);
                startActivity(sensores);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

    }


}