package com.jamilton.mascotas.Mains;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.jamilton.mascotas.R;
import com.jamilton.mascotas.presentador.INotificacionesPresenter;
import com.jamilton.mascotas.presentador.NotificacionesPresenter;


public class Notificaciones extends AppCompatActivity implements INotificaciones{

    private INotificacionesPresenter iNotificacionesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        iNotificacionesPresenter = new NotificacionesPresenter(this);
        recibirToken();
    }

    @Override
    public void recibirToken() {

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if(!task.isSuccessful()){
                            Log.w("token", "getInstanceId failed" , task.getException());
                            return;
                        }

                        String token = task.getResult().getToken();
                        iNotificacionesPresenter = new NotificacionesPresenter(token);
                        Log.d("token", token);
                    }
                });
    }
}