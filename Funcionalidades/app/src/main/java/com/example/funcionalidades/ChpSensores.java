package com.example.funcionalidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChpSensores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_sensores);

        Button btnMovimento = (Button) findViewById(R.id.btnMovimento);
        Button btnPosicao = (Button) findViewById(R.id.btnPosicao);
        Button btnLuz = (Button) findViewById(R.id.btnLuz);
        Button btnPressao = (Button) findViewById(R.id.btnPressao);
        Button btnTemperatura = (Button) findViewById(R.id.btnTemperatura);
        Button btnVoltar5 = (Button) findViewById(R.id.btnVoltar5);

        EditText rspMovimento = (EditText) findViewById(R.id.rspMovimento);
        EditText rspPosicao = (EditText) findViewById(R.id.rspPosicao);
        EditText rspPressao = (EditText) findViewById(R.id.rspPressao);
        EditText rspTemp = (EditText) findViewById(R.id.rspTemp);

        btnVoltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChpSensores.this, ChpMain.class));
            }
        });
    }
}