package com.example.dh2.comunicacionentrefragments;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //RECIBIR EL BUNDLE
        Intent unIntent = getIntent();
        Bundle unBundle = unIntent.getExtras();

        //CARGAR EL FRAGMENT 2
        Fragment2 fragment2 = new Fragment2();

        //LE ENVIO EL BUNDLE AL FRAGMENT
        fragment2.setArguments(unBundle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contenedorDeFragment, fragment2);
        transaction.commit();
    }
}
