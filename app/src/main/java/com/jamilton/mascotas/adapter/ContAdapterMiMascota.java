package com.jamilton.mascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.jamilton.mascotas.R;
import com.jamilton.mascotas.pojo.MiMascotaM;
import java.util.ArrayList;

public class ContAdapterMiMascota extends RecyclerView.Adapter<ContAdapterMiMascota.ContactoViewHolderMM> {

    ArrayList<MiMascotaM>miMascota;
    Activity activityM;

    public ContAdapterMiMascota(ArrayList<MiMascotaM> miMascota, FragmentActivity activityM) {
        this.miMascota = miMascota;
        this.activityM = activityM;
    }

    @NonNull
    @Override
    public ContactoViewHolderMM onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mimascota,parent,false);
        return new ContactoViewHolderMM(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolderMM holder, int position) {
        final MiMascotaM mimascota = miMascota.get(position);
        holder.imgMiMascota.setImageResource(mimascota.getImagen());
        holder.cLikesMM.setImageResource(mimascota.getImagenHue());
        holder.tvcanLikesMM.setText(String.valueOf(mimascota.tNumLikes()));

    }

    @Override
    public int getItemCount() {
        return miMascota.size();
    }

    public static class ContactoViewHolderMM extends RecyclerView.ViewHolder {
        private ImageView imgMiMascota, cLikesMM;
        private TextView  tvcanLikesMM;


        public ContactoViewHolderMM(@NonNull View itemView) {
            super(itemView);

            imgMiMascota = itemView.findViewById(R.id.imgMiMascotas);
            cLikesMM     = itemView.findViewById(R.id.cLikesMM);
            tvcanLikesMM = itemView.findViewById(R.id.tvcanLikesCVMM);

        }
    }
}
