package com.example.appretomovil.presentacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appretomovil.R;

/**
 * Clase Activity Main
 *
 * @version 1.2
 * @author Jhoan Villa G35 C4
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Variable que representa el identiicador dal canal para la notificaciones
     */
    private static final String CHANNEL_ID = "NOTIFICACION";

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

                crearDialogo("Novedades", "No se registran nuevos productos");
            }
        });
        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Variable que representa el fragment favorito
                 */
                Fragment frgFavorito = new FavoritoFragment();

                /**
                 * Carga de fragment de favorito en la pantalla
                 */
                getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments,
                        frgFavorito).commit();
            }
        });
        btnNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearCanalNotificacion();
                crearNotificacion("Notificaciones Miyagi", "No existen notiicaciones pendientes por leer");
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
            Fragment frgMapaSucursal = new MapaFragment();

            /**
             * Carga de fragment inicial en la pantalla
             */
            getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments,
                    frgMapaSucursal).commit();
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

    /**
     * Método para creación del aviso de notificaciones
     *
     * @param titulo título de la notificación
     * @param contenido contenido de la notificación
     */
    private void crearNotificacion(String titulo, String contenido){
        int notificaionId = 0;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),
                CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setLargeIcon(bitmap);
        builder.setContentText(contenido);
        builder.setContentTitle(titulo);
        builder.setDefaults(NotificationCompat.PRIORITY_DEFAULT);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setColor(Color.BLUE);
        builder.setLights(Color.MAGENTA, 500, 2000);
        builder.setVibrate(new long[]{1000,500});

        NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
        manager.notify(notificaionId, builder.build());
    }

    /**
     * Método para creación del canal de comunicación de notificaciones
     */
    private void crearCanalNotificacion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence nombre = "Notificacion";
            NotificationChannel canal = new NotificationChannel(CHANNEL_ID, nombre,
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(canal);
        }
    }

    /**
     * Método para creación el cuadro de diálogo para novedades
     *
     * @param titulo título del diálogo
     * @param contenido contenido del diálogo
     */
    private void crearDialogo(String titulo, String contenido){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(contenido)
                .setPositiveButton("Ver productos", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /**
                         * Variable que representa el fragment productos
                         */
                        Fragment frgProducto = new ProductoFragment();

                        /**
                         * Carga de fragment inicial en la pantalla
                         */
                        getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments,
                                frgProducto).commit();
                    }
                })
                .setNegativeButton("Ver favoritos", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /**
                         * Variable que representa el fragment favorito
                         */
                        Fragment frgFavorito = new FavoritoFragment();

                        /**
                         * Carga de fragment de favorito en la pantalla
                         */
                        getSupportFragmentManager().beginTransaction().replace(R.id.lytFragments,
                                frgFavorito).commit();
                    }
                })
                .show();
    }
}