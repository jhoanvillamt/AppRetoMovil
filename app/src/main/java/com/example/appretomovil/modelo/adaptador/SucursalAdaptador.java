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
import com.example.appretomovil.modelo.Sucursal;

import java.util.List;

/**
 * Clase Adaptador Sucursal
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class SucursalAdaptador extends BaseAdapter {

    /**
     * variable que representa el contexto de la vista
     */
    private Context contexto;

    /**
     * variable que representa el listado de ítems
     */
    private List<Sucursal> listadoSucursal;

    /**
     * variable que representa el layout a manipular
     */
    private LayoutInflater layout;

    /**
     * Método constructor de la clase adaptador
     *
     * @param contexto        contexto de la aplicación
     * @param listadoSucursal listado de productos consultados
     */
    public SucursalAdaptador(Context contexto, List<Sucursal> listadoSucursal) {
        this.contexto = contexto;
        this.listadoSucursal = listadoSucursal;
    }

    /**
     * Método que calcula la cantidad de ítems en el listado
     *
     * @return cantidad de ítems.
     */
    @Override
    public int getCount() {
        return listadoSucursal.size();
    }

    /**
     * Método que trae los datos de un ítem indicado
     *
     * @param position index del ítem en el listado
     * @return datos del ítem específico
     */
    @Override
    public Sucursal getItem(int position) {
        return listadoSucursal.get(position);
    }

    /**
     * Método que trae el identificador de un ítem indicado
     *
     * @param position index del ítem en el listado
     * @return identificador del ítem específico
     */
    @Override
    public long getItemId(int position) {
        return listadoSucursal.get(position).getId();
    }

    /**
     * Método que trae los datos de un ítem y lo ingresa en una vista a incrustar
     *
     * @param position    index del ítem en el listado
     * @param convertView vista plantilla a usar
     * @param parent      vista padre en la que ingresará el ítem
     * @return vista con los datos del ítem
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (layout == null) {
            layout = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = layout.inflate(R.layout.item_sucursal, null);
        }

        ImageButton imagenItemSuc = (ImageButton) convertView.findViewById(R.id.imbItemSuc);
        TextView nombreItemSuc = (TextView) convertView.findViewById(R.id.txtItemNomSuc);
        TextView direccionItemSuc = (TextView) convertView.findViewById(R.id.txtItemDirSuc);
        TextView telefonoItemSuc = (TextView) convertView.findViewById(R.id.txtItemTelSuc);
        TextView horarioItemSuc = (TextView) convertView.findViewById(R.id.txtItemHorSuc);

        Sucursal sucursalItem = getItem(position);

        byte[] imagen = sucursalItem.getImagen();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imagen, 0, imagen.length);
        imagenItemSuc.setImageBitmap(bitmap);

        nombreItemSuc.setText(sucursalItem.getNombre());
        direccionItemSuc.setText(sucursalItem.getDireccion());
        telefonoItemSuc.setText("Teléfono: " + sucursalItem.getTelefono().toString());
        horarioItemSuc.setText("Horario de atención:\n" + sucursalItem.getHorario());

        /**
         * Implementación y configuración de listeners onClick
         */
        imagenItemSuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexto, "Se seleciona " + sucursalItem.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
