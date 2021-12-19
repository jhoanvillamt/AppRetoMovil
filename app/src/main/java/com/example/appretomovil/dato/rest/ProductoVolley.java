package com.example.appretomovil.dato.rest;

import android.content.Context;
import android.os.Build;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.appretomovil.caso_uso.ProductoCasoUso;
import com.example.appretomovil.modelo.Producto;
import com.example.appretomovil.modelo.adaptador.ProductoAdaptador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DB Volley Producto
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class ProductoVolley {

    /**
     * Variable que representa la URL de la api
     */
    private String url = "https://ga46e7de0098fb0-miyagidb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/producto/producto";

    /**
     * Variable que representa la cola de peticiones
     */
    private RequestQueue queue;

    /**
     * Variable que representa el contexto de la aplicación
     */
    private Context contexto;

    /**
     * Variable que representa las funciones complementarias
     */
    private ProductoCasoUso productoCasoUso;

    /**
     * Método constructor de la clase ProductoVolley
     *
     * @param contexto contexto de la aplicación
     */
    public ProductoVolley(Context contexto) {
        this.contexto = contexto;
        this.queue = Volley.newRequestQueue(contexto);
        this.productoCasoUso = new ProductoCasoUso();
    }

    /**
     * Método para inserción de productos
     *
     * @param nombre      nombre del producto
     * @param precio      precio del producto
     * @param descripcion descripción del producto
     * @param imagen      imagen del producto
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertProducto(String nombre, Double precio, String descripcion, byte[] imagen) {

        String img = productoCasoUso.byteToString(imagen);
        JSONObject postProducto = new JSONObject();
        try {
            postProducto.put("nombre", nombre);
            postProducto.put("descripcion", descripcion);
            postProducto.put("precio", precio);
            postProducto.put("imagen", img);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest postProductoReq = new JsonObjectRequest(
                Request.Method.POST,
                url,
                postProducto,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(contexto, "Se ha registrado el producto",
                     Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(contexto, "Error: " + error.toString() + " ---- " +
                                error.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(postProductoReq);
    }

    /**
     * Método para consulta de todos los productos
     *
     * @param listView ListView para cargue de consulta
     */
    public void getProducto(ListView listView) {
        List<Producto> listado = new ArrayList<>();

        JsonObjectRequest getProductoReq = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");
                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                listado.add(new Producto(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("nombre"),
                                        jsonObject.getDouble("precio"),
                                        jsonObject.getString("descripcion"),
                                        productoCasoUso.stringToByte(jsonObject.getString("imagen"))
                                ));
                            }

                            ProductoAdaptador productoAdaptador = new ProductoAdaptador(contexto,
                                    listado);
                            listView.setAdapter(productoAdaptador);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Gestión de método innecesario
            }
        });

        queue.add(getProductoReq);
    }

    /**
     * Método para consulta de todos los productos en formato String
     */
    public void getProductoString() {
        List<Producto> listado = new ArrayList<>();

        JsonObjectRequest getProductoReq = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");
                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                listado.add(new Producto(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("nombre"),
                                        jsonObject.getDouble("precio"),
                                        jsonObject.getString("descripcion"),
                                        productoCasoUso.stringToByte(jsonObject.getString("imagen"))
                                ));
                            }

                            Toast.makeText(contexto, productoCasoUso.listadoToString(listado),
                                    Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Gestión de método innecesario
            }
        });

        queue.add(getProductoReq);
    }

    /**
     * Método para consulta de un producto específico
     *
     * @param idProducto identificador del producto
     * @param imagenView ImageView que carga la imagen
     * @param nombreTxt EditText que carga el nombre
     * @param descripcionTxt EditText que carga la descripción
     * @param precioTxt EditText que carga el precio
     */
    public void getProductoById(Integer idProducto, EditText nombreTxt,
                                          EditText descripcionTxt, EditText precioTxt,
                                          ImageView imagenView) {

        JsonObjectRequest getOneProductoReq = new JsonObjectRequest(
                Request.Method.GET,
                url + "/" + idProducto,
                null,
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");
                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                nombreTxt.setText(jsonObject.getString("nombre"));
                                descripcionTxt.setText(jsonObject.getString("descripcion"));
                                precioTxt.setText(jsonObject.getString("precio"));
                                imagenView.setImageBitmap(productoCasoUso.cargarBitmap(
                                        productoCasoUso.stringToByte(jsonObject.getString("imagen"))));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Gestión de método innecesario
            }
        });

        queue.add(getOneProductoReq);
    }

    /**
     * Método para eliminar de un producto específico
     *
     * @param idProducto identificador del producto
     */
    public void deleteProducto(Integer idProducto) {
        JsonObjectRequest deleteProductoReq = new JsonObjectRequest(
                Request.Method.DELETE,
                url + "/" + idProducto,
                null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Gestión de método innecesario
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Gestión de método innecesario
            }
        });

        queue.add(deleteProductoReq);
    }

    /**
     * Método para modificar de productos
     *
     * @param idProducto identificador del producto
     * @param nombre      nombre del producto
     * @param precio      precio del producto
     * @param descripcion descripción del producto
     * @param imagen      imagen del producto
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateProducto(Integer idProducto, String nombre, Double precio, String descripcion,
                               byte[] imagen) {
        String img = productoCasoUso.byteToString(imagen);
        JSONObject putProducto = new JSONObject();
        try {
            putProducto.put("id", idProducto);
            putProducto.put("nombre", nombre);
            putProducto.put("descripcion", descripcion);
            putProducto.put("precio", precio);
            putProducto.put("imagen", img);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest putProductoReq = new JsonObjectRequest(
                Request.Method.PUT,
                url,
                putProducto,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Gestión de método innecesario
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Gestión de método innecesario
            }
        });
        queue.add(putProductoReq);
    }
}
