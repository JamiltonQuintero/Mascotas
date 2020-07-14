package com.jamilton.mascotas.restappi;

import com.jamilton.mascotas.restappi.model.MascotaResponsive;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointsAppi {

    @GET(ConstResApi.URL_GET_INFORMATION_USER)
    Call<MascotaResponsive> getInformationMedia();


}
