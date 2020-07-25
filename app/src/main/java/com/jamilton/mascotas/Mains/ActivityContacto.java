package com.jamilton.mascotas.Mains;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jamilton.mascotas.R;


public class ActivityContacto extends AppCompatActivity {

    EditText etNombre,etCorreo,etMensaje;
    Button btEnviar;
    String sEmail,sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        Toolbar mitoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setTitle("Contacto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }



}