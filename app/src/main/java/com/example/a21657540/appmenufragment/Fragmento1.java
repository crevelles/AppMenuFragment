package com.example.a21657540.appmenufragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento1 extends Fragment {

    TextView txt;

    public Fragmento1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragmento1, container, false);
        txt = (TextView)v.findViewById(R.id.idFragmento1) ;
        // Nuevos parámetros para el view del fragmento
        RelativeLayout.LayoutParams params = new 	RelativeLayout.LayoutParams(                                           	RelativeLayout.LayoutParams.MATCH_PARENT,                                               	RelativeLayout.LayoutParams.MATCH_PARENT);
        // Posicionamos el fragmento debajo del boton 	params.addRule(RelativeLayout.BELOW, R.id.btnVisualizar);
        // Añadimos un margen superior de 30 dp params.setMargins(0,30,0,0);
        v.setLayoutParams(params);
        return v;
    }

}
