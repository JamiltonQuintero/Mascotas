
package com.jamilton.mascotas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jamilton.mascotas.db.ConstructorMiMascota;
import com.jamilton.mascotas.fragments.IReciclerMiMascotaView;
import com.jamilton.mascotas.pojo.MiMascotaM;
import com.jamilton.mascotas.restappi.EndPointsAppi;
import com.jamilton.mascotas.restappi.adapter.RestApiAdapter;
import com.jamilton.mascotas.restappi.model.MascotaResponsive;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerMiMascotasViewPresenter implements IRecyclerMiMascotasViewPresenter{

    private IReciclerMiMascotaView iReciclerMiMascotaView;
    private Context contextMM;
    private ArrayList<MiMascotaM> miMascota;
    private ConstructorMiMascota constructorMiMascota;
     ImageView imageView;
     TextView nombrePerfil;

    public RecyclerMiMascotasViewPresenter(IReciclerMiMascotaView iReciclerMiMascotaView, Context contextMM,ImageView imageView, TextView nombrePerfil) {
        this.iReciclerMiMascotaView = iReciclerMiMascotaView;
        this.contextMM = contextMM;
        this.imageView = imageView;
        this.nombrePerfil = nombrePerfil;
        //oMiMascotaBaseDeDatos();
        obtenerInformacionMedia();

    }
/*
    @Override
    public void oMiMascotaBaseDeDatos() {

        constructorMiMascota = new ConstructorMiMascota(contextMM);
        miMascota = constructorMiMascota.oDatosMM();
        mostrarMiMascota();

    }*/


    @Override
    public void obtenerInformacionMedia() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonRecent = restApiAdapter.construyeGsonDeserialziador();
        EndPointsAppi endPointsAppi = restApiAdapter.establecerConexionRestApiInstagram(gsonRecent);
        Call<MascotaResponsive> mascotaResponsive = endPointsAppi.getInformationMedia();

        mascotaResponsive.enqueue(new Callback<MascotaResponsive>() {
            @Override
            public void onResponse(Call<MascotaResponsive> call, Response<MascotaResponsive> response) {
                MascotaResponsive mascotaResponsive1 = response.body();
                miMascota = mascotaResponsive1.getMiMascotaM();
                mostrarMiMascota();
                nombrePerfil();
                imagenPerfil();
            }

            @Override
            public void onFailure(Call<MascotaResponsive> call, Throwable t) {
                Toast.makeText(contextMM, "Fallo la conexion, por favor intenta de nuevo", Toast.LENGTH_SHORT).show();
                Log.e("Fallo la conexion", t.toString());
            }
        });
    }



    @Override
    public void imagenPerfil() {
        for (MiMascotaM m: miMascota){
            MiMascotaM mascotaM;
            mascotaM = miMascota.get(3);

            Picasso.with(contextMM)
                    .load(mascotaM.getUrlImagen())
                    .into(imageView);
        }
    }

    @Override
    public void nombrePerfil() {

        for (MiMascotaM m:miMascota) {
            MiMascotaM mascotaM;
            mascotaM = miMascota.get(1);
            nombrePerfil.setText(mascotaM.getNombreCompleto());


        }
    }


    @Override
    public void mostrarMiMascota() {

        iReciclerMiMascotaView.iAdapterRV(iReciclerMiMascotaView.cAdapter(miMascota));
        iReciclerMiMascotaView.gLLayoutGrid();
    }


}
