package com.example.funcionalidades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChpAudio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_audio);

        Button btnGravaAudio = (Button) findViewById(R.id.btnGravaAudio);
        Button btnReproduzAudio = (Button) findViewById(R.id.btnReproduzAudio);
        Button btnVoltar2 = (Button) findViewById(R.id.btnVoltar2);

        btnVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}