package com.jamilton.mascotas.restappi;

import com.jamilton.mascotas.restappi.model.IdInstagram;
import com.jamilton.mascotas.restappi.model.MascotaResponsive;
import com.jamilton.mascotas.restappi.model.UsuarioRespuesta;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndPointsAppi {

    @GET(ConstResApi.URL_GET_INFORMATION_USER)
    Call<MascotaResponsive> getInformationMedia();

    @GET(ConstResApi.URL_GET_ID_INSTAGRAM)
    Call<IdInstagram> getIdInstagram();

    @FormUrlEncoded
    @POST(ConstResApi.KEY_POST_ID)
    Call<UsuarioRespuesta> registrarIdDispositivo(@Field("iddispositivo") String iddispositivo,@Field("idusuarioinstagram") String idusuarioinstagram);


}
