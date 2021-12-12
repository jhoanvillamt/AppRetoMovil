package com.example.appretomovil.caso_uso;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.example.appretomovil.modelo.Producto;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Caso de Uso Favorito
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class FavoritoCasoUso {

    /**
     * Método para obtener el mapa de bits de la imagen para registrar
     *
     * @param imagen imagen a procesar
     * @return mapa de bits de la imagen
     */
    public byte[] imageViewToByte(ImageView imagen) {
        Bitmap bitmap = ((BitmapDrawable) imagen.getDrawable()).getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();
    }

    /**
     * Método para obtener el listado de datos en modo de cadena de texto
     *
     * @param cursor cursor con los datos
     * @return cadena de texto con los datos consultados
     */
    public String cursorToString(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return "No se encontraron datos";
        } else {
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()) {
                buffer.append("ID:"+ cursor.getString(0) +
                        " ,PRODUCTO: " + cursor.getString(1) +
                        " ,NOMBRE: " + cursor.getString(2) +
                        " ,IMAGEN: " + cursor.getBlob(5).toString() + "\n");
            }
            return buffer.toString();
        }
    }

    /**
     * Método para llenar un array con los datos
     *
     * @param cursor cursor con los datos
     * @return array con los datos consultados
     */
    public List<Producto> llenarArray(Cursor cursor) {
        List<Producto> listaTemp = new ArrayList<>();
        if (cursor.getCount() == 0) {
            return listaTemp;
        } else {
            while (cursor.moveToNext()) {
                listaTemp.add(new Producto(
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getDouble(3),
                        cursor.getString(4),
                        cursor.getBlob(5)
                ));
            }
            return listaTemp;
        }
    }

    /**
     * Método para convertir byte[] a bitmap
     *
     * @param imagen imagen en byte[]
     * @return imagen en bitmap
     */
    public Bitmap cargarBitmap(byte[] imagen) {
        return BitmapFactory.decodeByteArray(imagen, 0, imagen.length);
    }
}
