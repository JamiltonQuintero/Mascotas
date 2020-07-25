package com.jamilton.mascotas.Mains;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;


import com.jamilton.mascotas.R;
import com.jamilton.mascotas.adapter.PageAdapter;
import com.jamilton.mascotas.fragments.MiMascota;
import com.jamilton.mascotas.fragments.ReciclerFragment;

import java.util.ArrayList;

public class MascotasMainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mascotas);


        Toolbar mitoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setTitle("Nuestras Mascotas");


       viewPager = findViewById(R.id.viePager);
       tableLayout = findViewById(R.id.tabLayout);
       setUpViewPager();



       

    if (mitoolbar != null){
        setSupportActionBar(mitoolbar);
      }

    }



    private ArrayList<Fragment>agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReciclerFragment());
        fragments.add(new MiMascota());

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
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tableLayout.getTabAt(1).setIcon(R.drawable.ic_huella);
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;

        }

       @Override
       public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.bFavoritos:
                Intent intent =new Intent(this, Favoritas.class);
                startActivity(intent);
                break;

            case R.id.mAbout:
                Intent intent1 = new Intent(this, ActivityContacto.class);
                startActivity(intent1);
                break;

            case R.id.mSettings:
                Intent intent2 = new Intent(this, ActivityAcercaDe.class);
                startActivity(intent2);
                break;

            case R.id.ConfiCuenta:
                Intent intent3 = new Intent(this, ActivityCuenta.class);
                startActivity(intent3);

            case R.id.activarNotificaciones:
                Intent intent4 = new Intent(this, Notificaciones.class);
                startActivity(intent4);
        }

        return true;
       }





}