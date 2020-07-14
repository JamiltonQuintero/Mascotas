package com.jamilton.mascotas.restappi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jamilton.mascotas.restappi.ConstResApi;
import com.jamilton.mascotas.restappi.EndPointsAppi;
import com.jamilton.mascotas.restappi.deserializador.ContactoDeserializador;
import com.jamilton.mascotas.restappi.model.MascotaResponsive;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndPointsAppi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstResApi.ROOT_URL )
                //.addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        //generamos la llamada y dejamos inicializado el retrofit
        return retrofit.create(EndPointsAppi.class);
    }

    public Gson construyeGsonDeserialziador(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponsive.class, new ContactoDeserializador());

        return gsonBuilder.create();

    }
}
