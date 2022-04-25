package com.example.funcionalidades;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChpCamera extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int RESULT_LOAD_IMAGE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void openGallery() {
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    private void dispatchTakePictureIntent2() {

    }

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
                startActivity(new Intent(ChpCamera.this, ChpMain.class));
            }
        });

        btnTirarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ChpCamera.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ChpCamera.this, new String[]{
                            Manifest.permission.CAMERA
                    }, 100);
                } else {
                    dispatchTakePictureIntent();
                }
            }
        });

        btnTirarselfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent2();
            }
        });

        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ChpCamera.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ChpCamera.this, new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    }, 100);
                } else {
                    openGallery();
                }
            }
        });

    }
}