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


        //Creamos las variables que reciben los datos de la Mainactivity.
        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        String lugar = i.getStringExtra("lugar");
        String fecha = i.getStringExtra("fecha");


        //Estas són las variables que contienen la fecha de la Muerte.
        int mesMuerte = (int)Math.floor(Math.random()*(12-1)+1);
        int añoMuerte = (int)Math.floor(Math.random()*(2040-2020)+2020);
        int diaMuerte = obtenerDiaMuerte(mesMuerte, añoMuerte);

        //TextView que contendra el mensaje de muerte.
        TextView tvTexto = (TextView) findViewById (R.id.tvTextoMuerte);


        //Creamos un array de String que tendra los mensajes de muerte del array de Strings.xml .
        String[] mensajesMuerte;
        mensajesMuerte = getResources().getStringArray(R.array.mensajes_muerte);
        int num = (int)Math.floor(Math.random()*(mensajesMuerte.length-0)+ 0);



        //Construimos la cadena que será el mensaje de muerte a mostrar.
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


    /**
     * Botones de Volver y Salir.
     * @param v
     */
    @Override
    public void onClick(View v){

        if (v.getId() == R.id.buttonVolver){

            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);


        }else if(v.getId() == R.id.buttonSalir) {

            finishAffinity();

        }
    }


    /**
     * Este metodo generara el dia de muerte teniendo en cuenta el año y mes que han salido al azar.
     * @param mesMuerte
     * @param añoMuerte
     * @return
     */
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
