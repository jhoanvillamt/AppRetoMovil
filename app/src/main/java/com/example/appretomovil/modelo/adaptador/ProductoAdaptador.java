package com.example.appretomovil.modelo.adaptador;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appretomovil.R;
import com.example.appretomovil.dato.ProductoDB;
import com.example.appretomovil.modelo.Producto;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * Clase Adaptador Producto
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class ProductoAdaptador extends BaseAdapter {

    /**
     * variable que representa el contexto de la vista
     */
    private Context contexto;

    /**
     * variable que representa el listado de ítems
     */
    private List<Producto> listadoProducto;

    /**
     * Variabl que representa la conexión con la base de datos
     */
    private ProductoDB conectar;

    /**
     * variable que representa el layout a manipular
     */
    private LayoutInflater layout;

    /**
     * Variable que representa la imagen para añadir favortio
     */
    private Drawable drawableF;

    /**
     * Variable que representa la imagen para eliminar favortio
     */
    private Drawable drawableF2;

    /**
     * Variable que representa la imagen de carro de compra agregar
     */
    private Drawable drawableC;

    /**
     * Variable que representa el estado del botón carro
     */
    boolean carro = false;

    /**
     * Método constructor de la clase adaptador
     *
     * @param contexto contexto de la aplicación
     * @param listadoProducto listado de productos consultados
     */
    public ProductoAdaptador(Context contexto, List<Producto> listadoProducto) {
        this.contexto = contexto;
        this.listadoProducto = listadoProducto;
        this.conectar = new ProductoDB(contexto);
    }

    /**
     * Método que calcula la cantidad de ítems en el listado
     *
     * @return cantidad de ítems.
     */
    @Override
    public int getCount() {
        return listadoProducto.size();
    }

    /**
     * Método que trae los datos de un ítem indicado
     *
     * @param position index del ítem en el listado
     * @return datos del ítem específico
     */
    @Override
    public Producto getItem(int position) {
        return listadoProducto.get(position);
    }

    /**
     * Método que trae el identificador de un ítem indicado
     *
     * @param position index del ítem en el listado
     * @return identificador del ítem específico
     */
    @Override
    public long getItemId(int position) {
        return listadoProducto.get(position).getId();
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
            convertView = layout.inflate(R.layout.item_producto, null);
        }

        ImageButton imagenItem = (ImageButton) convertView.findViewById(R.id.imbItemProd);
        TextView nombreItem = (TextView) convertView.findViewById(R.id.txtItemNomProd);
        TextView precioItem = (TextView) convertView.findViewById(R.id.txtItemPreProd);
        TextView descripcionItem = (TextView) convertView.findViewById(R.id.txtItemDesProd);
        ImageButton favoritoItem = (ImageButton) convertView.findViewById(R.id.imbItemFavProd);
        ImageButton carroItem = (ImageButton) convertView.findViewById(R.id.imbItemCarProd);

        Resources resFav1 = contexto.getResources();
        drawableF = resFav1.getDrawable(R.drawable.ic_baseline_favorite_border_24);

        Resources resFav2 = contexto.getResources();
        drawableF2 = resFav2.getDrawable(R.drawable.ic_baseline_favorite_24);

        Resources resCar1 = contexto.getResources();
        drawableC = resCar1.getDrawable(R.drawable.ic_baseline_add_shopping_cart_24);
        carroItem.setImageDrawable(drawableC);

        Producto productoItem = getItem(position);

        Cursor favorito = conectar.getFavoritoByIdProducto(productoItem.getId());
        if (favorito.getCount() == 0) {
            favoritoItem.setImageDrawable(drawableF);
        } else {
            favoritoItem.setImageDrawable(drawableF2);
        }

        byte[] imagen = productoItem.getImagen();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imagen, 0, imagen.length);
        imagenItem.setImageBitmap(bitmap);

        nombreItem.setText(productoItem.getNombre());
        precioItem.setText("$ " + productoItem.getPrecio().toString() + " COP");
        descripcionItem.setText(productoItem.getDescripcion());

        /**
         * Implementación y configuración de listeners onClick
         */
        imagenItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexto, "Se seleciona " + productoItem.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        carroItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (carro) {
                    Toast.makeText(contexto, productoItem.getNombre() + " se quitó del carro de compras",
                            Toast.LENGTH_SHORT).show();
                    carro = false;
                    carroItem.setImageDrawable(drawableC);
                } else {
                    Resources resCar2 = contexto.getResources();
                    Drawable drawableC2 = resCar2.getDrawable(R.drawable
                            .ic_baseline_remove_shopping_cart_24);
                    Toast.makeText(contexto, productoItem.getNombre() + " se agregó al carro de compras",
                            Toast.LENGTH_SHORT).show();
                    carro = true;
                    carroItem.setImageDrawable(drawableC2);
                }
            }
        });
        favoritoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor favorito = conectar.getFavoritoByIdProducto(productoItem.getId());
                if (favorito.getCount() == 0) {
                    try {
                        conectar.insertFavorito(
                                productoItem.getId(),
                                productoItem.getNombre(),
                                productoItem.getPrecio(),
                                productoItem.getDescripcion(),
                                productoItem.getImagen()
                        );

                        Snackbar mensaje = Snackbar.make(view, productoItem.getNombre() + " se agregó a tus favoritos", Snackbar.LENGTH_LONG);
                        mensaje.setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                conectar.deleteFavorito(productoItem.getId());
                                favoritoItem.setImageDrawable(drawableF);
                            }
                        });
                        mensaje.show();

                        favoritoItem.setImageDrawable(drawableF2);
                    } catch (Exception exc) {
                        Snackbar mensaje = Snackbar.make(view, "Se ha presentado un error" + exc.toString(), Snackbar.LENGTH_LONG);
                        mensaje.show();
                    }
                } else {
                    conectar.deleteFavorito(productoItem.getId());

                    Snackbar mensaje = Snackbar.make(view, productoItem.getNombre() + " se quitó de tus favoritos", Snackbar.LENGTH_LONG);
                    mensaje.setAction("Deshacer", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                conectar.insertFavorito(
                                        productoItem.getId(),
                                        productoItem.getNombre(),
                                        productoItem.getPrecio(),
                                        productoItem.getDescripcion(),
                                        productoItem.getImagen()
                                );
                                favoritoItem.setImageDrawable(drawableF2);
                            } catch (Exception exc) {
                                Snackbar mensaje = Snackbar.make(view, "Se ha presentado un error", Snackbar.LENGTH_LONG);
                                mensaje.show();
                            }
                        }
                    });
                    mensaje.show();

                    favoritoItem.setImageDrawable(drawableF);
                }
            }
        });

        return convertView;
    }
}
