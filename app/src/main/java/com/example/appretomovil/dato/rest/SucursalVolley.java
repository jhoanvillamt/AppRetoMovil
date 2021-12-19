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
import com.example.appretomovil.caso_uso.SucursalCasoUso;
import com.example.appretomovil.modelo.Sucursal;
import com.example.appretomovil.modelo.adaptador.SucursalAdaptador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DB Volley Sucursal
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class SucursalVolley {

    /**
     * Variable que representa la URL de la api
     */
    private String url = "https://ga46e7de0098fb0-miyagidb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/sucursal/sucursal";

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
    private SucursalCasoUso sucursalCasoUso;

    /**
     * Método constructor de la clase SucursalVolley
     *
     * @param contexto contexto de la aplicación
     */
    public SucursalVolley(Context contexto) {
        this.contexto = contexto;
        this.queue = Volley.newRequestQueue(contexto);
        this.sucursalCasoUso = new SucursalCasoUso();
    }

    /**
     * Método para inserción de sucursales
     *
     * @param nombre nombre de la sucursal
     * @param direccion dirección de la sucursal
     * @param telefono teléfono de la sucursal
     * @param horario horario de atención de la sucursal
     * @param latitud latitud de la coordenada de la sucursal
     * @param longitud longitud de la coordenada de la sucursal
     * @param imagen imagen del producto
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertSucursal(String nombre, String direccion, Integer telefono, String horario,
                               Double latitud, Double longitud, byte[] imagen) {

        String img = sucursalCasoUso.byteToString(imagen);
        JSONObject postSucursal = new JSONObject();

        try {
            postSucursal.put("nombre", nombre);
            postSucursal.put("direccion", direccion);
            postSucursal.put("telefono", telefono);
            postSucursal.put("horario", horario);
            postSucursal.put("latitud", latitud);
            postSucursal.put("longitud", longitud);
            postSucursal.put("imagen", img);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest postSucursalReq = new JsonObjectRequest(
                Request.Method.POST,
                url,
                postSucursal,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(contexto, "Se ha registrado la sucursal",
                     Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Gestión de método innecesario
            }
        });
        queue.add(postSucursalReq);
    }

    /**
     * Método para consulta de todas las sucursales
     *
     * @param listView ListView para cargue de consulta
     */
    public void getSucursal(ListView listView) {
        List<Sucursal> listado = new ArrayList<>();

        JsonObjectRequest getSucursalReq = new JsonObjectRequest(
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

                                listado.add(new Sucursal(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("nombre"),
                                        jsonObject.getString("direccion"),
                                        jsonObject.getInt("telefono"),
                                        jsonObject.getString("horario"),
                                        jsonObject.getDouble("latitud"),
                                        jsonObject.getDouble("longitud"),
                                        sucursalCasoUso.stringToByte(jsonObject.getString("imagen"))
                                ));
                            }

                            SucursalAdaptador sucursalAdaptador = new SucursalAdaptador(contexto,
                                    listado);
                            listView.setAdapter(sucursalAdaptador);

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

        queue.add(getSucursalReq);
    }

    /**
     * Método para consulta de todas las sucursales para el mapa
     *
     * @param osmMapView MapView para cargue de consulta
     * @param osmMapController marca de identificación de los puntos
     */
    public void getSucursalMap(MapView osmMapView,
                               MapController osmMapController) {
        List<OverlayItem> puntos = new ArrayList<>();
        GeoPoint bogota = new GeoPoint(4.6351,-74.0703);


        JsonObjectRequest getSucursalReq = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");

                            osmMapView.setBuiltInZoomControls(true);

                            osmMapController.setCenter(bogota);
                            osmMapController.setZoom(6);

                            osmMapView.setMultiTouchControls(true);

                            final MyLocationNewOverlay locationOverlay = new MyLocationNewOverlay(
                                    new GpsMyLocationProvider(contexto),
                                    osmMapView
                            );
                            osmMapView.getOverlays().add(locationOverlay);
                            locationOverlay.enableMyLocation();

                            locationOverlay.runOnFirstFix(new Runnable() {
                                @Override
                                public void run() {
                                    osmMapController.animateTo(locationOverlay.getMyLocation());
                                }
                            });

                            ItemizedIconOverlay.OnItemGestureListener<OverlayItem> marca = new ItemizedIconOverlay
                                    .OnItemGestureListener<OverlayItem>() {
                                @Override
                                public boolean onItemSingleTapUp(int index, OverlayItem item) {
                                    return false;
                                }

                                @Override
                                public boolean onItemLongPress(int index, OverlayItem item) {
                                    return false;
                                }
                            };

                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                GeoPoint sucursal = new GeoPoint(
                                        jsonObject.getDouble("latitud"),
                                        jsonObject.getDouble("longitud")
                                );

                                puntos.add(new OverlayItem(
                                        jsonObject.getString("nombre"),
                                        jsonObject.getString("direccion"),
                                        sucursal
                                ));
                            }

                            ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(
                                    contexto, puntos, marca);
                            capa.setFocusItemsOnTap(true);
                            osmMapView.getOverlays().add(capa);

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

        queue.add(getSucursalReq);
    }

    /**
     * Método para consulta de todas las sucursales en formato String
     */
    public void getSucursalString() {
        List<Sucursal> listado = new ArrayList<>();

        JsonObjectRequest getSucursalReq = new JsonObjectRequest(
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

                                listado.add(new Sucursal(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("nombre"),
                                        jsonObject.getString("direccion"),
                                        jsonObject.getInt("telefono"),
                                        jsonObject.getString("horario"),
                                        jsonObject.getDouble("latitud"),
                                        jsonObject.getDouble("longitud"),
                                        sucursalCasoUso.stringToByte(jsonObject.getString("imagen"))
                                ));
                            }

                            Toast.makeText(contexto, sucursalCasoUso.listadoToString(listado),
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

        queue.add(getSucursalReq);
    }

    /**
     * Método para consulta de una sucursal específica
     *
     * @param idSucursal identificador de la sucursal
     * @param imagenView ImageView que carga la imagen
     * @param nombreTxt EditText que carga el nombre
     * @param direccionTxt EditText que carga la dirección
     * @param telefonoTxt EditText que carga el teléfono
     * @param horarioTxt EditText que carga el horario de atención
     * @param latitudTxt EditText que carga la latitud
     * @param longitudTxt EditText que carga la longitud
     */
    public void getSucursalById(Integer idSucursal, EditText nombreTxt,
                                          EditText direccionTxt, EditText telefonoTxt,
                                          EditText horarioTxt, EditText latitudTxt,
                                          EditText longitudTxt, ImageView imagenView) {

        JsonObjectRequest getOneSucursalReq = new JsonObjectRequest(
                Request.Method.GET,
                url + "/" + idSucursal,
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
                                direccionTxt.setText(jsonObject.getString("direccion"));
                                telefonoTxt.setText(jsonObject.getString("telefono"));
                                horarioTxt.setText(jsonObject.getString("horario"));
                                latitudTxt.setText(jsonObject.getString("latitud"));
                                longitudTxt.setText(jsonObject.getString("longitud"));
                                imagenView.setImageBitmap(sucursalCasoUso.cargarBitmap(
                                        sucursalCasoUso.stringToByte(jsonObject.getString("imagen"))));
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

        queue.add(getOneSucursalReq);
    }

    /**
     * Método para eliminar de una sucursal específica
     *
     * @param idSucursal identificador de la sucursal
     */
    public void deleteSucursal(Integer idSucursal) {
        JsonObjectRequest deleteSucursalReq = new JsonObjectRequest(
                Request.Method.DELETE,
                url + "/" + idSucursal,
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

        queue.add(deleteSucursalReq);
    }

    /**
     * Método para modificar de sucursales
     *
     * @param idSucursal identificador de la sucursal
     * @param nombre nombre de la sucursal
     * @param direccion dirección de la sucursal
     * @param telefono teléfono de la sucursal
     * @param horario horario de atención de la sucursal
     * @param latitud latitud de la coordenada de la sucursal
     * @param longitud longitud de la coordenada de la sucursal
     * @param imagen imagen del producto
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateSucursal(Integer idSucursal, String nombre, String direccion,
                               Integer telefono, String horario, Double latitud, Double longitud,
                               byte[] imagen) {
        String img = sucursalCasoUso.byteToString(imagen);
        JSONObject putSucursal = new JSONObject();

        try {
            putSucursal.put("id", idSucursal);
            putSucursal.put("nombre", nombre);
            putSucursal.put("direccion", direccion);
            putSucursal.put("telefono", telefono);
            putSucursal.put("horario", horario);
            putSucursal.put("latitud", latitud);
            putSucursal.put("longitud", longitud);
            putSucursal.put("imagen", img);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest putSucursalReq = new JsonObjectRequest(
                Request.Method.PUT,
                url,
                putSucursal,
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
        queue.add(putSucursalReq);
    }
}
