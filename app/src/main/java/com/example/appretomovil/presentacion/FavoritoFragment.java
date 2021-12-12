package com.example.appretomovil.presentacion;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.appretomovil.R;
import com.example.appretomovil.caso_uso.FavoritoCasoUso;
import com.example.appretomovil.dato.ProductoDB;
import com.example.appretomovil.modelo.Producto;
import com.example.appretomovil.modelo.adaptador.ProductoAdaptador;

import java.util.List;

/**
 * Clase Fragment Favorito
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class FavoritoFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_favorito, container, false);

        ListView listView = (ListView) view.findViewById(R.id.ltvFavoritos);
        ProductoDB baseProducto = new ProductoDB(getContext());
        FavoritoCasoUso favoritoCasoUso = new FavoritoCasoUso();
        Cursor cursor = baseProducto.getFavorito();
        List<Producto> listado = favoritoCasoUso.llenarArray(cursor);

        ProductoAdaptador productoAdaptador = new ProductoAdaptador(getContext(), listado);
        listView.setAdapter(productoAdaptador);

        // Inflate the layout for this fragment
        return view;
    }
}