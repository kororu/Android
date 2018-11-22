package com.example.nyarlathotep.agenda_tareas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.nyarlathotep.agenda_tareas.Modelo.Usuario;
import static com.example.nyarlathotep.agenda_tareas.Modelo.Usuario.LosUsuarios;

public class LoginActivity extends AppCompatActivity {
    EditText etUsuario;
    EditText etPass;
    Switch swRecordar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //declara los datos
        etUsuario =(EditText)findViewById(R.id.etUsuario);
        etPass=(EditText)findViewById(R.id.etPass);
        swRecordar=(Switch) findViewById(R.id.swRecordar);

        Usuario.cargadatos(); //carga los usuarios en la clase usuario
        cargarUsuario(); // activa el metodo carga usuario


        }
    public void cargarUsuario(){//crea el metodo para cargar los datos guardados en las persistencia
        SharedPreferences preferencias = getSharedPreferences("usuarioypass", Context.MODE_PRIVATE);
        etUsuario.setText(preferencias.getString("usuario",""));
        etPass.setText(preferencias.getString("clave",""));
    }


        public void clickButton(View v){
        if(v.getId()==R.id.btAceptar){//identifica el boton y lo declara

            String us = etUsuario.getText().toString(); //obtiene los datos ingresados(usuario) y los guarda en la variable us
            String pass=etPass.getText().toString(); //obtiene los datos ingresados en la contraseña y los guarda en la variable pass
            if(us.isEmpty()){//pregunta si las variables estan vacias y manda los errores correspondientes
                etUsuario.setError(getResources().getString(R.string.ErrorUsuarioVacio));
            }else if(pass.isEmpty()){
                etPass.setError(getResources().getString(R.string.ErrorClaveVacia));
            }else{//si contienen  datos pasan a las validaciones
                boolean existe = false; //declara un boleano para validar la existencia del usuario
                for (Usuario u:LosUsuarios){//carga los datos en la variabe u en el for de losUsuario y recorre el arrays
                    if(u.getUsuario().equals(us)){//compara si el usuario dentro de u es igual al usuario guardado en us
                        existe=true; //si es igual lo marca como existente

                        if(u.getClave().equals(pass)){//compara la clave que obtiene de u con la que tiene guardada e pass
                            Toast toast= null;
                                if(swRecordar.isChecked()){//verifica si el switch recordar esta activado
                                SharedPreferences preferencias = getSharedPreferences("usuarioypass", Context.MODE_PRIVATE); //crea el archivo y lo guarda en modo privado
                                SharedPreferences.Editor editarPreferencias = preferencias.edit();//permite editar el archivo
                                editarPreferencias.putString("usuario", us);//guarda con la id usuario lo que tiene la variable us
                                editarPreferencias.putString("clave", pass); // guarda con la ide clave lo que tiene en la variable pass
                                editarPreferencias.commit();//guarda lo que obtuvo
                                     toast= Toast.makeText(getBaseContext(), "se guardo correctamente",Toast.LENGTH_LONG);


                                }else{// si el boton no esta chequeado borra el contenido del documeto usuaruoypass
                                    SharedPreferences preferencias = getSharedPreferences("usuarioypass", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editarPreferencias = preferencias.edit();
                                    editarPreferencias.putString("usuario", "");
                                    editarPreferencias.putString("clave", "");
                                    editarPreferencias.commit();
                                    toast=null;
                                }
                                if(toast!=null){
                                    toast.show();
                                }
                            Intent i = new Intent(v.getContext(),ListaActivity.class);//activa la nueva actividad y lo guarda en la variable i
                            i.putExtra("usuario",u);//manda el usuario obtenido a la nueva actividad
                            startActivity(i);//inicia la actividad
                            break;
                        }else{//si la clave es incorrecta muestra error
                            etPass.setError(getResources().getString(R.string.ErrorClaveErrada));
                        }
                    }
                    if(existe==false){//muestra que el usuaro es incorrecto
                        etUsuario.setError(getResources().getString(R.string.ErrorUsuarioNoExiste));
                    }
                }
            }
        }
        if(v.getId()==R.id.btCancelar){//el boton cierra la actividad
            finish(); }
    }


}
