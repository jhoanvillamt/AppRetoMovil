package com.example.appretomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Clase Activity Intro
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class IntroActivity extends AppCompatActivity {

    /**
     * Variable que representa el tiempo de la transición
     */
    private static final int TIEMPO = 2000;

    /**
     * Método onCreate: constructor de la pantalla o vista asociada
     *
     * @param savedInstState instancia de la pantalla en la ejecución
     */
    @Override
    protected void onCreate(Bundle savedInstState) {
        super.onCreate(savedInstState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, TIEMPO);
    }
}