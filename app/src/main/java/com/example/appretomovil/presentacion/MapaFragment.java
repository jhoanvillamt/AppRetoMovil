package com.example.appretomovil.presentacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.appretomovil.BuildConfig;
import com.example.appretomovil.R;
import com.example.appretomovil.dato.rest.SucursalVolley;

import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

/**
 * Clase Fragment Mapa
 *
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class MapaFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        //GeoPoint bogota = new GeoPoint(4.6351,-74.0703);

        Button btnListadoSuc = (Button) view.findViewById(R.id.btnListado);
        MapView osmMapView = (MapView) view.findViewById(R.id.osmMapa);
        MapController osmMapController = (MapController) osmMapView.getController();

        btnListadoSuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Variable que representa el fragment del formulario
                 */
                Fragment frgSucursal = new SucursalFragment();

                /**
                 * Carga de fragment inicial en la pantalla
                 */
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.lytFragments, frgSucursal).addToBackStack(null).commit();
            }
        });

        SucursalVolley sucursalVolley = new SucursalVolley(getContext());
        sucursalVolley.getSucursalMap(osmMapView, osmMapController);

        // Inflate the layout for this fragment
        return view;
    }
}