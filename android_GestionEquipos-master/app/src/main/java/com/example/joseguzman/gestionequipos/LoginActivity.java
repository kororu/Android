package com.example.joseguzman.gestionequipos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.joseguzman.gestionequipos.Data.BaseDatos;
import com.example.joseguzman.gestionequipos.Modelo.Usuario;

import static com.example.joseguzman.gestionequipos.Data.BaseDatos.losUsuarios;

public class LoginActivity extends AppCompatActivity {

    EditText etLoginUsuario;
    EditText etLoginClave;
    Button btnLoginIngresar;
    Button btnLoginCancelar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //REFERENCIAS
        etLoginUsuario = (EditText) findViewById(R.id.etLoginUsuario);
        etLoginClave = (EditText) findViewById(R.id.etLoginClave);
        btnLoginIngresar = (Button) findViewById(R.id.btnLoginIngresar);
        btnLoginCancelar = (Button) findViewById(R.id.btnLoginCancelar);


        BaseDatos.cargarDatos();


        btnLoginIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = etLoginUsuario.getText().toString();
                String clav = etLoginClave.getText().toString();
                if(us.isEmpty()){
                    etLoginUsuario.setError(getResources().getString(R.string.ErrorUsuarioVacio));
                }else if(clav.isEmpty()){
                    etLoginClave.setError(getResources().getString(R.string.ErrorClaveVacia));
                }else{
                    boolean existe = false;
                    for (Usuario u:losUsuarios
                            ) {
                        if(u.getUsuario().equals(us)){
                            existe = true;
                            if(u.getClave().equals(clav)){
                               //Ingresa
                                Intent i = new Intent(view.getContext(),SegundoActivity.class);
                                i.putExtra("usuario",u);
                                startActivity(i);
                                break;
                            }
                            //Clave no es correcta
                            etLoginClave.setError(getResources().getString(R.string.ErrorClaveIncorrecta));
                            break;
                        }
                    }
                    //Usuario no existe
                    if(!existe){
                        etLoginUsuario.setError(getResources().getString(R.string.ErrorUsuarioNoExiste));
                    }
                }
            }
        });

        btnLoginCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        etLoginUsuario.setText("");
        etLoginUsuario.requestFocus();
        etLoginClave.setText("");


    }
}
