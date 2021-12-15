package com.example.appretomovil.dato;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.Nullable;

import com.example.appretomovil.R;

import java.io.ByteArrayOutputStream;

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
     * Variable que representa el contexto de la aplicación
     */
    private Context contexto;

    /**
     * Método constructor de la clase ProductoDB
     *
     * @param context contexto usado para localizar la ruta de la base de datos
     */
    public ProductoDB(@Nullable Context context) {
        super(context, "miyagi", null, 1);
        this.contexto = context;
        sqLiteDatabase = this.getWritableDatabase();
    }

    /**
     * Método que permite la creación de la base de datos
     *
     * @param db base de datos
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS producto (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre VARCHAR," +
                "precio FLOAT," +
                "descripcion VARCHAR," +
                "imagen BLOB" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS favorito (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "producto INTEGER," +
                "nombre VARCHAR," +
                "precio FLOAT," +
                "descripcion VARCHAR," +
                "imagen BLOB" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS servicio (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre VARCHAR," +
                "descripcion VARCHAR," +
                "imagen BLOB" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS sucursal (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre VARCHAR," +
                "direccion VARCHAR," +
                "telefono INTEGER," +
                "horario VARCHAR," +
                "latitud  FLOAT," +
                "longitud FLOAT," +
                "imagen BLOB" +
                ")");

        /**
         * Carga de imágenes dentro de drawable para insertar
         */
        Bitmap chaqueta1 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.chq1);
        ByteArrayOutputStream streamc1 = new ByteArrayOutputStream();
        chaqueta1.compress(Bitmap.CompressFormat.PNG, 100, streamc1);
        byte[] bytec1 = streamc1.toByteArray();

        Bitmap chaqueta2 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.chq2);
        ByteArrayOutputStream streamc2 = new ByteArrayOutputStream();
        chaqueta2.compress(Bitmap.CompressFormat.PNG, 100, streamc2);
        byte[] bytec2 = streamc2.toByteArray();

        Bitmap chaqueta3 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.chq3);
        ByteArrayOutputStream streamc3 = new ByteArrayOutputStream();
        chaqueta3.compress(Bitmap.CompressFormat.PNG, 100, streamc3);
        byte[] bytec3 = streamc3.toByteArray();

        Bitmap servicio1 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.srv1);
        ByteArrayOutputStream streamsv1 = new ByteArrayOutputStream();
        servicio1.compress(Bitmap.CompressFormat.PNG, 100, streamsv1);
        byte[] bytesrv1 = streamsv1.toByteArray();

        Bitmap servicio2 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.srv2);
        ByteArrayOutputStream streamsv2 = new ByteArrayOutputStream();
        servicio2.compress(Bitmap.CompressFormat.PNG, 100, streamsv2);
        byte[] bytesrv2 = streamsv2.toByteArray();

        Bitmap servicio3 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.srv3);
        ByteArrayOutputStream streamsv3 = new ByteArrayOutputStream();
        servicio3.compress(Bitmap.CompressFormat.PNG, 100, streamsv3);
        byte[] bytesrv3 = streamsv3.toByteArray();

        Bitmap sucursal1 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.scs1);
        ByteArrayOutputStream streamsc1 = new ByteArrayOutputStream();
        sucursal1.compress(Bitmap.CompressFormat.PNG, 100, streamsc1);
        byte[] bytescs1 = streamsc1.toByteArray();

        Bitmap sucursal2 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.scs2);
        ByteArrayOutputStream streamsc2 = new ByteArrayOutputStream();
        sucursal2.compress(Bitmap.CompressFormat.PNG, 100, streamsc2);
        byte[] bytescs2 = streamsc2.toByteArray();

        Bitmap sucursal3 = BitmapFactory.decodeResource(contexto.getResources(),
                R.drawable.scs3);
        ByteArrayOutputStream streamsc3 = new ByteArrayOutputStream();
        sucursal3.compress(Bitmap.CompressFormat.PNG, 100, streamsc3);
        byte[] bytescs3 = streamsc3.toByteArray();

        db.execSQL("INSERT INTO producto (nombre,descripcion,precio,imagen) VALUES ('Chaqueta sport','Todas las tallas\nTodos los colores\nAlgodón nacional',150000,?)",
                new Object[]{bytec1});
        db.execSQL("INSERT INTO producto (nombre,descripcion,precio,imagen) VALUES ('Chaqueta rock','Todas las tallas\nTodos los colores\nCuero sintético',280000,?)",
                new Object[]{bytec2});
        db.execSQL("INSERT INTO producto (nombre,descripcion,precio,imagen) VALUES ('Chaqueta piloto','Todas las tallas\nTodos los colores\nRelleno antialérgico',190000,?)",
                new Object[]{bytec3});
        db.execSQL("INSERT INTO producto (nombre,descripcion,precio,imagen) VALUES ('Chaqueta sport 2','Todas las tallas\nTodos los colores\nAlgodón nacional',150000,?)",
                new Object[]{bytec1});
        db.execSQL("INSERT INTO producto (nombre,descripcion,precio,imagen) VALUES ('Chaqueta rock 2','Todas las tallas\nTodos los colores\nCuero sintético',280000,?)",
                new Object[]{bytec2});
        db.execSQL("INSERT INTO producto (nombre,descripcion,precio,imagen) VALUES ('Chaqueta piloto 2','Todas las tallas\nTodos los colores\nRelleno antialérgico',190000,?)",
                new Object[]{bytec3});

        db.execSQL("INSERT INTO servicio (nombre,descripcion,imagen) VALUES ('Domicilio express','Envío a todo lugar\nTransporte propio de nuestras sucursales',?)",
                new Object[]{bytesrv1});
        db.execSQL("INSERT INTO servicio (nombre,descripcion,imagen) VALUES ('Confección al mayoreo','Diseño de uniformes coorporativos',?)",
                new Object[]{bytesrv2});
        db.execSQL("INSERT INTO servicio (nombre,descripcion,imagen) VALUES ('Diseños ocasionales','Elaboración de chaquetas personalizadas',?)",
                new Object[]{bytesrv3});

        db.execSQL("INSERT INTO sucursal (nombre,direccion,telefono,horario,latitud,longitud,imagen) VALUES ('Sucursal Bogotá','Cra. 8 # 10 - 65',8742843,'Lunes a Viernes\n8:30 am - 5:00 pm',4.598680783378407,-74.07648816711271,?)",
                new Object[]{bytescs1});
        db.execSQL("INSERT INTO sucursal (nombre,direccion,telefono,horario,latitud,longitud,imagen) VALUES ('Sucursal Medellín','Cll. 44 # 52 - 165',7648384,'Lunes a Viernes\n9:00 am - 5:00 pm',6.24531867194279,-75.5737043888851,?)",
                new Object[]{bytescs2});
        db.execSQL("INSERT INTO sucursal (nombre,direccion,telefono,horario,latitud,longitud,imagen) VALUES ('Sucursal Cali','Av. 2 Nte. # 10 - 70',3435539,'Lunes a Viernes\n10:00 am - 3:00 pm',3.4543921395747,-76.53420718249488,?)",
                new Object[]{bytescs3});

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
        db.execSQL("DROP TABLE IF EXISTS producto");
        db.execSQL("DROP TABLE IF EXISTS favorito");
        db.execSQL("DROP TABLE IF EXISTS servicio");
        db.execSQL("DROP TABLE IF EXISTS sucursal");
    }

    /**
     * Método para inserción de productos
     *
     * @param nombre      nombre del producto
     * @param precio      precio del producto
     * @param descripcion descripción del producto
     * @param imagen      imagen del producto
     */
    public void insertProducto(String nombre, Double precio, String descripcion, byte[] imagen) {
        String sqlSentencia = "INSERT INTO producto (nombre, precio, descripcion, imagen) VALUES" +
                " (?,?,?,?)";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSentencia);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, nombre);
        sqLiteStatement.bindDouble(2, precio);
        sqLiteStatement.bindString(3, descripcion);
        sqLiteStatement.bindBlob(4, imagen);
        sqLiteStatement.executeInsert();
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
     * Método para consulta de un producto específico
     *
     * @param idProducto identificador del producto
     * @return cursor con producto
     */
    public Cursor getProductoById(Integer idProducto) {
        return sqLiteDatabase.rawQuery("SELECT * FROM producto WHERE id = ?",
                new String[]{"" + idProducto});
    }

    /**
     * Método para eliminar de un producto específico
     *
     * @param idProducto identificador del producto
     */
    public void deleteProducto(Integer idProducto) {
        String[] argumento = new String[]{idProducto.toString()};
        sqLiteDatabase.delete("producto", "id = ?", argumento);
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
    public void updateProducto(Integer idProducto, String nombre, Double precio, String descripcion,
                               byte[] imagen) {
        String sqlSentencia = "UPDATE producto SET nombre = ?, precio = ?, descripcion = ?, " +
                "imagen = ? WHERE id = ?";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSentencia);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, nombre);
        sqLiteStatement.bindDouble(2, precio);
        sqLiteStatement.bindString(3, descripcion);
        sqLiteStatement.bindBlob(4, imagen);
        sqLiteStatement.bindString(5, idProducto.toString());
        sqLiteStatement.executeUpdateDelete();
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
     * Método para inserción de servicios
     *
     * @param nombre      nombre del servicio
     * @param descripcion descripción del servicio
     * @param imagen      imagen del servicio
     */
    public void insertServicio(String nombre, String descripcion, byte[] imagen) {
        String sqlSentencia = "INSERT INTO servicio (nombre, descripcion, imagen) VALUES" +
                " (?,?,?)";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSentencia);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, nombre);
        sqLiteStatement.bindString(2, descripcion);
        sqLiteStatement.bindBlob(3, imagen);
        sqLiteStatement.executeInsert();
    }

    /**
     * Método para consulta de todos los servicios
     *
     * @return cursor con listado de servicios
     */
    public Cursor getServicio() {
        return sqLiteDatabase.rawQuery("SELECT * FROM servicio", null);
    }

    /**
     * Método para consulta de un servicio específico
     *
     * @param idServicio identificador del servicio
     * @return cursor con servicio
     */
    public Cursor getServicioById(Integer idServicio) {
        return sqLiteDatabase.rawQuery("SELECT * FROM servicio WHERE id = ?",
                new String[]{"" + idServicio});
    }

    /**
     * Método para eliminar de un servicio específico
     *
     * @param idServicio identificador del servicio
     */
    public void deleteServicio(Integer idServicio) {
        String[] argumento = new String[]{idServicio.toString()};
        sqLiteDatabase.delete("servicio", "id = ?", argumento);
    }

    /**
     * Método para modificar de servicios
     *
     * @param idServicio identificador del servicio
     * @param nombre      nombre del servicio
     * @param descripcion descripción del servicio
     * @param imagen      imagen del servicio
     */
    public void updateServicio(Integer idServicio, String nombre, String descripcion,
                               byte[] imagen) {
        String sqlSentencia = "UPDATE servicio SET nombre = ?, descripcion = ?, imagen = ? " +
                "WHERE id = ?";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSentencia);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, nombre);
        sqLiteStatement.bindString(2, descripcion);
        sqLiteStatement.bindBlob(3, imagen);
        sqLiteStatement.bindString(4, idServicio.toString());
        sqLiteStatement.executeUpdateDelete();
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
    public void insertSucursal(String nombre, String direccion, Integer telefono, String horario,
                               Float latitud, Float longitud, byte[] imagen) {
        String sqlSentencia = "INSERT INTO sucursal (nombre, direccion, telefono, horario, imagen) " +
                "VALUES (?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSentencia);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, nombre);
        sqLiteStatement.bindString(2, direccion);
        sqLiteStatement.bindLong(3, telefono);
        sqLiteStatement.bindString(4, horario);
        sqLiteStatement.bindDouble(5, latitud);
        sqLiteStatement.bindDouble(6, longitud);
        sqLiteStatement.bindBlob(7, imagen);
        sqLiteStatement.executeInsert();
    }

    /**
     * Método para consulta de todas las sucursales
     *
     * @return cursor con listado de sucursales
     */
    public Cursor getSucursal() {
        return sqLiteDatabase.rawQuery("SELECT * FROM sucursal", null);
    }

    /**
     * Método para consulta de una sucursal específica
     *
     * @param idSucursal identificador de la sucursal
     * @return cursor con sucursal
     */
    public Cursor getSucursalById(Integer idSucursal) {
        return sqLiteDatabase.rawQuery("SELECT * FROM sucursal WHERE id = ?",
                new String[]{"" + idSucursal});
    }

    /**
     * Método para eliminar de una sucursal específica
     *
     * @param idSucursal identificador de la sucursal
     */
    public void deleteSucursal(Integer idSucursal) {
        String[] argumento = new String[]{idSucursal.toString()};
        sqLiteDatabase.delete("sucursal", "id = ?", argumento);
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
    public void updateSucursal(Integer idSucursal, String nombre, String direccion,
                               Integer telefono, String horario, Float latitud, Float longitud,
                               byte[] imagen) {
        String sqlSentencia = "UPDATE sucursal SET nombre = ?, direccion = ?, telefono = ?, " +
                "horario = ?, latitud = ?, longitud = ?, imagen = ? WHERE id = ?";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSentencia);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, nombre);
        sqLiteStatement.bindString(2, direccion);
        sqLiteStatement.bindLong(3, telefono);
        sqLiteStatement.bindString(4, horario);
        sqLiteStatement.bindDouble(5, latitud);
        sqLiteStatement.bindDouble(6, longitud);
        sqLiteStatement.bindBlob(7, imagen);
        sqLiteStatement.bindString(8, idSucursal.toString());
        sqLiteStatement.executeUpdateDelete();
    }
}



