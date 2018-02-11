package com.example.maurojuarez.pruebaservicios;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciar;
    private Button btnDetener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnDetener = (Button) findViewById(R.id.btnDetener);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(view);
            }
        });

        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop(view);
            }
        });
    }

    public void play(View v) {
        startService(new Intent(this, Servicio.class));
    }

    public void stop(View v) {
        stopService(new Intent(this, Servicio.class));
    }
}
