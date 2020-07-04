package com.jamilton.mascotas.presentador;

import android.content.Context;

import com.jamilton.mascotas.db.ConstructorDeMascotas;
import com.jamilton.mascotas.fragments.IReciclerViewFragmentView;
import com.jamilton.mascotas.pojo.Mascotas;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IReciclerViewFragmentView iReciclerViewFragmentView;
    private Context context;
    private ConstructorDeMascotas constructorDeMascotas;
    private ArrayList<Mascotas>mascotas;

    public RecyclerViewFragmentPresenter(IReciclerViewFragmentView iReciclerViewFragmentView, Context context) {
       this.iReciclerViewFragmentView = iReciclerViewFragmentView;
       this.context = context;
       obtenerContactosDeLaBaseDeDatos();
    }


    @Override
    public void obtenerContactosDeLaBaseDeDatos() {

       constructorDeMascotas = new ConstructorDeMascotas(context);
       mascotas = constructorDeMascotas.obtenerDatos();
       mostrarMascotaRV();
    }

    @Override
    public void mostrarMascotaRV() {
        iReciclerViewFragmentView.inicializarAdaptadorRV(iReciclerViewFragmentView.crearAdaptador(mascotas));
        iReciclerViewFragmentView.generarLinearLayoutVertical();
    }


}
