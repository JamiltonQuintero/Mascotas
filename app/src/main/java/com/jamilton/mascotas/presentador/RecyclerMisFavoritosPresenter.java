package com.jamilton.mascotas.presentador;

import android.content.Context;

import com.jamilton.mascotas.db.BaseDatos;
import com.jamilton.mascotas.db.ConstructorDeMascotas;
import com.jamilton.mascotas.fragments.IReciclerMisFavoritosView;
import com.jamilton.mascotas.pojo.Mascotas;
import java.util.ArrayList;
import java.util.Collections;


public class RecyclerMisFavoritosPresenter implements IRecyclerMisFavoritasPresenter{
    private IReciclerMisFavoritosView iReciclerMisFavoritosView;
    private Context context;
    private ConstructorDeMascotas constructorDeMascotas;
    private ArrayList<Mascotas> miMascotasFv;

    public RecyclerMisFavoritosPresenter(IReciclerMisFavoritosView iReciclerMisFavoritosView,Context context) {
        this.iReciclerMisFavoritosView = iReciclerMisFavoritosView;
        this.context = context;
        obtenerMascotasDeLaBaseDeDatosFv();
    }


    @Override
    public void obtenerMascotasDeLaBaseDeDatosFv() {

        constructorDeMascotas = new ConstructorDeMascotas(context);
        miMascotasFv = constructorDeMascotas.obtenerFavoritas();
        Collections.sort(miMascotasFv);
        mostrarMascotaRVFv();


    }

    @Override
    public void mostrarMascotaRVFv() {

        iReciclerMisFavoritosView.inicializarAdaptadorRVFv(iReciclerMisFavoritosView.crearAdaptadorFv(miMascotasFv));
        iReciclerMisFavoritosView.generarLinearLayoutVerticalFv();

    }
}
