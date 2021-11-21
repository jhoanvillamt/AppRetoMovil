package com.example.appretomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Clase Activity Main
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Variable que representa el botón de novedades
     */
    private Button btnNovedades;

    /**
     * Variable que representa el botón de fqvoritos
     */
    private Button btnFavoritos;

    /**
     * Variable que representa el botón de notificaciones
     */
    private Button btnNotificaciones;

    /**
     * Método onCreate: constructor de la pantalla o vista asociada
     *
     * @param savedInstanceState instancia de la pantalla en la ejecución
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Se pone el logo en el ActionBar
         */
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        /**
         * Se carga los botones a la pantalla
         */
        btnNovedades = (Button) findViewById(R.id.btnNovedades);
        btnFavoritos = (Button) findViewById(R.id.btnFavoritos);
        btnNotificaciones = (Button) findViewById(R.id.btnNotificaciones);

        /**
         * Implementación y configuración de listeners onClick
         */
        btnNovedades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de novedades",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de favoritos",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de " +
                                "notificaciones", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Método onCreateOptionsMenu: creador del menú en la pantalla
     *
     * @param menu instancia del menú a usar
     * @return confirmación de la creación del menú
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_central, menu);
        return true;
    }

    /**
     * Método onOptionsItemSelected: gestor de los eventos de las opciones del menú
     *
     * @param item instancia del ítem del menú a usar
     * @return confirmación del uso del ítem del menú
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idItem = item.getItemId();
        if (idItem == R.id.mniInicio) {
            Toast.makeText(getApplicationContext(), "Se dirige a la pantalla principal",
                    Toast.LENGTH_SHORT).show();
            Intent inicio = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(inicio);
        }
        if (idItem == R.id.mniProducto) {
            Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de productos",
                    Toast.LENGTH_SHORT).show();
            Intent producto = new Intent(getApplicationContext(), ProductoActivity.class);
            startActivity(producto);
        }
        if (idItem == R.id.mniServicio) {
            Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de servicios",
                    Toast.LENGTH_SHORT).show();
            Intent servicio = new Intent(getApplicationContext(), ServicioActivity.class);
            startActivity(servicio);
        }
        if (idItem == R.id.mniSucursal) {
            Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de sucursales",
                    Toast.LENGTH_SHORT).show();
            Intent sucursal = new Intent(getApplicationContext(), SucursalActivity.class);
            startActivity(sucursal);
        }
        if (idItem == R.id.mniInfo) {
            Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de información " +
                            "del app", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}