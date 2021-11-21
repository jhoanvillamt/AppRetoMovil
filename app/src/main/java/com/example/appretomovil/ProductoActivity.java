package com.example.appretomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Clase Activity Producto
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class ProductoActivity extends AppCompatActivity {

    /**
     * Variable que representa el botón de la chaqueta 1
     */
    private ImageButton ibtChaqueta1;

    /**
     * Variable que representa el botón de la chaqueta 2
     */
    private ImageButton ibtChaqueta2;

    /**
     * Variable que representa el botón de la chaqueta 3
     */
    private ImageButton ibtChaqueta3;

    /**
     * Método onCreate: constructor de la pantalla o vista asociada
     *
     * @param savedInstanceState instancia de la pantalla en la ejecución
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        /**
         * Se pone el logo en el ActionBar
         */
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        /**
         * Se carga los botones a la pantalla
         */
        ibtChaqueta1 = (ImageButton) findViewById(R.id.ibtChaqueta1);
        ibtChaqueta2 = (ImageButton) findViewById(R.id.ibtChaqueta2);
        ibtChaqueta3 = (ImageButton) findViewById(R.id.ibtChaqueta3);

        /**
         * Implementación y configuración de listeners onClick
         */
        ibtChaqueta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Se seleciona la chaqueta 1",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtChaqueta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Se seleciona la chaqueta 2",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtChaqueta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Se seleciona la chaqueta 3",
                        Toast.LENGTH_SHORT).show();
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