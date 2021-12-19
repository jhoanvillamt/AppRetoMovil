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
import com.example.appretomovil.caso_uso.ServicioCasoUso;
import com.example.appretomovil.modelo.Servicio;
import com.example.appretomovil.modelo.adaptador.ServicioAdaptador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DB Volley Servicio
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class ServicioVolley {

    /**
     * Variable que representa la URL de la api
     */
    private String url = "https://ga46e7de0098fb0-miyagidb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/servicio/servicio";

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
    private ServicioCasoUso servicioCasoUso;

    /**
     * Método constructor de la clase ServicioVolley
     *
     * @param contexto contexto de la aplicación
     */
    public ServicioVolley(Context contexto) {
        this.contexto = contexto;
        this.queue = Volley.newRequestQueue(contexto);
        this.servicioCasoUso = new ServicioCasoUso();
    }

    /**
     * Método para inserción de servicios
     *
     * @param nombre      nombre del servicio
     * @param descripcion descripción del servicio
     * @param imagen      imagen del servicio
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertServicio(String nombre, String descripcion, byte[] imagen) {

        String img = servicioCasoUso.byteToString(imagen);
        JSONObject postServicio = new JSONObject();

        try {
            postServicio.put("nombre", nombre);
            postServicio.put("descripcion", descripcion);
            postServicio.put("imagen", img);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //System.out.println(postServicio.toString());

        JsonObjectRequest postServicioReq = new JsonObjectRequest(
                Request.Method.POST,
                url,
                postServicio,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(contexto, "Se ha registrado el servicio",
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
        queue.add(postServicioReq);
    }

    /**
     * Método para consulta de todos los servicios
     *
     * @param listView ListView para cargue de consulta
     */
    public void getServicio(ListView listView) {
        List<Servicio> listado = new ArrayList<>();

        JsonObjectRequest getServicioReq = new JsonObjectRequest(
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
                                System.out.println(jsonObject.toString());

                                listado.add(new Servicio(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("nombre"),
                                        jsonObject.getString("descripcion"),
                                        servicioCasoUso.stringToByte(jsonObject.getString("imagen"))
                                ));
                            }

                            ServicioAdaptador servicioAdaptador = new ServicioAdaptador(contexto,
                                    listado);
                            listView.setAdapter(servicioAdaptador);

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

        queue.add(getServicioReq);
    }

    /**
     * Método para consulta de todos los servicios en formato String
     */
    public void getServicioString() {
        List<Servicio> listado = new ArrayList<>();

        JsonObjectRequest getServicioReq = new JsonObjectRequest(
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
                                System.out.println(jsonObject.toString());

                                listado.add(new Servicio(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("nombre"),
                                        jsonObject.getString("descripcion"),
                                        servicioCasoUso.stringToByte(jsonObject.getString("imagen"))
                                ));
                            }

                            Toast.makeText(contexto, servicioCasoUso.listadoToString(listado),
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

        queue.add(getServicioReq);
    }

    /**
     * Método para consulta y mostrar un servicio específico
     *
     * @param idServicio identificador del servicio
     * @param imagenView ImageView que carga la imagen
     * @param nombreTxt EditText que carga el nombre
     * @param descripcionTxt EditText que carga la descripción
     */
    public void getServicioById(Integer idServicio, ImageView imagenView,
                                EditText nombreTxt, EditText descripcionTxt){

        JsonObjectRequest getOneServicioReq = new JsonObjectRequest(
                Request.Method.GET,
                url + "/" + idServicio,
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
                        imagenView.setImageBitmap(servicioCasoUso.cargarBitmap(servicioCasoUso
                                .stringToByte(jsonObject.getString("imagen"))));
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

        queue.add(getOneServicioReq);
    }

    /**
     * Método para eliminar de un servicio específico
     *
     * @param idServicio identificador del servicio
     */
    public void deleteServicio(Integer idServicio) {
        JsonObjectRequest deleteServicioReq = new JsonObjectRequest(
                Request.Method.DELETE,
                url + "/" + idServicio,
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

        queue.add(deleteServicioReq);
    }

    /**
     * Método para modificar de servicios
     *
     * @param idServicio identificador del servicio
     * @param nombre      nombre del servicio
     * @param descripcion descripción del servicio
     * @param imagen      imagen del servicio
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateServicio(Integer idServicio, String nombre, String descripcion,
                               byte[] imagen) {
        String img = servicioCasoUso.byteToString(imagen);

        JSONObject putServicio = new JSONObject();
        try {
            putServicio.put("id", idServicio);
            putServicio.put("nombre", nombre);
            putServicio.put("descripcion", descripcion);
            putServicio.put("imagen", img);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest putServicioReq = new JsonObjectRequest(
                Request.Method.PUT,
                url,
                putServicio,
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
        queue.add(putServicioReq);
    }
}
