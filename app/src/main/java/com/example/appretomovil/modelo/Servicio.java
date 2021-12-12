package com.example.appretomovil.modelo;

/**
 * Clase Entity Servicio
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class Servicio {

    /**
     * Variable que representa el id del servicio
     */
    Integer id;

    /**
     * Variable que representa el nombre del servicio
     */
    String nombre;

    /**
     * Variable que representa la descripción del servicio
     */
    String descripcion;

    /**
     * Variable que representa la imagen del servicio
     */
    byte[] imagen;

    /**
     * Método constructor de la clase Servicio
     *
     * @param nombre nombre del servicio
     * @param descripcion descripción del servicio
     * @param imagen imagen del servicio
     */
    public Servicio(String nombre, String descripcion, byte[] imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    /**
     * Método constructor de la clase Servicio
     *
     * @param id identificador del servicio
     * @param nombre nombre del servicio
     * @param descripcion descripción del servicio
     * @param imagen imagen del servicio
     */
    public Servicio(Integer id, String nombre, String descripcion, byte[] imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    /**
     * Método get: permite consultar el identificador del servicio
     *
     * @return identificador del servicio
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método set: permite ingresar y/o modificar el identificador del servicio
     *
     * @param id identificador del servicio
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método get: permite consultar el nombre del servicio
     *
     * @return nombre del servicio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set: permite ingresar y/o modificar el nombre del servicio
     *
     * @param nombre nombre del servicio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get: permite consultar la descripción del servicio
     *
     * @return descripción del servicio
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método set: permite ingresar y/o modificar la descripción del servicio
     *
     * @param descripcion descripción del servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método get: permite consultar la imagen del servicio
     *
     * @return imagen del servicio
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Método set: permite ingresar y/o modificar la imagen del servicio
     *
     * @param imagen imagen del servicio
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
