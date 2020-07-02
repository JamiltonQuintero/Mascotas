package com.jamilton.mascotas.fragments;

import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jamilton.mascotas.R;
import com.jamilton.mascotas.adapter.ContAdaptador;
import com.jamilton.mascotas.pojo.Mascotas;

import java.util.ArrayList;

public class ReciclerFragment extends Fragment {

    ArrayList<Mascotas> mascotas;
    private RecyclerView lstMascotas;

    public ReciclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recicler,container,false);

        lstMascotas = view.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lstMascotas.setLayoutManager(llm);
        ILDeMascotas();
        iniAdaptador();

        return view;
    }
    //public ContAdaptador adaptador;
    public void iniAdaptador(){
        //adaptador = new ContAdaptador(mascotas, this);
        ContAdaptador adaptador = new ContAdaptador(mascotas,getActivity());
        lstMascotas.setAdapter(adaptador);
    }

    public void ILDeMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascotas("Roky","0",R.drawable.m1,R.drawable.clikes));
        mascotas.add(new Mascotas("July","0",R.drawable.m6,R.drawable.clikes));
        mascotas.add(new Mascotas("Luna","0",R.drawable.m3,R.drawable.clikes));
        mascotas.add(new Mascotas("Chachis","0",R.drawable.m4,R.drawable.clikes));
        mascotas.add(new Mascotas("Pepa","0",R.drawable.m5,R.drawable.clikes));
    }
}