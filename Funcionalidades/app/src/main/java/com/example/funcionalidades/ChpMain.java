package com.example.funcionalidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChpMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_main);

        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        Button btnAudio = (Button) findViewById(R.id.btnAudio);
        Button btnBluetooth = (Button) findViewById(R.id.btnBluetooth);
        Button btnMaps = (Button) findViewById(R.id.btnMaps);
        Button btnSensores = (Button) findViewById(R.id.btnSensores);
        Button btnFinalizar = (Button) findViewById(R.id.btnFinalizar);

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
                System.exit(0);
            }
        });

    }
}