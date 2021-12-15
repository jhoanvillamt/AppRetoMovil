package com.example.appretomovil.presentacion;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.appretomovil.BuildConfig;
import com.example.appretomovil.R;
import com.example.appretomovil.dato.ProductoDB;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Fragment Mapa
 *
 * @version 1.0
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

        GeoPoint bogota = new GeoPoint(4.6351,-74.0703);

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
                        R.id.lytFragments, frgSucursal).commit();
            }
        });

        osmMapView.setBuiltInZoomControls(true);

        osmMapController.setCenter(bogota);
        osmMapController.setZoom(6);

        osmMapView.setMultiTouchControls(true);

        final MyLocationNewOverlay locationOverlay = new MyLocationNewOverlay(
                new GpsMyLocationProvider(getContext()),
                osmMapView
        );
        osmMapView.getOverlays().add(locationOverlay);
        locationOverlay.enableMyLocation();

        locationOverlay.runOnFirstFix(new Runnable() {
            @Override
            public void run() {
                osmMapController.animateTo(locationOverlay.getMyLocation());
            }
        });

        /**
         * Marcas de puntos en el mapa
         */

        ProductoDB baseProducto = new ProductoDB(getContext());
        Cursor cursor = baseProducto.getSucursal();
        List<OverlayItem> puntos = new ArrayList<>();

        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                GeoPoint sucursal = new GeoPoint(
                        cursor.getDouble(5),
                        cursor.getDouble(6)
                );

                puntos.add(new OverlayItem(
                        cursor.getString(1),
                        cursor.getString(2),
                        sucursal
                ));
            }
        }

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> marca = new ItemizedIconOverlay
                .OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return false;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(
                getContext(),puntos, marca);
        capa.setFocusItemsOnTap(true);
        osmMapView.getOverlays().add(capa);

        // Inflate the layout for this fragment
        return view;
    }
}