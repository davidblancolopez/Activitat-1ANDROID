package com.example.david.activitat_1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private EditText fromDateEtxt;
    private DatePickerDialog fromDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Inicializamos el boton
        Button buttonEnviar = (Button) findViewById(R.id.buttonEnviar);
        //Le aplicamos un clickListener
        buttonEnviar.setOnClickListener(this);




        /* Inicializamos el EditText y pedimos el focus */
        fromDateEtxt = (EditText) findViewById(R.id.etFecha);
           /* fromDateEtxt.setInputType(InputType.TYPE_NULL);
            fromDateEtxt.requestFocus(); */
        fromDateEtxt.setFocusable(false);

            /* Ponemos el Listener al EditText */
        fromDateEtxt.setOnClickListener(this);
            /* Creamos el DatePickerDialog a partir de la fechaActual */
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, this, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            /* El constructor del DatePickerDialog accepta per paràmetres
               1. El context (o l'Activity on és llençat)
               2. L'objecte que el "vigila" i que implementa la interfície onDateSetListener
               3. Any, mes i dia del calendar que es mostren per defecte
             */
    }



    @Override
    public void onClick(View v){

        if (v.getId() == R.id.buttonEnviar){


        }
    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }
}
