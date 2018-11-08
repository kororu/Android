package com.example.ariel.equipos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.ariel.equipos.BaseDatos.losUsuarios;

public class Login_activity extends AppCompatActivity {

    EditText etLoginUsuario;
    EditText etLoginClave;
    Button btnLoginIngresar;
    Button btnLoginCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        etLoginUsuario=(EditText) findViewById(R.id.etLoginUsuario);
        etLoginClave=(EditText)findViewById(R.id.etLoginClave);
        btnLoginIngresar=(Button)findViewById(R.id.btnLoginIngresar);
        btnLoginCancelar=(Button)findViewById(R.id.btnLoginCancelar);

        BaseDatos.cargaDatos();

        btnLoginIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = etLoginUsuario.getText().toString();
                String clav = etLoginClave.getText().toString();
                if(us.isEmpty()){
                    etLoginUsuario.setError(getResources().getString(R.string.ErrorUsuarioVacio));
                }else if (clav.isEmpty()) {
                    etLoginClave.setError(getResources().getString(R.string.ErrorClaveVacia));
                    }else{
                    boolean existe=false;
                    for (Usuario u: losUsuarios){
                        if(u.getUsuario().equals((us))){
                            existe=true;
                            if(u.getClave().equals(clav)){
                                Intent i = new Intent(view.getContext(),segundo_activity.class);
                                i.putExtra("usuario", u);
                                startActivity(i);
                                break;
                            }
                            etLoginClave.setError(getResources().getString(R.string.ErrorClaveIncorrecta));
                            break;
                        }
                    }
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
    protected void onResume(){
        super.onResume();
        etLoginUsuario.setText("");
        etLoginClave.requestFocus();
        etLoginClave.setText("");
    }
}
