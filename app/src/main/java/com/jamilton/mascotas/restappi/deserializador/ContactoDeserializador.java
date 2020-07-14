package com.jamilton.mascotas.restappi.deserializador;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.jamilton.mascotas.pojo.MiMascotaM;
import com.jamilton.mascotas.restappi.JsonKeys;
import com.jamilton.mascotas.restappi.model.MascotaResponsive;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactoDeserializador implements JsonDeserializer<MascotaResponsive> {
    @Override
    public MascotaResponsive deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponsive mascotaResponsive = gson.fromJson(json,MascotaResponsive.class);
        JsonArray mascotaResponsiveData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSIVE_ARRAY);
        mascotaResponsive.setMiMascotaM(deserializarMascotaDeJson(mascotaResponsiveData));



        return mascotaResponsive;
/*
        // de esta manera podriamos acceder a un objeto dentro del json
       // JsonObject userJson = mascotaResponsiveData.getAsJsonObject(JsonKeys.aqui pondriamos el key a acceder)
               String id = mascotaResponsiveData.get(Integer.parseInt(JsonKeys.USER_ID)).getAsString();
*/


    }

    public ArrayList<MiMascotaM> deserializarMascotaDeJson(JsonArray mascotaResponsiveData){
        ArrayList<MiMascotaM> miMascotaM = new ArrayList<>();
        for (int i = 0; i < mascotaResponsiveData.size(); i++){
            JsonObject mascotaResponsiveDataObjet = mascotaResponsiveData.get(i).getAsJsonObject();

            String id = mascotaResponsiveDataObjet.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto = mascotaResponsiveDataObjet.get(JsonKeys.USER).getAsString();
            String urlImagen = mascotaResponsiveDataObjet.get(JsonKeys.MEDIA_URL).getAsString();
            String fecha = mascotaResponsiveDataObjet.get(JsonKeys.MEDIA_FECHA).getAsString();

            MiMascotaM mascotaActual = new MiMascotaM();
            mascotaActual.setIdM(id);
            mascotaActual.setNombreCompleto(nombreCompleto);
            mascotaActual.setUrlImagen(urlImagen);
            mascotaActual.setFecha(fecha);

            miMascotaM.add(mascotaActual);
            }
        return miMascotaM;
        }

    }

