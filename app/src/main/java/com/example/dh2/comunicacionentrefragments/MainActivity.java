package com.example.dh2.comunicacionentrefragments;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

// IMPLEMENTO EL NOTIFICADORAACTIVITIES QUE ES UNA CLASE INTERNA DE FRAGMENT1 PARA PODER ESTABLECER COMUNICACION ENTRE FRAGMENT Y ACTIVITY DE MANERA QUE EL FRAGMENT SEA REUTILIZABLE
public class MainActivity extends AppCompatActivity implements Fragment1.NotificadorAActivities {

    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CARGAR EL FRAGMENT 1

        //CREO UNA INSTANCIA DEL FRAGMENT 1 (PASO 2.2)
        Fragment1 fragment1 = new Fragment1();

        //PIDO UN FRAGMENT MANAGER (PASO 2.3)
        FragmentManager manager = getSupportFragmentManager();

        //PIDO UNA TRANSACCION AL FRAGMENT MANAGER (PASO 2.3)
        FragmentTransaction transaction = manager.beginTransaction();

        //LE PIDO A LA TRANSACCION QUE AGREGUE EL FRAGMENT AL CONTENEDOR (PASO 2.4)
        transaction.add(R.id.contenedorDeFragmentMainActivity, fragment1);

        //CONFIRMO LA TRANSACCIÓN (PASO 2.5)
        transaction.commit();
    }


    //PASO 3.3
    //  LA ACTIVITY TIENE QUE SOBREESCRIBIR ESTE METODO PORQUE IMPLEMENTA
    // LA INTERFAZ NOTIFICADORDEACTIVITY
    // ESTE METODO ES EL QUE VA A RECIBIR EL MENSAJE QUE LE ENVIE EL FRAGMENT.
    public void recibirMensaje(String mensaje){

        //IR A LA SECOND ACTIVITY Y ENVIARLE EL MENSAJE
        Intent unIntent = new Intent(this, Activity2.class);

        //CARGO EL BUNDLE PARA ENVIAR AL ACTIVITY
        Bundle unBundle = new Bundle();
        unBundle.putString("mensaje", mensaje);

        //ASOCIO EL BUNDLE AL INTENT
        unIntent.putExtras(unBundle);

        //COMIENZO LA ACTIVIDAD
        startActivity(unIntent);
    }

}
