package com.example.maurojuarez.pruebaservicios;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Mauro Juarez on 1 nov 2017.
 */

public class IntentServicio extends IntentService {

    public IntentServicio() {
        super("IntentServicio");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            Log.d("servicio","activo");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Intent i = new Intent("DOWNLOAD_EXITO");
            sendBroadcast(i);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("servicio","detenido");
    }


}
