package com.example.appretomovil.presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.appretomovil.R;

/**
 * Clase Activity Splash
 * (Anterior Activity Intro)
 *
 * @version 1.3
 * @author Jhoan Villa G35 C4
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Variable que representa el valor cargado en la barra de progreso
     */
    int carga = 0;

    /**
     * Método onCreate: constructor de la pantalla o vista asociada
     *
     * @param savedInstState instancia de la pantalla en la ejecución
     */
    @Override
    protected void onCreate(Bundle savedInstState) {
        super.onCreate(savedInstState);
        setContentView(R.layout.activity_intro);

        getSupportActionBar().hide();

        ProgressBar progreso = (ProgressBar) findViewById(R.id.prbProgreso);
        Handler handler = new Handler();

        ImageView logo = (ImageView) findViewById(R.id.imvLogo);
        logo.setImageDrawable(getDrawable(R.drawable.logo));
        AnimationDrawable animacion = (AnimationDrawable) logo.getDrawable();
        animacion.start();

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (carga <= 100) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progreso.setProgress(carga);
                        }
                    });

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (carga == 100) {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    carga+=5;
                }
                finish();
            }
        });
        hilo.start();

    }
}