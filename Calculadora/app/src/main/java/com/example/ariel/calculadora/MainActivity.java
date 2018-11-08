package com.example.ariel.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
n    import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edPrimerNumero, edSegundoNumero;
    Switch swGuardar;
    RadioButton rbSuma, rbResta, rbDiv, rbPot, rbMulti;
    ListView lsResultados;
    Button btCalcular;
    TextView tvResultado;
    List<String> log = new ArrayList<String>();
    ListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPrimerNumero=(EditText) findViewById(R.id.edPrimerNumero);
        edSegundoNumero=(EditText) findViewById(R.id.edSegundoNumero);
        swGuardar=(Switch) findViewById(R.id.swGuardar);
        rbSuma=(RadioButton) findViewById(R.id.rbSuma);
        rbResta=(RadioButton) findViewById(R.id.rbResta);
        rbDiv=(RadioButton) findViewById(R.id.rbDiv);
        rbPot=(RadioButton) findViewById(R.id.rbPot);
        rbMulti=(RadioButton) findViewById(R.id.rbMulti);





    }
}
