package com.example.david.activitat_1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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




                /*SPINNER*/


        Spinner spinner = (Spinner) findViewById(R.id.sexo_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sexo_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }



    @Override
    public void onClick(View v){

        if (v.getId() == R.id.buttonEnviar){


        }else if(v == fromDateEtxt) {
            fromDatePickerDialog.show();

        }
    }






    

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        Calendar newDate = Calendar.getInstance();
        newDate.set(year, month, dayOfMonth);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));

    }
}
