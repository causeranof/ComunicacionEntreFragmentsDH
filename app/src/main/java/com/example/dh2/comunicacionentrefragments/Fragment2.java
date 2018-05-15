package com.example.dh2.comunicacionentrefragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

//PASO 1
public class Fragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // INFLO LA VISTA DEL LAYOUT
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        // RECIBO EL BUNDLE
        Bundle bundle = getArguments();

        // CARGO EL TEXTVIEW CON EL MESAJE
        TextView textView = (TextView) view.findViewById(R.id.textViewFragment2);
        String mensaje = bundle.getString("mensaje");
        textView.setText(mensaje);

        //DEVUELO LA VISTA
        return view;
    }
}
