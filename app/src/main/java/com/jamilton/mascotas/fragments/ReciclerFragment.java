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
import com.jamilton.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.jamilton.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class ReciclerFragment extends Fragment implements IReciclerViewFragmentView{

    ArrayList<Mascotas> mascotas;
    private IRecyclerViewFragmentPresenter presenter;
    private RecyclerView lstMascotas;

    public ReciclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recicler,container,false);
        lstMascotas = view.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return view;

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lstMascotas.setLayoutManager(llm);
    }

    @Override
    public ContAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        ContAdaptador adaptador = new ContAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContAdaptador adaptador) {
        lstMascotas.setAdapter(adaptador);
    }
}