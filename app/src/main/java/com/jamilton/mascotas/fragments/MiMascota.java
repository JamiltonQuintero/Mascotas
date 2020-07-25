
package com.jamilton.mascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.jamilton.mascotas.R;
import com.jamilton.mascotas.adapter.ContAdapterMiMascota;
import com.jamilton.mascotas.pojo.MiMascotaM;
import com.jamilton.mascotas.presentador.IRecyclerMiMascotasViewPresenter;
import com.jamilton.mascotas.presentador.RecyclerMiMascotasViewPresenter;
import com.jamilton.mascotas.restappi.deserializador.ContactoDeserializador;
import com.jamilton.mascotas.restappi.model.MascotaResponsive;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class
MiMascota extends Fragment implements IReciclerMiMascotaView {

        ArrayList<MiMascotaM> miMascota;
        private RecyclerView lstmiMascotas;
        private IRecyclerMiMascotasViewPresenter presenterMM;
        private ImageView imageView;
        private TextView nombrePerfil;

    public MiMascota() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_mi_mascota,container,false);

            imageView     = view.findViewById(R.id.miPerfil);
            nombrePerfil  = view.findViewById(R.id.usernameMii);
            lstmiMascotas = view.findViewById(R.id.rvMiMascotas);
            presenterMM   = new RecyclerMiMascotasViewPresenter(this,getContext(),imageView,nombrePerfil);


            return view;

        }

    @Override
    public void gLLayoutGrid() {
        GridLayoutManager llm = new GridLayoutManager(getActivity(),2);
        llm.setOrientation(GridLayoutManager.VERTICAL);
        lstmiMascotas.setLayoutManager(llm);

    }

    @Override
    public ContAdapterMiMascota cAdapter(ArrayList<MiMascotaM> miMascotass) {
        ContAdapterMiMascota contAdapterMiMascota = new ContAdapterMiMascota(miMascotass,getActivity());
        return contAdapterMiMascota;
    }

    @Override
    public void iAdapterRV(ContAdapterMiMascota adapterMiMascota) {

        lstmiMascotas.setAdapter(adapterMiMascota);

     }



  }
