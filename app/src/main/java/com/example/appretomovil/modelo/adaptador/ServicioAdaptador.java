package com.example.appretomovil.modelo.adaptador;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appretomovil.R;
import com.example.appretomovil.modelo.Servicio;

import java.util.List;

/**
 * Clase Adaptador Servicio
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class ServicioAdaptador extends BaseAdapter {

    /**
     * variable que representa el contexto de la vista
     */
    private Context contexto;

    /**
     * variable que representa el listado de ítems
     */
    private List<Servicio> listadoServicio;

    /**
     * variable que representa el layout a manipular
     */
    private LayoutInflater layout;

    /**
     * Método constructor de la clase adaptador
     *
     * @param contexto contexto de la aplicación
     * @param listadoServicio listado de servicios consultados
     */
    public ServicioAdaptador(Context contexto, List<Servicio> listadoServicio) {
        this.contexto = contexto;
        this.listadoServicio = listadoServicio;
    }

    /**
     * Método que calcula la cantidad de ítems en el listado
     *
     * @return cantidad de ítems.
     */
    @Override
    public int getCount() {
        return listadoServicio.size();
    }

    /**
     * Método que trae los datos de un ítem indicado
     *
     * @param position index del ítem en el listado
     * @return datos del ítem específico
     */
    @Override
    public Servicio getItem(int position) {
        return listadoServicio.get(position);
    }

    /**
     * Método que trae el identificador de un ítem indicado
     *
     * @param position index del ítem en el listado
     * @return identificador del ítem específico
     */
    @Override
    public long getItemId(int position) {
        return listadoServicio.get(position).getId();
    }

    /**
     * Método que trae los datos de un ítem y lo ingresa en una vista a incrustar
     *
     * @param position index del ítem en el listado
     * @param convertView vista plantilla a usar
     * @param parent vista padre en la que ingresará el ítem
     * @return vista con los datos del ítem
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (layout == null) {
            layout = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = layout.inflate(R.layout.item_servicio, null);
        }

        ImageButton imagenItemSer = (ImageButton) convertView.findViewById(R.id.imbItemSer);
        TextView nombreItemSer = (TextView) convertView.findViewById(R.id.txtItemNomSer);
        TextView descripcionItemSer = (TextView) convertView.findViewById(R.id.txtItemDesSer);

        Servicio servicioItem = getItem(position);

        byte[] imagen = servicioItem.getImagen();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imagen, 0, imagen.length);
        imagenItemSer.setImageBitmap(bitmap);

        nombreItemSer.setText(servicioItem.getNombre());
        descripcionItemSer.setText(servicioItem.getDescripcion());

        /**
         * Implementación y configuración de listeners onClick
         */
        imagenItemSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexto, "Se seleciona " + servicioItem.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
