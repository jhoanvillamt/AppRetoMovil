package com.example.appretomovil.modelo;

/**
 * Clase Entity Sucursal
 *
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class Sucursal {

    /**
     * Variable que representa el id de la sucursal
     */
    Integer id;

    /**
     * Variable que representa el nombre de la sucursal
     */
    String nombre;

    /**
     * Variable que representa la dirección de la sucursal
     */
    String direccion;

    /**
     * Variable que representa el teléfono de la sucursal
     */
    Integer telefono;

    /**
     * Variable que representa el horrio de atención de la sucursal
     */
    String horario;

    /**
     * Variable que representa la latitud de la sucursal
     */
    Double latitud;

    /**
     * Variable que representa la longitud de la sucursal
     */
    Double longitud;

    /**
     * Variable que representa la imagen de la sucursal
     */
    byte[] imagen;

    /**
     * Método constructor de la clase Sucursal
     *
     * @param nombre nombre de la sucursal
     * @param direccion dirección de la sucursal
     * @param telefono teléfono de la sucursal
     * @param horario horario de atención de la sucursal
     * @param latitud latitud de la sucursal
     * @param longitud longitud de la sucursal
     * @param imagen imagen del producto
     */
    public Sucursal(String nombre, String direccion, Integer telefono, String horario,
                    Double latitud, Double longitud, byte[] imagen) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    /**
     * Método constructor de la clase Sucursal
     *
     * @param id identificador de la sucursal
     * @param nombre nombre de la sucursal
     * @param direccion dirección de la sucursal
     * @param telefono teléfono de la sucursal
     * @param horario horario de atención de la sucursal
     * @param latitud latitud de la sucursal
     * @param longitud longitud de la sucursal
     * @param imagen imagen del producto
     */
    public Sucursal(Integer id, String nombre, String direccion, Integer telefono, String horario,
                    Double latitud, Double longitud, byte[] imagen) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    /**
     * Método get: permite consultar el identificador de la sucursal
     *
     * @return identificador de la sucursal
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método set: permite ingresar y/o modificar el identificador de la sucursal
     *
     * @param id identificador de la sucursal
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método get: permite consultar el nombre de la sucursal
     *
     * @return nombre de la sucursal
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set: permite ingresar y/o modificar el nombre de la sucursal
     *
     * @param nombre nombre de la sucursal
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get: permite consultar la dirección de la sucursal
     *
     * @return dirección de la sucursal
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método set: permite ingresar y/o modificar la dirección de la sucursal
     *
     * @param direccion dirección de la sucursal
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método get: permite consultar el teléfono de la sucursal
     *
     * @return teléfono de la sucursal
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * Método set: permite ingresar y/o modificar el teléfono de la sucursal
     *
     * @param telefono teléfono de la sucursal
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * Método get: permite consultar el horario de atención de la sucursal
     *
     * @return horario de atención de la sucursal
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Método set: permite ingresar y/o modificar el horario de atención de la sucursal
     *
     * @param horario horario de atención de la sucursal
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Método get: permite consultar la latitud de la sucursal
     *
     * @return latitud de la sucursal
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * Método set: permite ingresar y/o modificar la longitud de la sucursal
     *
     * @param latitud latitud de la sucursal
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    /**
     * Método get: permite consultar la longitud de la sucursal
     *
     * @return longitud de la sucursal
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * Método set: permite ingresar y/o modificar la longitud de la sucursal
     *
     * @param longitud longitud de la sucursal
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * Método get: permite consultar la imagen de la sucursal
     *
     * @return imagen de la sucursal
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Método set: permite ingresar y/o modificar la imagen de la sucursal
     *
     * @param imagen imagen de la sucursal
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
