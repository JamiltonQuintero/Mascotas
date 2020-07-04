package com.jamilton.mascotas.db;

import android.content.Context;

import com.jamilton.mascotas.R;
import com.jamilton.mascotas.fragments.MiMascota;
import com.jamilton.mascotas.pojo.MiMascotaM;

import java.util.ArrayList;

public class ConstructorMiMascota {

    private Context contextMM;

    public ConstructorMiMascota(Context contextMM) {
        this.contextMM = contextMM;
    }

    public ArrayList<MiMascotaM> oDatosMM(){

        ArrayList<MiMascotaM>miMascota = new ArrayList<>();

        miMascota.add(new MiMascotaM(20, R.drawable.july1,R.drawable.clikes));
        miMascota.add(new MiMascotaM(8,R.drawable.july2,R.drawable.clikes));
        miMascota.add(new MiMascotaM(12,R.drawable.july3,R.drawable.clikes));
        miMascota.add(new MiMascotaM(5,R.drawable.july4,R.drawable.clikes));
        miMascota.add(new MiMascotaM(15,R.drawable.july5,R.drawable.clikes));
        miMascota.add(new MiMascotaM(18,R.drawable.july6,R.drawable.clikes));
        miMascota.add(new MiMascotaM(20, R.drawable.july1,R.drawable.clikes));
        miMascota.add(new MiMascotaM(8,R.drawable.july2,R.drawable.clikes));
        miMascota.add(new MiMascotaM(12,R.drawable.july3,R.drawable.clikes));
        miMascota.add(new MiMascotaM(5,R.drawable.july4,R.drawable.clikes));
        miMascota.add(new MiMascotaM(15,R.drawable.july5,R.drawable.clikes));
        miMascota.add(new MiMascotaM(18,R.drawable.july6,R.drawable.clikes));


        return miMascota;
    }

}


