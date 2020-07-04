package com.jamilton.mascotas.fragments;

import com.jamilton.mascotas.adapter.ContAdapterMiMascota;
import com.jamilton.mascotas.pojo.MiMascotaM;

import java.util.ArrayList;

public interface IReciclerMiMascotaView {

     public void gLLayoutGrid();

     public ContAdapterMiMascota cAdapter(ArrayList<MiMascotaM> miMascotas);

     public void iAdapterRV(ContAdapterMiMascota adapterMiMascota);


}
