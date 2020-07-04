package com.jamilton.mascotas.presentador;

import android.content.Context;

import com.jamilton.mascotas.db.ConstructorMiMascota;
import com.jamilton.mascotas.fragments.IReciclerMiMascotaView;
import com.jamilton.mascotas.pojo.MiMascotaM;

import java.util.ArrayList;

public class RecyclerMiMascotasViewPresenter implements IRecyclerMiMascotasViewPresenter{

    private IReciclerMiMascotaView iReciclerMiMascotaView;
    private Context contextMM;
    private ArrayList<MiMascotaM> miMascota;
    private ConstructorMiMascota constructorMiMascota;

    public RecyclerMiMascotasViewPresenter(IReciclerMiMascotaView iReciclerMiMascotaView, Context contextMM) {
        this.iReciclerMiMascotaView = iReciclerMiMascotaView;
        this.contextMM = contextMM;
        oMiMascotaBaseDeDatos();

    }

    @Override
    public void oMiMascotaBaseDeDatos() {

        constructorMiMascota = new ConstructorMiMascota(contextMM);
        miMascota = constructorMiMascota.oDatosMM();
        mostrarMiMascota();

    }

    @Override
    public void mostrarMiMascota() {

        iReciclerMiMascotaView.iAdapterRV(iReciclerMiMascotaView.cAdapter(miMascota));
        iReciclerMiMascotaView.gLLayoutGrid();
    }
}
