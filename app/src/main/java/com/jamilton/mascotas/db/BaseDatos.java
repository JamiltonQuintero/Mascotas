package com.jamilton.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.jamilton.mascotas.pojo.Mascotas;

import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDeDatos.DATABASE_NAME, null, ConstantesBaseDeDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDeDatos.TABLE_MASCOT + "(" +
                ConstantesBaseDeDatos.TABLE_MASCOT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDeDatos.TABLE_MASCOT_NOMBRE + " TEXT, " +
                ConstantesBaseDeDatos.TABLE_MASCOT_FOTO + " INTEGER " +
                ")";

        String queryCrearTablaLikesMascotas = "CREATE TABLE " + ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS + "(" +
                ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + ")" +
                "REFERENCES " + ConstantesBaseDeDatos.TABLE_MASCOT + "(" + ConstantesBaseDeDatos.TABLE_MASCOT_ID + ")" +
                ")";

        sqLiteDatabase.execSQL(queryCrearTablaMascotas);
        sqLiteDatabase.execSQL(queryCrearTablaLikesMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDeDatos.TABLE_MASCOT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascotas> obtenerTodasLasMascotas() {
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        //consultar lo que hay en la abse de datos
        String query = "SELECT * FROM " + ConstantesBaseDeDatos.TABLE_MASCOT;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setnMascota(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+") as likes" +
                                " FROM " + ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS +
                                " WHERE " + ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = sqLiteDatabase.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setNumLikes(registrosLikes.getInt(0));

            }else {
                mascotaActual.setNumLikes(0);
            }


            mascotas.add(mascotaActual);


        }
        sqLiteDatabase.close();

        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(ConstantesBaseDeDatos.TABLE_MASCOT, null, contentValues);
        database.close();

    }

    public void insertarLikeMascota(ContentValues contentValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS,null, contentValues);
        database.close();
    }
    public  int obtenerLikesMascota(Mascotas mascotas){
        int likes = 0;

        String query = "SELECT COUNT ("+ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+")" +
                " FROM " + ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS +
                " WHERE " + ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "=" +mascotas.getId();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor registros = database.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
            database.close();
        }

        return likes;
    }
}
