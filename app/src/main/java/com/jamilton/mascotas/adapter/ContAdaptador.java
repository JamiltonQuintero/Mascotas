package com.jamilton.mascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.jamilton.mascotas.db.ConstructorDeMascotas;
import com.jamilton.mascotas.pojo.Mascotas;
import com.jamilton.mascotas.R;

import java.util.ArrayList;



public class ContAdaptador extends RecyclerView.Adapter<ContAdaptador.ContactoViewHolder> {
    ArrayList<Mascotas> mascotas;
    Activity activity;

    public ContAdaptador(ArrayList<Mascotas> mascotas, FragmentActivity activity) {
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
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewholder, int position) {

        final Mascotas mascota = mascotas.get(position);
        contactoViewholder.imgMascota.setImageResource(mascota.getImagen());
        contactoViewholder.tvnMascotas.setText(mascota.getnMascota());
        contactoViewholder.tvcanLikes.setText(String.valueOf(mascota.getNumLikes())+" Likes");
        contactoViewholder.cLikes.setImageResource(mascota.getImagenHue());



        contactoViewholder.bLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, " Diste Like a "+ mascota.getnMascota(), Toast.LENGTH_SHORT).show();

                ConstructorDeMascotas constructorDeMascotas = new ConstructorDeMascotas(activity);
                constructorDeMascotas.darLikeMascota(mascota);

                contactoViewholder.tvcanLikes.setText(String.valueOf(constructorDeMascotas.obtenerCLikesMascotas(mascota))+" Likes");


            }
        });


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
            cLikes = itemView.findViewById(R.id.cLikes);
        }
    }

}

