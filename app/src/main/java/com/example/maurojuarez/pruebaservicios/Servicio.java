package com.example.maurojuarez.pruebaservicios;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Mauro Juarez on 1 nov 2017.
 */

public class Servicio extends Service{

    private boolean isPlaying = false;
    MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        play();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        stop();
    }

    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void play() {
        if (!isPlaying) {

            isPlaying=true;
            mediaPlayer = MediaPlayer.create(this, R.raw.desconexion_sideral);
            mediaPlayer.start();

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setContentTitle("App Música")
                    .setContentText("Canción sonando")
                    .setSmallIcon(R.drawable.ar);

            Intent i = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);

            //Pasamos el servicio a primer plano
            startForeground(1, builder.build());
        }
    }
    //Cancelamos la notificación, y liberamos recursos del mediaPlayer
    private void stop() {
        if (isPlaying) {
            isPlaying=false;
            //Liberamos recursos
            mediaPlayer.release();
            mediaPlayer = null;
            //Cancelamos la notificación
            stopForeground(true);
        }
    }
}
