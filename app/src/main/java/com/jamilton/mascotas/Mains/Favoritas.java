package com.jamilton.mascotas.Mains;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jamilton.mascotas.R;
import com.jamilton.mascotas.adapter.ContAdapterMisFavoritas;
import com.jamilton.mascotas.adapter.PageAdapter;
import com.jamilton.mascotas.fragments.IReciclerMisFavoritosView;
import com.jamilton.mascotas.fragments.ReciclerFavoritos;
import com.jamilton.mascotas.pojo.Mascotas;
import java.util.ArrayList;


public class Favoritas extends AppCompatActivity{

    ViewPager viewPager;
    TabLayout tableLayout;

    public Favoritas() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar mitoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setTitle("Tus Favoritas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viePager);
        tableLayout = findViewById(R.id.tabLayoutFv);
        setUpViewPager();

        if (mitoolbar != null){
            setSupportActionBar(mitoolbar);
        }

    }
    private ArrayList<Fragment>agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReciclerFavoritos());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    

}