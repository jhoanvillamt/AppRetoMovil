package com.example.appretomovil.presentacion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appretomovil.R;
import com.example.appretomovil.caso_uso.ServicioCasoUso;
import com.example.appretomovil.dato.ProductoDB;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clase Fragment Formulario Servicio
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class FormServicioFragment extends Fragment {

    /**
     * Variable que representa los permisos solicitados para acceso a galeria
     */
    private final static int READ_CODE_GALLERY = 999;

    /**
     * Variable que representa el campo del nombre en el formulario
     */
    private EditText txtNombreServicio;

    /**
     * Variable que representa el campo de la descripción en el formulario
     */
    private EditText txtDescripcionServicio;

    /**
     * Variable que representa el campo del identificador en el formulario
     */
    private EditText txtIdServicio;

    /**
     * Variable que representa el campo de la imagen en el formulario
     */
    private ImageView imgSelectedServicio;

    /**
     * Variable que representa la instacia con la base de datos
     */
    private ProductoDB baseProducto;

    /**
     * Variable que representa la instancia con las funciones generales
     */
    private ServicioCasoUso servicioCasoUso;

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
        View view = inflater.inflate(R.layout.fragment_form_servicio, container, false);

        Button btnCargarImagen = (Button) view.findViewById(R.id.btnChooseServicio);
        Button btnInsertarServicio = (Button) view.findViewById(R.id.btnInsertarServicio);
        Button btnConsultarServicio = (Button) view.findViewById(R.id.btnConsultarServicio);
        Button btnEliminarServicio = (Button) view.findViewById(R.id.btnEliminarServicio);
        Button btnModificarServicio = (Button) view.findViewById(R.id.btnModificarServicio);
        Button btnListaServicios = (Button) view.findViewById(R.id.btnListaServicios);

        txtNombreServicio = (EditText) view.findViewById(R.id.txtNombreServicio);
        txtDescripcionServicio = (EditText) view.findViewById(R.id.txtDescripcionServicio);
        txtIdServicio = (EditText) view.findViewById(R.id.txtIdServicio);
        imgSelectedServicio = (ImageView) view.findViewById(R.id.imgSelectedServicio);

        baseProducto = new ProductoDB(getContext());
        servicioCasoUso = new ServicioCasoUso();

        btnCargarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions(
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        READ_CODE_GALLERY
                );
            }
        });
        btnInsertarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    baseProducto.insertServicio(
                            txtNombreServicio.getText().toString(),
                            txtDescripcionServicio.getText().toString(),
                            servicioCasoUso.imageViewToByte(imgSelectedServicio)
                    );
                    limpiarCampos();
                    Toast.makeText(getContext(), "Se ha registrado el servicio",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception exc) {
                    Toast.makeText(getContext(), "Se ha presentado un error " +
                            exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnConsultarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idText = txtIdServicio.getText().toString().trim();
                if ("".equals(idText)) {
                    Cursor cursor = baseProducto.getServicio();
                    String resultado = servicioCasoUso.cursorToString(cursor);
                    Toast.makeText(getContext(), resultado, Toast.LENGTH_LONG).show();
                } else {
                    Cursor cursor = baseProducto.getServicioById(Integer.parseInt(idText));
                    if (cursor.getCount() == 0) {
                        Toast.makeText(getContext(),  "No se encontraron datos",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        while (cursor.moveToNext()) {
                            txtNombreServicio.setText(cursor.getString(1));
                            txtDescripcionServicio.setText(cursor.getString(2));
                            imgSelectedServicio.setImageBitmap(servicioCasoUso.
                                    cargarBitmap(cursor.getBlob(3)));
                        }
                    }
                }
            }
        });
        btnEliminarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idServ = txtIdServicio.getText().toString().trim();
                if ("".equals(idServ)) {
                    limpiarCampos();
                    Toast.makeText(getContext(), "No se identificó el servicio",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Integer idServicio = Integer.parseInt(idServ);
                    baseProducto.deleteServicio(idServicio);
                    limpiarCampos();
                    Toast.makeText(getContext(), "El servicio ha sido eliminado",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnModificarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    baseProducto.updateServicio(
                            Integer.parseInt(txtIdServicio.getText().toString()),
                            txtNombreServicio.getText().toString(),
                            txtDescripcionServicio.getText().toString(),
                            servicioCasoUso.imageViewToByte(imgSelectedServicio)
                    );
                    limpiarCampos();
                    Toast.makeText(getContext(), "Se ha modificado el servicio",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception exc) {
                    Toast.makeText(getContext(), "Se ha presentado un error " +
                            exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnListaServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Variable que representa el fragment servicio
                 */
                Fragment frgServicio = new ServicioFragment();

                /**
                 * Carga de fragment inicial en la pantalla
                 */
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.lytFragments, frgServicio).commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
    /**
     * Método para limpiar campos del formulario
     */
    public void limpiarCampos() {
        txtIdServicio.setText("");
        txtNombreServicio.setText("");
        txtDescripcionServicio.setText("");
        imgSelectedServicio.setImageResource(R.mipmap.ic_launcher);
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
                imgSelectedServicio.setImageBitmap(bitmapImagen);
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