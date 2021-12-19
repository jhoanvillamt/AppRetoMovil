package com.example.appretomovil.presentacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.appretomovil.R;
import com.example.appretomovil.dato.rest.SucursalVolley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * Clase Fragment Sucursal
 * (Antigua Activity)
 *
 * @version 1.3
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
         * Variable que representa la vista del contendor del fragmento
         */
        View view = inflater.inflate(R.layout.fragment_sucursal, container, false);

        ListView listView = (ListView) view.findViewById(R.id.ltvSucursales);

        FloatingActionButton fab = view.findViewById(R.id.fabSucursal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewFab) {
                /**
                 * Variable que representa el fragment del formulario
                 */
                Fragment frgFormSucursal = new FormSucursalFragment();

                /**
                 * Carga de fragment inicial en la pantalla
                 */
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.lytFragments, frgFormSucursal).addToBackStack(null).commit();
            }
        });

        Button btnMapa = (Button) view.findViewById(R.id.btnMapa);
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewFab) {
                /**
                 * Variable que representa el fragment del mapa
                 */
                Fragment frgMapaSucursal = new MapaFragment();

                /**
                 * Carga de fragment inicial en la pantalla
                 */
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.lytFragments, frgMapaSucursal).addToBackStack(null).commit();
            }
        });

        SucursalVolley sucursalVolley = new SucursalVolley(getContext());
        sucursalVolley.getSucursal(listView);

        // Inflate the layout for this fragment
        return view;
    }
}