package com.jamilton.mascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jamilton.mascotas.R;
import com.jamilton.mascotas.pojo.Mascotas;

import java.util.ArrayList;

public class ContAdapterMisFavoritas extends RecyclerView.Adapter<ContAdapterMisFavoritas.contactoViewHolderFv>{

   ArrayList<Mascotas>mascotasFv;
   Activity activityFv;
 public ContAdapterMisFavoritas(ArrayList<Mascotas> mascotasFv, Activity activityFv) {
    this.mascotasFv = mascotasFv;
    this.activityFv = activityFv;

 }



 @NonNull
 @Override
 public contactoViewHolderFv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_favoritas,parent,false);
  return new contactoViewHolderFv(view);

 }

 @Override
 public void onBindViewHolder(@NonNull contactoViewHolderFv holder, int position) {

     final Mascotas miMascotaFv = mascotasFv.get(position);
     holder.imgMascotafv.setImageResource(miMascotaFv.getImagen());
     holder.tvcanLikeFv.setText(String.valueOf(miMascotaFv.getNumLikes())+ " Likes");
     //holder.tvnMascotas.setText(miMascotaFv.getnMascota());
     holder.cLikesFv.setImageResource(miMascotaFv.getImagenHue());

 }

 @Override
 public int getItemCount() {
  return mascotasFv.size();
 }

 public static class contactoViewHolderFv extends RecyclerView.ViewHolder{
   private ImageView imgMascotafv, cLikesFv;
   private TextView tvcanLikeFv, tvnMascotas;

   public contactoViewHolderFv(@NonNull View itemView) {
    super(itemView);

    imgMascotafv = itemView.findViewById(R.id.imgMascotasFv);
    tvcanLikeFv  = itemView.findViewById(R.id.tvcanLikesCVFv);
    cLikesFv     = itemView.findViewById(R.id.cLikesFv);
    //tvnMascotas  = itemView.findViewById(R.id.tvnombreMascotaCVFv);

   }
  }
}
