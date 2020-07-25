package com.jamilton.mascotas.presentador;

import android.content.Context;
import android.util.Log;

import com.jamilton.mascotas.restappi.EndPointsAppi;
import com.jamilton.mascotas.restappi.adapter.RestApiAdapter;
import com.jamilton.mascotas.restappi.model.IdInstagram;
import com.jamilton.mascotas.restappi.model.UsuarioRespuesta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificacionesPresenter implements INotificacionesPresenter {

    private Context context;
    private String id_ig;
    private String token;

    public NotificacionesPresenter(Context context) {
        this.context = context;

    }


    public NotificacionesPresenter(String token) {
        this.token = token;
        ObtenerIdInstagram();
    }

    @Override
    public void ObtenerIdInstagram() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointsAppi endPointsAppi = restApiAdapter.conexionInstagramRecuperarId();
        final Call<IdInstagram> idInstagramCall = endPointsAppi.getIdInstagram();

        idInstagramCall.enqueue(new Callback<IdInstagram>() {
            @Override
            public void onResponse(Call<IdInstagram> call, Response<IdInstagram> response) {
                IdInstagram idInstagram = response.body();
                id_ig = idInstagram.getIg_id();
                EnviarDatos(token,id_ig);

            }

            @Override
            public void onFailure(Call<IdInstagram> call, Throwable t) {

            }
        });
    }

    @Override
    public void EnviarDatos(String iddispositivo, String ig_id) {

        Log.d("iddispositivo", iddispositivo);
        IdInstagram idInstagram = new IdInstagram();
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointsAppi endPointsAppi = restApiAdapter.establecerConexionRestAPI();
        Call<UsuarioRespuesta> usuarioRespuestaCall = endPointsAppi.registrarIdDispositivo(iddispositivo,ig_id);

        usuarioRespuestaCall.enqueue(new Callback<UsuarioRespuesta>() {
            @Override
            public void onResponse(Call<UsuarioRespuesta> call, Response<UsuarioRespuesta> response) {
                UsuarioRespuesta usuarioRespuesta = response.body();
            }

            @Override
            public void onFailure(Call<UsuarioRespuesta> call, Throwable t) {

            }
        });

    }
}
