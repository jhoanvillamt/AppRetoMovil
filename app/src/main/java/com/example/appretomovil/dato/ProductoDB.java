package com.example.appretomovil.dato;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

/**
 * Clase DB Producto
 *
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class ProductoDB extends SQLiteOpenHelper {

    /**
     * Variable que representa la base de datos para registro de información
     */
    private SQLiteDatabase sqLiteDatabase;

    /**
     * Método constructor de la clase ProductoDB
     *
     * @param context contexto usado para localizar la ruta de la base de datos
     */
    public ProductoDB(@Nullable Context context) {
        super(context, "miyagi", null, 1);
        sqLiteDatabase = this.getWritableDatabase();
    }

    /**
     * Método que permite la creación de la base de datos
     *
     * @param db base de datos
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS favorito (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "producto INTEGER," +
                "nombre VARCHAR," +
                "precio FLOAT," +
                "descripcion VARCHAR," +
                "imagen BLOB" +
                ")");
    }

    /**
     * Método que permite la actualización de la base de datos
     *
     * @param db         base de datos
     * @param oldVersion vieja versión de la dase de datos
     * @param newVersion nueva versión de la dase de datos
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS favorito");
    }

    /**
     * Método para consulta de todos los productos
     *
     * @return cursor con listado de productos
     */
    public Cursor getProducto() {
        return sqLiteDatabase.rawQuery("SELECT * FROM producto", null);
    }

    /**
     * Método para inserción de favoritos
     *
     * @param producto identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param descripcion descripción del producto
     * @param imagen imagen del producto
     */
    public void insertFavorito(Integer producto, String nombre, Double precio, String descripcion, byte[] imagen) {
        String sqlSentencia = "INSERT INTO favorito (producto, nombre, precio, descripcion, imagen) VALUES" +
                " (?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSentencia);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindLong(1, producto);
        sqLiteStatement.bindString(2, nombre);
        sqLiteStatement.bindDouble(3, precio);
        sqLiteStatement.bindString(4, descripcion);
        sqLiteStatement.bindBlob(5, imagen);
        sqLiteStatement.executeInsert();
    }

    /**
     * Método para consulta de todos los favoritos
     *
     * @return cursor con listado de productos
     */
    public Cursor getFavorito() {
        return sqLiteDatabase.rawQuery("SELECT * FROM favorito", null);
    }

    /**
     * Método para consulta de un favorito específico por id del registro
     *
     * @param idFavorito identificador del registro favorito
     * @return cursor con producto favorito
     */
    public Cursor getFavoritoById(Integer idFavorito) {
        return sqLiteDatabase.rawQuery("SELECT * FROM favorito WHERE id = ?",
                new String[]{"" + idFavorito});
    }

    /**
     * Método para consulta de un favorito específico por el ide del producto
     *
     * @param idProducto identificador del producto
     * @return cursor con producto
     */
    public Cursor getFavoritoByIdProducto(Integer idProducto) {
        return sqLiteDatabase.rawQuery("SELECT * FROM favorito WHERE producto = ?",
                new String[]{"" + idProducto});
    }

    /**
     * Método para eliminar de un favorito específico
     *
     * @param idProducto identificador del producto
     */
    public void deleteFavorito(Integer idProducto) {
        sqLiteDatabase.execSQL("DELETE FROM favorito WHERE producto=" + idProducto);
    }

    /**
     * Método para modificar de favoritos
     *
     * @param idFavorito identificador del favorito
     * @param producto identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param descripcion descripción del producto
     * @param imagen imagen del producto     *
     */
    public void updateFavorito(Integer idFavorito, Integer producto, String nombre, Double precio,
                               String descripcion, byte[] imagen) {
        String sqlSentencia = "UPDATE favorito SET producto = ? , nombre = '?', precio = ?, descripcion = '?', imagen = ? WHERE id = ?";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSentencia);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, producto.toString());
        sqLiteStatement.bindString(2, nombre);
        sqLiteStatement.bindDouble(3, precio);
        sqLiteStatement.bindString(4, descripcion);
        sqLiteStatement.bindBlob(5, imagen);
        sqLiteStatement.bindString(6, idFavorito.toString());
        sqLiteStatement.executeUpdateDelete();
    }

    /**
     * Método para consulta de todas las sucursales
     *
     * @return cursor con listado de sucursales
     */
    public Cursor getSucursal() {
        return sqLiteDatabase.rawQuery("SELECT * FROM sucursal", null);
    }
}



