package com.example.funcionalidades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChpCamera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_camera);

        Button btnTirarfoto = (Button) findViewById(R.id.btnTirarfoto);
        Button btnTirarselfie = (Button) findViewById(R.id.btnTirarselfie);
        Button btnGaleria = (Button) findViewById(R.id.btnGaleria);
        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }
}