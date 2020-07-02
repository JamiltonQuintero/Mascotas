package com.jamilton.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ActivityContacto extends AppCompatActivity {

    EditText etNombre,etCorreo,etMensaje;
    Button btEnviar;
    String sEmail,sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = findViewById(R.id.et_nombre);
        etCorreo = findViewById(R.id.et_Correo);
        etMensaje = findViewById(R.id.et_mensaje);
        btEnviar = findViewById(R.id.bt_enviar);

        Toolbar mitoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setTitle("Contacto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //credencial email

        //si quieres provar pon aqui tu email
        sEmail = "tu mail"; // e.g. ejemplo@gmail.com
        //aqui tu contraseña
        sPassword = "tu contraseña";




        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Properties properties = new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smt.host","smtp.gmail.com");
                properties.put("mail.smtp.port","587");

                //Inicializar Session
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail,sPassword);
                    }
                });


                try {
                    //Inicializar email content
                    Message message = new MimeMessage(session);
                    //Sender Email
                    message.setFrom(new InternetAddress(sEmail));
                    //Recipiente Email
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(etCorreo.getText().toString().trim()));
                    //Asunto Email
                    message.setSubject(etNombre.getText().toString().trim());
                    //Email message
                    message.setText(etMensaje.getText().toString().trim());

                    //Enviar email
                    new SendMail().execute(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });


    }



    private class SendMail extends AsyncTask<Message,String,String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ActivityContacto.this
                    ,"Por favor espera", "Enviando Correo...", true,false);

        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                //cuando no hay fallos
                Transport.send(messages[0]);
                return "Enviado";
            } catch (MessagingException e) {
                //cuando falla
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Descartar diálogo de progreso
            progressDialog.dismiss();
            if (s.equals("Enviado")) {
                //cuando es enviado

                //Inicializar alerta de dialogo
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityContacto.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Enviado</font>"));
                builder.setMessage("Correo enviado correctamente.");
                builder.setPositiveButton("OK.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        //Limpiar todo el edit text
                        etNombre.setText("");
                        etCorreo.setText("");
                        etMensaje.setText("");
                    }
                });
                //show alerta de dialogo
                builder.show();
            }else{
                //cuando falla
                Toast.makeText(getApplicationContext(),"Algo salio mal?",Toast.LENGTH_SHORT).show();

            }
        }
    }
}