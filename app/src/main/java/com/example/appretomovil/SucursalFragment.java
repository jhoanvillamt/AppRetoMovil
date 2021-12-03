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
 * Clase Fragment Sucursal
 * (Antigua Activity)
 *
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class SucursalFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_sucursal, container, false);

        /**
         * Variable que representa el botón de la sucursal 1
         */
        ImageButton ibtSucursal1 = (ImageButton) view.findViewById(R.id.imbSucursal1);

        /**
         * Variable que representa el botón de la sucursal 2
         */
        ImageButton ibtSucursal2 = (ImageButton) view.findViewById(R.id.imbSucursal2);

        /**
         * Variable que representa el botón de la sucursal 3
         */
        ImageButton ibtSucursal3 = (ImageButton) view.findViewById(R.id.imbSucursal3);

        /**
         * Variable que representa el botón de la sucursal 4
         */
        ImageButton ibtSucursal4 = (ImageButton) view.findViewById(R.id.imbSucursal4);

        /**
         * Variable que representa el botón de la sucursal 5
         */
        ImageButton ibtSucursal5 = (ImageButton) view.findViewById(R.id.imbSucursal5);

        /**
         * Variable que representa el botón de la sucursal 6
         */
        ImageButton ibtSucursal6 = (ImageButton) view.findViewById(R.id.imbSucursal6);

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
        drawable1 = res1.getDrawable(R.drawable.scs1);
        ibtSucursal1.setImageDrawable(drawable1);

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.scs2);
        ibtSucursal2.setImageDrawable(drawable2);

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.scs3);
        ibtSucursal3.setImageDrawable(drawable3);

        ibtSucursal4.setImageDrawable(drawable1);

        ibtSucursal5.setImageDrawable(drawable2);

        ibtSucursal6.setImageDrawable(drawable3);

        /**
         * Implementación y configuración de listeners onClick
         */
        ibtSucursal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la sucursal 1",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtSucursal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la sucursal 2",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtSucursal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la sucursal 3",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtSucursal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la sucursal 4",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtSucursal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la sucursal 5",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtSucursal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la sucursal 6",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}