package com.example.funcionalidades;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChpBluetooth extends AppCompatActivity {

    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

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

        if(mBluetoothAdapter.isEnabled()){
            btnAtivaBT.setText("Desativar");
        }else {
            btnAtivaBT.setText("Ativar");
        }

        btnVoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChpBluetooth.this, ChpMain.class));
            }
        });

        btnAtivaBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(ChpBluetooth.this, Manifest.permission.BLUETOOTH_CONNECT)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ChpBluetooth.this, new String[]{
                            Manifest.permission.BLUETOOTH_CONNECT
                    }, 100);
                } else {
                    if (mBluetoothAdapter.isEnabled()) {
                        mBluetoothAdapter.disable();
                        btnAtivaBT.setText("Ativar");
                    } else {
                        mBluetoothAdapter.enable();
                        btnAtivaBT.setText("Desativar");
                    }
                }
            }
        });

        btnVerificaProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ChpBluetooth.this, Manifest.permission.BLUETOOTH_SCAN)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ChpBluetooth.this, new String[]{
                            Manifest.permission.BLUETOOTH_SCAN
                    }, 100);
                } else {
                    Toast.makeText(ChpBluetooth.this, "Escaneando...", Toast.LENGTH_SHORT).show();
                    mBluetoothAdapter.startDiscovery();
                }
            }
        });


    }
}