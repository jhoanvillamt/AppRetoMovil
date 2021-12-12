package com.example.appretomovil.presentacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appretomovil.R;

/**
 * Clase Fragment Info
 *
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class InfoFragment extends Fragment {

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

        return inflater.inflate(R.layout.fragment_info, container, false);
    }
}