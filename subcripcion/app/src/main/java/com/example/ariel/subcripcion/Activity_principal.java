package com.example.ariel.subcripcion;

import android.content.Intent;
import android.icu.text.IDNA;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_principal extends AppCompatActivity {
    private EditText txtRut;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtFechaN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtRut = (EditText) findViewById(R.id.txtRut);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtFechaN = (EditText) findViewById(R.id.txtFechaN);

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void clickEnviar(View v) {


        String rut = txtRut.getText().toString();
        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String fecha = txtFechaN.getText().toString();


        // SimpleDateFormat parseador=new SimpleDateFormat("dd/MM/yyyy");
        //Date nac=new Date();


        boolean valrut = false, valnombre = false, valapellido = false, valfecha = false;
        if (v.getId() == R.id.btnEnviar) {
            if (rut.isEmpty()) {
                txtRut.setError("Ingrese Rut Por Favor");
            } else {
                valrut = true;
            }
            if (nombre.isEmpty()) {
                txtNombre.setError("Ingrese Nombre Por Favor");
            } else {
                valnombre = true;
            }
            if (apellido.isEmpty()) {
                txtApellido.setError("Ingrese Apellido Por Favor");
            } else {
                valapellido = true;
            }
            if (fecha.isEmpty()) {
                txtFechaN.setError("Ingrese Edad Por Favor");
            } else {
                valfecha = true;
            }
            if (valrut && valapellido && valnombre && valfecha == true) {
                Intent i = new Intent(this, segundo_activity.class);
                i.putExtra("RUT", rut);
                i.putExtra("nombrecom", nombre + " " + apellido);
                i.putExtra("EDAD", fecha);


                if (v.getId() == R.id.btnEnviar) {
                    txtRut.setText("");
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtFechaN.setText("");
                }
                if (v.getId() == R.id.btnCancelar) {
                    txtRut.setText("");
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtFechaN.setText("");
                }
                startActivity(i);
            }
        }
    }



    public void clickCancelar(View view){
        Toast.makeText(this, "hasta Pronto",Toast.LENGTH_LONG).show();
        System.exit(0);
    }
}