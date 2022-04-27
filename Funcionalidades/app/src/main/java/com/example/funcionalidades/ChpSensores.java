package com.example.funcionalidades;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChpSensores extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor tempSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_sensores);

        Button btnMovimento = (Button) findViewById(R.id.btnMovimento);
        Button btnPosicao = (Button) findViewById(R.id.btnPosicao);
        Button btnLuzOn = (Button) findViewById(R.id.btnLuzOn);
        Button btnLuzOff = (Button) findViewById(R.id.btnLuzOff);
        Button btnPressao = (Button) findViewById(R.id.btnPressao);
        Button btnTemperatura = (Button) findViewById(R.id.btnTemperatura);
        Button btnVoltar5 = (Button) findViewById(R.id.btnVoltar5);

        EditText rspMovimento = (EditText) findViewById(R.id.rspMovimento);
        EditText rspPosicao = (EditText) findViewById(R.id.rspPosicao);
        EditText rspPressao = (EditText) findViewById(R.id.rspPressao);
        EditText rspTemp = (EditText) findViewById(R.id.rspTemp);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        }else{
            rspTemp.setText("Não disponível");
        }

        btnVoltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChpSensores.this, ChpMain.class));
            }
        });

        btnLuzOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                    String cameraId = null;
                    try {
                        cameraId = camManager.getCameraIdList()[0];
                        camManager.setTorchMode(cameraId, true);   //Turn ON
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnLuzOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                    String cameraId = null;
                    try {
                        cameraId = camManager.getCameraIdList()[0];
                        camManager.setTorchMode(cameraId, false);   //Turn ON
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        EditText rspTemp = (EditText) findViewById(R.id.rspTemp);

        rspTemp.setText(sensorEvent.values[0]+" °C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}