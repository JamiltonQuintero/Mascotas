package com.jamilton.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ActivityAcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar mitoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setTitle("Acerca De");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}