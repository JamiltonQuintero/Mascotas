package com.jamilton.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContAdaptador extends RecyclerView.Adapter<ContAdaptador.ContactoViewHolder> {
    ArrayList<Mascotas>mascotas;
    Activity activity;

    public ContAdaptador (ArrayList<Mascotas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    //inflara el layout  y lo pasara al viewholder para que el obtenga cada elemento
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new ContactoViewHolder(view);
    }

    // asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewholder, int position) {

        final Mascotas mascota = mascotas.get(position);
        contactoViewholder.imgMascota.setImageResource(mascota.getImagen());
        contactoViewholder.tvnMascotas.setText(mascota.getnMascota());
        contactoViewholder.tvcanLikes.setText(mascota.getNumLikes());
        contactoViewholder.cLikes.setImageResource(mascota.getImagenHue());




        contactoViewholder.bLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getnMascota()+ " a sido agregado a tus favortitos",Toast.LENGTH_SHORT).show();
            }
        });

/*

        contactoViewholder.bFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(activity,mascota.getnMascota(),Toast.LENGTH_SHORT).show();

                Intent  inten = new Intent(activity, Favoritas.class);
                activity.startActivity(inten);
            }
        });

*/
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota, cLikes;
        private TextView tvnMascotas, tvcanLikes;
        private ImageButton bLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);


            imgMascota = itemView.findViewById(R.id.imgMascotas);
            tvnMascotas = itemView.findViewById(R.id.tvnombreMascotaCV);
            tvcanLikes = itemView.findViewById(R.id.tvcanLikesCV);
            bLike = itemView.findViewById(R.id.bLike);
            //bFavoritos = itemView.findViewById(R.id.bFavoritos);
            cLikes = itemView.findViewById(R.id.cLikes);
        }
    }

}
