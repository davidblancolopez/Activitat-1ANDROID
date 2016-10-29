package com.example.david.activitat_1;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class segundaActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);

        int diaMuerte = (int)Math.floor(Math.random()*(30-1)+1);
        int mesMuerte = (int)Math.floor(Math.random()*(12-1)+1);
        int añoMuerte = (int)Math.floor(Math.random()*(2020-2010)+2010);


        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        String lugar = i.getStringExtra("lugar");
        String fecha = i.getStringExtra("fecha");


        TextView tvTexto = (TextView) findViewById (R.id.tvTextoMuerte);



        String[] mensajesMuerte;
        mensajesMuerte = getResources().getStringArray(R.array.mensajes_muerte);
        int num = (int)Math.floor(Math.random()*(mensajesMuerte.length-0)+ 0);


        StringBuilder cadena = new StringBuilder();
        cadena.append(nombre);
        cadena.append(" ");
        cadena.append("nacido el ");
        cadena.append(fecha);
        cadena.append(" en ");
        cadena.append(lugar);
        cadena.append(" nos dejó el ");
        cadena.append(diaMuerte + " del ");
        cadena.append(mesMuerte + " de ");
        cadena.append(añoMuerte + " ");
        cadena.append(mensajesMuerte[num]);
        String cadenaFinal = cadena.toString();
        tvTexto.setText(cadenaFinal);
    }

}
