package com.jamilton.mascotas.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jamilton.mascotas.R;
import com.jamilton.mascotas.adapter.ContAdaptador;
import com.jamilton.mascotas.adapter.ContAdapterMiMascota;
import com.jamilton.mascotas.pojo.Mascotas;
import com.jamilton.mascotas.pojo.MiMascotaM;

import java.util.ArrayList;


public class MiMascota extends Fragment {

        ArrayList<MiMascotaM> miMascota;
        private RecyclerView lstmiMascotas;

    public MiMascota() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_mi_mascota,container,false);

            lstmiMascotas = view.findViewById(R.id.rvMiMascotas);

            GridLayoutManager llm = new GridLayoutManager(getActivity(),2);
            llm.setOrientation(GridLayoutManager.VERTICAL);
            lstmiMascotas.setLayoutManager(llm);
            ILDeMascotas();
            iniAdaptador();

            return view;
        }
        //public ContAdaptador adaptador;
        public void iniAdaptador(){
            //adaptador = new ContAdaptador(mascotas, this);
            ContAdapterMiMascota contAdapterMiMascota = new ContAdapterMiMascota(miMascota,getActivity());
            lstmiMascotas.setAdapter(contAdapterMiMascota);
        }

        public void ILDeMascotas(){
            miMascota = new ArrayList<>();


            miMascota.add(new MiMascotaM("0",R.drawable.july1,R.drawable.clikes));
            miMascota.add(new MiMascotaM("0",R.drawable.july2,R.drawable.clikes));
            miMascota.add(new MiMascotaM("0",R.drawable.july3,R.drawable.clikes));
            miMascota.add(new MiMascotaM("0",R.drawable.july4,R.drawable.clikes));
            miMascota.add(new MiMascotaM("0",R.drawable.july5,R.drawable.clikes));
            miMascota.add(new MiMascotaM("0",R.drawable.july6,R.drawable.clikes));


        }
    }
