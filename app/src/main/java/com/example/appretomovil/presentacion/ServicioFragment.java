package com.example.appretomovil.presentacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.appretomovil.R;
import com.example.appretomovil.dato.rest.ServicioVolley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Clase Fragment Servicio
 * (Antigua Activity)
 *
 * @version 1.2
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
         * Variable que representa la vista del contendor del fragmento
         */
        View view = inflater.inflate(R.layout.fragment_servicio, container, false);

        ListView listView = (ListView) view.findViewById(R.id.ltvServicios);

        FloatingActionButton fab = view.findViewById(R.id.fabServicio);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewFab) {
                /**
                 * Variable que representa el fragment del formulario
                 */
                Fragment frgFormServicio = new FormServicioFragment();

                /**
                 * Carga de fragment inicial en la pantalla
                 */
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.lytFragments, frgFormServicio).addToBackStack(null).commit();
            }
        });

        ServicioVolley servicioVolley = new ServicioVolley(getContext());
        servicioVolley.getServicio(listView);

        // Inflate the layout for this fragment
        return view;
    }
}