package com.example.dh2.comunicacionentrefragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */

// PASO 1
public class Fragment1 extends Fragment {

    private NotificadorAActivities notificador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        Button button = (Button) view.findViewById(R.id.buttonFragment1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //BUSCAR EL EDIT TEXT Y GUARDAR EL TEXTO QUE QUIERO ENVIAR
                EditText editText = (EditText) view.findViewById(R.id.editTextFragment1);

                //GUARDO EN UNA VARIABLE EL MENSAJE
                String mensaje = editText.getText().toString();

                //ENVIARLE EL MENSAJE AL ACTIVITY
                notificador.recibirMensaje(mensaje);
            }
        });

        return view;
    }

    //PASO 3.2
    //ESTE MÉTODO ME PERMITE CONOCER QUIEN ES LA ACTIVITY QUE ESTA USANDO EL FRAGMENT.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.notificador = (NotificadorAActivities) context;
    }

    // ESTA INTERFAZ SE CREA PARA PODER COMUNICAR AL FRAGMENT CON EL ACTIVITY QUE LO ESTE USANDO.
    // CON ESTA INTERFAZ, EL FRAGMENT PUEDE SER REUTILIZADO EN CUALQUIER ACTIVITY.
    // EL ACTIVITY QUE USE ESTE FRAGMENT DEBERA IMPLEMENTAR ESTA INTERFAZ.
    // PASO 3.1
    public interface NotificadorAActivities{

        //ESTE METODO ES EL QUE PERMITIRÁ ENVIARLE EL MENSAJE AL ACTIVITY.
        public void recibirMensaje(String mensaje);
    }
}
