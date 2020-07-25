
package com.jamilton.mascotas.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jamilton.mascotas.R;
import com.jamilton.mascotas.adapter.ContAdapterMisFavoritas;
import com.jamilton.mascotas.pojo.Mascotas;
import com.jamilton.mascotas.presentador.IRecyclerMiMascotasViewPresenter;
import com.jamilton.mascotas.presentador.IRecyclerMisFavoritasPresenter;
import com.jamilton.mascotas.presentador.RecyclerMiMascotasViewPresenter;
import com.jamilton.mascotas.presentador.RecyclerMisFavoritosPresenter;


import java.util.ArrayList;

public class ReciclerFavoritos extends Fragment implements IReciclerMisFavoritosView {

 ArrayList<Mascotas>mascotas;
 private RecyclerView lstMascotas;
 private IRecyclerMisFavoritasPresenter presenter;


 public ReciclerFavoritos() {

 }

 @Nullable
 @Override
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
  View view = inflater.inflate(R.layout.fragment_favoritas,container,false);
  lstMascotas = view.findViewById(R.id.rvMascotasFv);
  presenter = new RecyclerMisFavoritosPresenter(this,getContext());

  return view;
 }

 @Override
 public void generarLinearLayoutVerticalFv() {
  LinearLayoutManager llm = new LinearLayoutManager(getActivity());
  llm.setOrientation(LinearLayoutManager.VERTICAL);
  lstMascotas.setLayoutManager(llm);

 }

 @Override
 public ContAdapterMisFavoritas crearAdaptadorFv(ArrayList<Mascotas> mascotasFv) {
  ContAdapterMisFavoritas adaptador = new ContAdapterMisFavoritas(mascotasFv, getActivity());

  return adaptador;
 }

 @Override
 public void inicializarAdaptadorRVFv(ContAdapterMisFavoritas adaptador) {
  lstMascotas.setAdapter(adaptador);
 }
}
