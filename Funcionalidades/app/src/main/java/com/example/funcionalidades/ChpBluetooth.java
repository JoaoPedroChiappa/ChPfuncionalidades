package com.example.funcionalidades;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChpBluetooth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_bluetooth);

        Button btnAtivaBT = (Button) findViewById(R.id.btnAtivaBT);
        Button btnVerificaProx = (Button) findViewById(R.id.btnVerificaProx);
        Button btnVerificaPareados = (Button) findViewById(R.id.btnVerificaPareados);
        Button btnParear = (Button) findViewById(R.id.btnParear);
        Button btnPacote = (Button) findViewById(R.id.btnPacote);
        Button btnVoltar3 = (Button) findViewById(R.id.btnVoltar3);

        btnVoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChpBluetooth.this, ChpMain.class));
            }
        });

        btnAtivaBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}