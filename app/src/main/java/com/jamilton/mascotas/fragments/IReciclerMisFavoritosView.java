package com.jamilton.mascotas.fragments;

import com.jamilton.mascotas.adapter.ContAdapterMisFavoritas;
import com.jamilton.mascotas.pojo.Mascotas;

import java.util.ArrayList;

public interface IReciclerMisFavoritosView {

    public void generarLinearLayoutVerticalFv();

    public ContAdapterMisFavoritas crearAdaptadorFv(ArrayList<Mascotas> mascotasFv);

    public void inicializarAdaptadorRVFv(ContAdapterMisFavoritas adaptadorFv);
}
