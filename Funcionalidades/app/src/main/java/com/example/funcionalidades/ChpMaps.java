package com.example.funcionalidades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChpMaps extends AppCompatActivity {

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

        btnVoltar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}