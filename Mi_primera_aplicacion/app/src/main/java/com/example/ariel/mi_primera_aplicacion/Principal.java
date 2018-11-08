package com.example.ariel.mi_primera_aplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    private EditText etNombre, etUsuario, etCorreo, etFecha, etPass;
    private TextView tvTitulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Tag_","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //referencia a los widget

        etNombre = (EditText) findViewById(R.id.txtNombre);
        etUsuario = (EditText) findViewById(R.id.txtUsuario);
        etCorreo = (EditText) findViewById(R.id.txtCorreo);
        etFecha = (EditText) findViewById(R.id.txtFecha);
        etPass = (EditText) findViewById(R.id.txtPass);
    }

    public void clickBoton(View v) {

        String nombre = etNombre.getText().toString();
        String usuario = etUsuario.getText().toString();
        String correo = etCorreo.getText().toString();
        String fecha = etFecha.getText().toString();
        String pass = etPass.getText().toString();
        boolean passUpper = false;
        boolean passLower = false;
        boolean passNumber = false;


        if (!nombre.isEmpty()) {


        } else {
            etNombre.setError("Campo obligatorio");

        }
        if (!usuario.isEmpty()) {
        } else {
            etUsuario.setError("Campo obligatorio");
        }
        if (!correo.isEmpty()) {
        } else {
            etCorreo.setError("Campo obligatorio");
        }
        if (!fecha.isEmpty()) {

        } else {
            etFecha.setError("Campo obligatorio");
        }


                if (pass.length() >= 6) {
            for (int i = 0; i < pass.length(); i++) {
                if (Character.isUpperCase(pass.charAt(i))) {
                    passUpper = true;
                }
                ;
                if (Character.isLowerCase(pass.charAt(i))) {

                    passLower = true;
                }
                if (Character.isDigit(pass.charAt(i))) {
                    passNumber = true;

                }
            }
            if (passUpper && passLower && passNumber) {
                Toast.makeText(getApplicationContext(), "datos ingresados correctamente", Toast.LENGTH_SHORT).show();
                etNombre.setText("");
                etUsuario.setText("");
                etFecha.setText("");
                etCorreo.setText("");
                etPass.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "la contraseña debe tener al menos 1 mayuscula, 1 minuscula y 1 numero", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(getApplicationContext(), "la contraseña debe tener almenos 6 digitos", Toast.LENGTH_SHORT).show();
        }
    }
}