package com.example.david.activitat_1;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class segundaActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);


        //Inicializamos el boton
        Button buttonVolver = (Button) findViewById(R.id.buttonVolver);
        //Le aplicamos un clickListener
        buttonVolver.setOnClickListener(this);


        //Inicializamos el boton
        Button buttonSalir = (Button) findViewById(R.id.buttonSalir);
        //Le aplicamos un clickListener
        buttonSalir.setOnClickListener(this);



        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        String lugar = i.getStringExtra("lugar");
        String fecha = i.getStringExtra("fecha");



        int mesMuerte = (int)Math.floor(Math.random()*(12-1)+1);
        int añoMuerte = (int)Math.floor(Math.random()*(2040-2020)+2020);
        int diaMuerte = obtenerDiaMuerte(mesMuerte, añoMuerte);


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



    @Override
    public void onClick(View v){

        if (v.getId() == R.id.buttonVolver){

            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);


        }else if(v.getId() == R.id.buttonSalir) {

            finishAffinity();

        }
    }








    public int obtenerDiaMuerte(int mesMuerte, int añoMuerte){
        int dia = 0;
        if(mesMuerte == 2){
                if((añoMuerte % 4 == 0 && añoMuerte % 100 != 0) || añoMuerte % 400 == 0){
                    dia = (int)Math.floor(Math.random()*(29-1)+1);
                }else{
                    dia = (int)Math.floor(Math.random()*(28-1)+1);
                }
        }else if(mesMuerte == 4 || mesMuerte == 6 || mesMuerte == 9 || mesMuerte == 11){
            dia = (int)Math.floor(Math.random()*(30-1)+1);
        }else{
            dia = (int)Math.floor(Math.random()*(31-1)+1);
        }

        return dia;
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.segunda_activity);
    }
}
