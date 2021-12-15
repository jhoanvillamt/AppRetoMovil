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
import com.example.appretomovil.caso_uso.SucursalCasoUso;
import com.example.appretomovil.dato.ProductoDB;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clase Fragment Formulario Sucursal
 *
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class FormSucursalFragment extends Fragment {

    /**
     * Variable que representa los permisos solicitados para acceso a galeria
     */
    private final static int READ_CODE_GALLERY = 999;

    /**
     * Variable que representa el campo del nombre en el formulario
     */
    private EditText txtNombreSucursal;

    /**
     * Variable que representa el campo de la dirección en el formulario
     */
    private EditText txtDireccionSucursal;

    /**
     * Variable que representa el campo del teléfono en el formulario
     */
    private EditText txtTelefonoSucursal;

    /**
     * Variable que representa el campo del horario de atención en el formulario
     */
    private EditText txtHorarioSucursal;

    /**
     * Variable que representa el campo de la latitud en el formulario
     */
    private EditText txtLatitudSucursal;

    /**
     * Variable que representa el campo de la longitud en el formulario
     */
    private EditText txtLongitudSucursal;

    /**
     * Variable que representa el campo del identificador en el formulario
     */
    private EditText txtIdSucursal;

    /**
     * Variable que representa el campo de la imagen en el formulario
     */
    private ImageView imgSelectedSucursal;

    /**
     * Variable que representa la instacia con la base de datos
     */
    private ProductoDB baseProducto;

    /**
     * Variable que representa la instancia con las funciones generales
     */
    private SucursalCasoUso sucursalCasoUso;

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
        View view = inflater.inflate(R.layout.fragment_form_sucursal, container, false);

        Button btnCargarImagen = (Button) view.findViewById(R.id.btnCargarSucursal);
        Button btnInsertarSucursal = (Button) view.findViewById(R.id.btnInsertarSucursal);
        Button btnConsultarSucursal = (Button) view.findViewById(R.id.btnConsultarSucursal);
        Button btnEliminarSucursal = (Button) view.findViewById(R.id.btnEliminarSucursal);
        Button btnModificarSucursal = (Button) view.findViewById(R.id.btnModificarSucursal);
        Button btnListaSucursales = (Button) view.findViewById(R.id.btnListaSucursales);

        txtNombreSucursal = (EditText) view.findViewById(R.id.txtNombreSucursal);
        txtDireccionSucursal = (EditText) view.findViewById(R.id.txtDireccionSucursal);
        txtTelefonoSucursal = (EditText) view.findViewById(R.id.txtTelefonoSucursal);
        txtHorarioSucursal = (EditText) view.findViewById(R.id.txtHorarioProducto);
        txtLatitudSucursal = (EditText) view.findViewById(R.id.txtLatitudSucursal);
        txtLongitudSucursal = (EditText) view.findViewById(R.id.txtLongitudSucursal);
        txtIdSucursal = (EditText) view.findViewById(R.id.txtIdSucursal);
        imgSelectedSucursal = (ImageView) view.findViewById(R.id.imgSelectedSucursal);

        baseProducto = new ProductoDB(getContext());
        sucursalCasoUso = new SucursalCasoUso();

        btnCargarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions(
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        READ_CODE_GALLERY
                );
            }
        });
        btnInsertarSucursal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    baseProducto.insertSucursal(
                            txtNombreSucursal.getText().toString(),
                            txtDireccionSucursal.getText().toString(),
                            Integer.parseInt(txtTelefonoSucursal.getText().toString()),
                            txtHorarioSucursal.getText().toString(),
                            Float.parseFloat(txtLatitudSucursal.getText().toString()),
                            Float.parseFloat(txtLongitudSucursal.getText().toString()),
                            sucursalCasoUso.imageViewToByte(imgSelectedSucursal)
                    );
                    limpiarCampos();
                    Toast.makeText(getContext(), "Se ha registrado la sucursal",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception exc) {
                    Toast.makeText(getContext(), "Se ha presentado un error " +
                            exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnConsultarSucursal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idText = txtIdSucursal.getText().toString().trim();
                if ("".equals(idText)) {
                    Cursor cursor = baseProducto.getSucursal();
                    String resultado = sucursalCasoUso.cursorToString(cursor);
                    Toast.makeText(getContext(), resultado, Toast.LENGTH_LONG).show();
                } else {
                    Cursor cursor = baseProducto.getSucursalById(Integer.parseInt(idText));
                    if (cursor.getCount() == 0) {
                        Toast.makeText(getContext(),  "No se encontraron datos",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        while (cursor.moveToNext()) {
                            txtNombreSucursal.setText(cursor.getString(1));
                            txtDireccionSucursal.setText(cursor.getString(2));
                            txtTelefonoSucursal.setText(cursor.getString(3));
                            txtHorarioSucursal.setText(cursor.getString(4));
                            txtLatitudSucursal.setText(cursor.getString(5));
                            txtLongitudSucursal.setText(cursor.getString(6));
                            imgSelectedSucursal.setImageBitmap(sucursalCasoUso.
                                    cargarBitmap(cursor.getBlob(7)));
                        }
                    }
                }
            }
        });
        btnEliminarSucursal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idSuc = txtIdSucursal.getText().toString().trim();
                if ("".equals(idSuc)) {
                    limpiarCampos();
                    Toast.makeText(getContext(), "No se identificó la sucursal",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Integer idSucursal = Integer.parseInt(idSuc);
                    baseProducto.deleteSucursal(idSucursal);
                    limpiarCampos();
                    Toast.makeText(getContext(), "La sucursal ha sido eliminada",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnModificarSucursal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    baseProducto.updateSucursal(
                            Integer.parseInt(txtIdSucursal.getText().toString()),
                            txtNombreSucursal.getText().toString(),
                            txtDireccionSucursal.getText().toString(),
                            Integer.parseInt(txtTelefonoSucursal.getText().toString()),
                            txtHorarioSucursal.getText().toString(),
                            Float.parseFloat(txtLatitudSucursal.getText().toString()),
                            Float.parseFloat(txtLongitudSucursal.getText().toString()),
                            sucursalCasoUso.imageViewToByte(imgSelectedSucursal)
                    );
                    limpiarCampos();
                    Toast.makeText(getContext(), "Se ha modificado la sucursal",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception exc) {
                    Toast.makeText(getContext(), "Se ha presentado un error " +
                            exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnListaSucursales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Variable que representa el fragment sucursal
                 */
                Fragment frgSucursal = new SucursalFragment();

                /**
                 * Carga de fragment inicial en la pantalla
                 */
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.lytFragments, frgSucursal).commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    /**
     * Método para limpiar campos del formulario
     */
    public void limpiarCampos() {
        txtIdSucursal.setText("");
        txtNombreSucursal.setText("");
        txtDireccionSucursal.setText("");
        txtTelefonoSucursal.setText("");
        txtTelefonoSucursal.setText("");
        imgSelectedSucursal.setImageResource(R.mipmap.ic_launcher);
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
                imgSelectedSucursal.setImageBitmap(bitmapImagen);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
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