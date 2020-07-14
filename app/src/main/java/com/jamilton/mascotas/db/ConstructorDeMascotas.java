package com.jamilton.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.jamilton.mascotas.R;
import com.jamilton.mascotas.pojo.Mascotas;

import java.util.ArrayList;
import java.util.Collections;

public class ConstructorDeMascotas {


    private static final int LIKE = 1;
    private Context context;
    private ArrayList<Mascotas> miMascotasFv;

    public ConstructorDeMascotas(Context context) {
        this.context = context;

    }

    public ArrayList<Mascotas> obtenerFavoritas(){


            miMascotasFv = obtenerDatos();
            return miMascotasFv;
    }


    public ArrayList<Mascotas> obtenerDatos() {

        BaseDatos baseDatos = new BaseDatos(context);
        insertarCincoMascotas(baseDatos);
        return baseDatos.obtenerTodasLasMascotas();

    }

    public void insertarCincoMascotas(BaseDatos baseDatos) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_NOMBRE, "July");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_FOTO, R.drawable.julyperfil);

        baseDatos.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_NOMBRE, "Luna");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_FOTO, R.drawable.m1);

        baseDatos.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_NOMBRE, "Chachis");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_FOTO, R.drawable.m2);

        baseDatos.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_NOMBRE, "Pepa");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_FOTO, R.drawable.m3);

        baseDatos.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_NOMBRE, "Roky");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOT_FOTO, R.drawable.m4);

        baseDatos.insertarMascotas(contentValues);

        baseDatos.close();

    }

    public void darLikeMascota(Mascotas mascotas) {
        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascotas.getId());
        contentValues.put(ConstantesBaseDeDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, mascotas.getNumLikes());
        baseDatos.insertarLikeMascota(contentValues);
    }

    public int obtenerCLikesMascotas(Mascotas mascotas){
        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikesMascota(mascotas);
    }
}