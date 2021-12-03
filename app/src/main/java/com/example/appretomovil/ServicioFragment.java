package com.example.appretomovil;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Clase Fragment Servicio
 * (Antigua Activity)
 *
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class ServicioFragment extends Fragment {

    /**
     * Método onCreate: constructor de la pantalla o vista asociada
     *
     * @param inflater datos del layout
     * @param container contenedor vinculado
     * @param savedInstState instancia del fragmento en la ejecución
     * @return vista generada
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstState) {

        /**
         * Se carga los botones e imágenes en la pantalla
         */

        /**
         * Variable que representa la vista del contendor del fragmento
         */
        View view = inflater.inflate(R.layout.fragment_servicio, container, false);

        /**
         * Variable que representa el botón del servicio 1
         */
        ImageButton ibtServicio1 = (ImageButton) view.findViewById(R.id.imbServicio1);

        /**
         * Variable que representa el botón del servicio 2
         */
        ImageButton ibtServicio2 = (ImageButton) view.findViewById(R.id.imbServicio2);

        /**
         * Variable que representa el botón del servicio 3
         */
        ImageButton ibtServicio3 = (ImageButton) view.findViewById(R.id.imbServicio3);

        /**
         * Variable que representa el botón del servicio 4
         */
        ImageButton ibtServicio4 = (ImageButton) view.findViewById(R.id.imbServicio4);

        /**
         * Variable que representa el botón del servicio 5
         */
        ImageButton ibtServicio5 = (ImageButton) view.findViewById(R.id.imbServicio5);

        /**
         * Variable que representa el botón del servicio 6
         */
        ImageButton ibtServicio6 = (ImageButton) view.findViewById(R.id.imbServicio6);

        /**
         * Variables que representan las imágenes
         */

        /**
         * Variable que representa la imagen 1
         */
        Drawable drawable1;

        /**
         * Variable que representa la imagen 2
         */
        Drawable drawable2;

        /**
         * Variable que representa la imagen 3
         */
        Drawable drawable3;

        /**
         * Ingreso de imágenes en los ImageButton
         */
        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.srv1);
        ibtServicio1.setImageDrawable(drawable1);

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.srv2);
        ibtServicio2.setImageDrawable(drawable2);

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.srv3);
        ibtServicio3.setImageDrawable(drawable3);

        ibtServicio4.setImageDrawable(drawable1);

        ibtServicio5.setImageDrawable(drawable2);

        ibtServicio6.setImageDrawable(drawable3);

        /**
         * Implementación y configuración de listeners onClick
         */
        ibtServicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona el servicio 1",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtServicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona el servicio 2",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtServicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona el servicio 3",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtServicio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona el servicio 4",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtServicio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona el servicio 5",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtServicio6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona el servicio 6",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}