package com.example.appretomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Método onCreate: constructor de la pantalla o vista asociada
     *
     * @param savedInstState instancia de la pantalla en la ejecución
     */
    @Override
    protected void onCreate(Bundle savedInstState) {
        super.onCreate(savedInstState);
        setContentView(R.layout.activity_main);

        /**
         * Se pone el logo en el ActionBar
         */
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        /**
         * Se carga los botones a la pantalla
         */

        /**
         * Variable que representa el botón de novedades
         */
        Button btnNovedades = (Button) findViewById(R.id.btnNovedades);

        /**
         * Variable que representa el botón de fqvoritos
         */
        Button btnFavoritos = (Button) findViewById(R.id.btnFavoritos);

        /**
         * Variable que representa el botón de notificaciones
         */
        Button btnNotificaciones = (Button) findViewById(R.id.btnNotificaciones);

        /**
         * Variable que representa el fragment inicial
         */
        Fragment frgInicio = new InicioFragment();

        /**
         * Implementación y configuración de listeners onClick
         */
        btnNovedades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de novedades",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de favoritos",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Se dirige a la pantalla de " +
                                "notificaciones", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * Carga de fragment inicial en la pantalla
         */
        getSupportFragmentManager().beginTransaction().add(R.id.lytFragments, frgInicio).commit();
    }


    /**
     * Método onStart para inicio de la pantalla o vista asociada
     */
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Bienvenido de vuelta",
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Método onPause para pausa de la pantalla o vista asociada
     */
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Hasta pronto, aquí te esperamos",
                Toast.LENGTH_SHORT).show();
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
        if (idItem == R.id.carrito) {
            Toast.makeText(getApplicationContext(), "Se dirige al carro de compras",
                    Toast.LENGTH_SHORT).show();
        }
        if (idItem == R.id.mniInicio) {
            /**
             * Variable que representa el fragment inicial
             */
            Fragment frgInicio = new InicioFragment();

            /**
             * Carga de fragment inicial en la pantalla
             */
            getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments, frgInicio)
                    .commit();
        }
        if (idItem == R.id.mniProducto) {
            /**
             * Variable que representa el fragment productos
             */
            Fragment frgProducto = new ProductoFragment();

            /**
             * Carga de fragment inicial en la pantalla
             */
            getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments, frgProducto)
                    .commit();
        }
        if (idItem == R.id.mniServicio) {
            /**
             * Variable que representa el fragment servicios
             */
            Fragment frgServicio = new ServicioFragment();

            /**
             * Carga de fragment inicial en la pantalla
             */
            getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments, frgServicio)
                    .commit();
        }
        if (idItem == R.id.mniSucursal) {
            /**
             * Variable que representa el fragment sucursales
             */
            Fragment frgSucursal = new SucursalFragment();

            /**
             * Carga de fragment inicial en la pantalla
             */
            getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments, frgSucursal)
                    .commit();
        }
        if (idItem == R.id.mniInfo) {
            /**
             * Variable que representa el fragment info
             */
            Fragment frgInfo = new InfoFragment();

            /**
             * Carga de fragment inicial en la pantalla
             */
            getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments, frgInfo)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }
}