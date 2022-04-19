package com.example.funcionalidades;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class ChpAudio extends AppCompatActivity {

    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String AudioSavePath = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_audio);

        Button btnGravaAudio = (Button) findViewById(R.id.btnGravaAudio);
        Button btnReproduzAudio = (Button) findViewById(R.id.btnReproduzAudio);
        Button btnPararGravaAudio = (Button) findViewById(R.id.btnPararGravaAudio);
        Button btnParaReproduzAudio= (Button) findViewById(R.id.btnParaReproduzAudio);
        Button btnVoltar2 = (Button) findViewById(R.id.btnVoltar2);

        btnVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        btnGravaAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkPermissions() == true) {

                    AudioSavePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                            +"/"+"recordingAudio.mp3";

                    mediaRecorder = new MediaRecorder();
                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                    mediaRecorder.setOutputFile(AudioSavePath);

                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                        Toast.makeText(ChpAudio.this, "Gravação começou", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else{
                    ActivityCompat.requestPermissions(ChpAudio.this, new String[]{
                            Manifest.permission.RECORD_AUDIO,Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, 1);
                }
            }
        });

        btnPararGravaAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaRecorder.stop();
                mediaRecorder.release();
                Toast.makeText(ChpAudio.this, "Gravação finalizada", Toast.LENGTH_SHORT).show();
            }
        });

        btnReproduzAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(AudioSavePath);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    Toast.makeText(ChpAudio.this, "Áudio tocando", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnParaReproduzAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    Toast.makeText(ChpAudio.this, "Áudio parado", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean checkPermissions(){
        int first = ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        int second = ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        return first == PackageManager.PERMISSION_GRANTED && second == PackageManager.PERMISSION_GRANTED;
    }
}