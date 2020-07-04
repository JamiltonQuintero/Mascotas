package com.jamilton.mascotas.fragments;

import com.jamilton.mascotas.adapter.ContAdaptador;
import com.jamilton.mascotas.pojo.Mascotas;

import java.util.ArrayList;

public interface IReciclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContAdaptador crearAdaptador(ArrayList<Mascotas>mascotas);

    public void inicializarAdaptadorRV(ContAdaptador adaptador);
}
