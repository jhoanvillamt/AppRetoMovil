package com.example.appretomovil.presentacion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appretomovil.R;
import com.example.appretomovil.caso_uso.ProductoCasoUso;
import com.example.appretomovil.dato.rest.ProductoVolley;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clase Fragment Formulario Producto
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class FormProductoFragment extends Fragment {

    /**
     * Variable que representa los permisos solicitados para acceso a galeria
     */
    private final static int READ_CODE_GALLERY = 999;

    /**
     * Variable que representa el campo del nombre en el formulario
     */
    private EditText txtNombreProducto;

    /**
     * Variable que representa el campo de la descripción en el formulario
     */
    private EditText txtDescripcionProducto;

    /**
     * Variable que representa el campo del precio en el formulario
     */
    private EditText txtPrecioProducto;

    /**
     * Variable que representa el campo del identificador en el formulario
     */
    private EditText txtIdProducto;

    /**
     * Variable que representa el campo de la imagen en el formulario
     */
    private ImageView imgSelectedProducto;

    /**
     * Variable que representa la instacia con la base de datos
     */
    private ProductoVolley volleyProducto;

    /**
     * Variable que representa la instancia con las funciones generales
     */
    private ProductoCasoUso productoCasoUso;

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

        View view = inflater.inflate(R.layout.fragment_form_producto, container, false);

        Button btnChoose = (Button) view.findViewById(R.id.btnChoose);
        Button btnInsertarProducto = (Button) view.findViewById(R.id.btnInsertarProducto);
        Button btnConsultarProducto = (Button) view.findViewById(R.id.btnConsultarProducto);
        Button btnEliminarProducto = (Button) view.findViewById(R.id.btnEliminarProducto);
        Button btnModificarProducto = (Button) view.findViewById(R.id.btnModificarProducto);
        Button btnListaProductos = (Button) view.findViewById(R.id.btnListaProductos);

        txtNombreProducto = (EditText) view.findViewById(R.id.txtNombreProducto);
        txtDescripcionProducto = (EditText) view.findViewById(R.id.txtDescripcionProducto);
        txtPrecioProducto = (EditText) view.findViewById(R.id.txtPrecioProducto);
        txtIdProducto = (EditText) view.findViewById(R.id.txtIdProducto);
        imgSelectedProducto = (ImageView) view.findViewById(R.id.imgSelectedProducto);

        volleyProducto = new ProductoVolley(getContext());
        productoCasoUso = new ProductoCasoUso();

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions(
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        READ_CODE_GALLERY
                );
            }
        });
        btnInsertarProducto.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    volleyProducto.insertProducto(
                            txtNombreProducto.getText().toString(),
                            Double.parseDouble(txtPrecioProducto.getText().toString()),
                            txtDescripcionProducto.getText().toString(),
                            productoCasoUso.imageViewToByte(imgSelectedProducto)
                    );
                    limpiarCampos();
                    Toast.makeText(getContext(), "Se ha registrado el producto",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception exc) {
                    Toast.makeText(getContext(), "Se ha presentado un error " +
                            exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnConsultarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idText = txtIdProducto.getText().toString().trim();
                if ("".equals(idText)) {
                    volleyProducto.getProductoString();
                } else {
                    volleyProducto.getProductoById(
                            Integer.parseInt(idText),
                            txtNombreProducto,
                            txtDescripcionProducto,
                            txtPrecioProducto,
                            imgSelectedProducto
                            );
                }
            }
        });
        btnEliminarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idProd = txtIdProducto.getText().toString().trim();
                if ("".equals(idProd)) {
                    limpiarCampos();
                    Toast.makeText(getContext(), "No se identificó el producto",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Integer idProducto = Integer.parseInt(idProd);
                    volleyProducto.deleteProducto(idProducto);
                    limpiarCampos();
                    Toast.makeText(getContext(), "El producto ha sido eliminado",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnModificarProducto.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    volleyProducto.updateProducto(
                            Integer.parseInt(txtIdProducto.getText().toString()),
                            txtNombreProducto.getText().toString(),
                            Double.parseDouble(txtPrecioProducto.getText().toString()),
                            txtDescripcionProducto.getText().toString(),
                            productoCasoUso.imageViewToByte(imgSelectedProducto)
                    );
                    limpiarCampos();
                    Toast.makeText(getContext(), "Se ha modificado el producto",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception exc) {
                    Toast.makeText(getContext(), "Se ha presentado un error " +
                            exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnListaProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Variable que representa el fragment producto
                 */
                Fragment frgProducto = new ProductoFragment();

                /**
                 * Carga de fragment inicial en la pantalla
                 */
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.lytFragments, frgProducto).addToBackStack(null).commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    /**
     * Método para limpiar campos del formulario
     */
    public void limpiarCampos() {
        txtIdProducto.setText("");
        txtNombreProducto.setText("");
        txtPrecioProducto.setText("");
        txtDescripcionProducto.setText("");
        imgSelectedProducto.setImageResource(R.mipmap.ic_launcher);
    }

    /**
     * Método que permite la adquisición de permisos y activación del selector de archivos
     *
     * @param requestCode código del permiso
     * @param permissions arreglo de permisos
     * @param grantResults arreglo de permisos otorgados
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == READ_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, READ_CODE_GALLERY);
            } else {
                Toast.makeText(getContext(),"No fueron otorgados los permisos",
                        Toast.LENGTH_LONG).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * Método que permite manipular el archivo seleccionado para cargar en el formulario
     *
     * @param requestCode código del permiso
     * @param resultCode código recibido
     * @param data información capturada
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == READ_CODE_GALLERY && resultCode == getActivity().RESULT_OK && data != null) {
            Uri uriImagen = data.getData();
            InputStream inputStream = null;
            try {
                inputStream = getContext().getContentResolver().openInputStream(uriImagen);
                Bitmap bitmapImagen = BitmapFactory.decodeStream(inputStream);
                imgSelectedProducto.setImageBitmap(bitmapImagen);
            } catch (FileNotFoundException exc) {
                exc.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}