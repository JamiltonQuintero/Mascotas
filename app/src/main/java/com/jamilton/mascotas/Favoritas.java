package com.jamilton.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.jamilton.mascotas.adapter.ContAdaptador;
import com.jamilton.mascotas.pojo.Mascotas;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    ArrayList<Mascotas>mascotas;
    private RecyclerView lstMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);





        Toolbar mitoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setTitle("Tus Favoritas");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lstMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);
        ILDeMascotas();
        iniAdaptador();





    }



    //public ContAdaptador adaptador;
    public void iniAdaptador(){
        //adaptador = new ContAdaptador(mascotas, this);
        ContAdaptador adaptador = new ContAdaptador(mascotas, this);
        lstMascotas.setAdapter(adaptador);
    }

    public void ILDeMascotas(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Roky","0",R.drawable.m1,R.drawable.clikes));
        mascotas.add(new Mascotas("July","0",R.drawable.m6,R.drawable.clikes));
        mascotas.add(new Mascotas("Luna","0",R.drawable.m3,R.drawable.clikes));
    }




}