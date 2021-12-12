package com.example.appretomovil.modelo;

/**
 * Clase Entity Producto
 *
 * @version 1.0
 * @author Jhoan Villa G35 C4
 */
public class Producto {

    /**
     * Variable que representa el id del producto
     */
    Integer id;

    /**
     * Variable que representa el nombre del producto
     */
    String nombre;

    /**
     * Variable que representa el precio del producto
     */
    Double precio;

    /**
     * Variable que representa la descripción del producto
     */
    String descripcion;

    /**
     * Variable que representa la imagen del producto
     */
    byte[] imagen;

    /**
     * Método constructor de la clase Producto
     *
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param descripcion descripción del producto
     * @param imagen imagen del producto
     */
    public Producto(String nombre, Double precio, String descripcion, byte[] imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    /**
     * Método constructor de la clase Producto
     *
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param descripcion descripción del producto
     * @param imagen imagen del producto
     */
    public Producto(Integer id, String nombre, Double precio, String descripcion, byte[] imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    /**
     * Método get: permite consultar el identificador del producto
     *
     * @return identificador del producto
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método set: permite ingresar y/o modificar el identificador del producto
     *
     * @param id identificador del producto
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método get: permite consultar el nombre del producto
     *
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set: permite ingresar y/o modificar el nombre del producto
     *
     * @param nombre nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get: permite consultar el precio del producto
     *
     * @return precio del producto
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Método set: permite ingresar y/o modificar el precio del producto
     *
     * @param precio precio del producto
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Método get: permite consultar la descripción del producto
     *
     * @return descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método set: permite ingresar y/o modificar la descripción del producto
     *
     * @param descripcion descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método get: permite consultar la imagen del producto
     *
     * @return imagen del producto
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Método set: permite ingresar y/o modificar la imagen del producto
     *
     * @param imagen imagen del producto
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
