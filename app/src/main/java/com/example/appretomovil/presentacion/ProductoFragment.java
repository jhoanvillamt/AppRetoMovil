package com.example.appretomovil.presentacion;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.appretomovil.R;
import com.example.appretomovil.caso_uso.ProductoCasoUso;
import com.example.appretomovil.dato.ProductoDB;
import com.example.appretomovil.modelo.Producto;
import com.example.appretomovil.modelo.adaptador.ProductoAdaptador;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * Clase Fragment Producto
 * (Antigua Activity)
 *
 * @version 1.2
 * @author Jhoan Villa G35 C4
 */
public class ProductoFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_producto, container, false);

        ListView listView = (ListView) view.findViewById(R.id.ltvProductos);

        FloatingActionButton fab = view.findViewById(R.id.fabProducto);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewFab) {
                /**
                 * Variable que representa el fragment del formulario
                 */
                Fragment frgFormProducto = new FormProductoFragment();

                /**
                 * Carga de fragment inicial en la pantalla
                 */
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.lytFragments, frgFormProducto).commit();
            }
        });

        ProductoDB baseProducto = new ProductoDB(getContext());
        ProductoCasoUso productoCasoUso = new ProductoCasoUso();
        Cursor cursor = baseProducto.getProducto();
        List<Producto> listado = productoCasoUso.llenarArray(cursor);

        ProductoAdaptador productoAdaptador = new ProductoAdaptador(getContext(), listado);
        listView.setAdapter(productoAdaptador);

        // Inflate the layout for this fragment
        return view;
    }
}