package com.example.joseg.loginusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText etUser;
    EditText etPassword;
    ArrayList<User> usersList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //REFERENCIAS
        etUser = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);

        for(int i=0;i<5;i++){
            usersList.add(new User("fname"+(i+1),"lname"+(i+1),"user"+(i+1),"123"+(i+1)));
        }

    }


    public void ConfirmButtonClick(View v){
        String user = etUser.getText().toString().toLowerCase();
        String pass = etPassword.getText().toString();
        String error="";
        User userLogin=null;

        if(user.isEmpty()){
            error="Debe ingresar un Usuario";
        }else if(pass.isEmpty()){
            error="Debe ingresar una Contraseña";
        }else{
            for (User u : usersList) {
                if(u.getUser().equals(user)){
                    if(u.getPassword().equals(pass)){
                        userLogin=u;
                       error="";
                       break;
                    }else{
                        //USUARIO EXISTE PERO CONTRASEÑA INCORRECTA
                        error="Contraseña incorrecta";
                        break;
                    }
                }else{
                    error="Usuario no existe";
                }
            }
        }

        if(userLogin!=null){
            //AQUI INGRESA EL USUARIO
            CleanButtonClick(findViewById(R.id.tvUser));
            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("userLogin",userLogin);
            startActivity(intent);
        }else{
            Toast.makeText(this,error,Toast.LENGTH_LONG).show();
        }
    }

    public void CleanButtonClick(View v){
        etUser.setText("");
        etPassword.setText("");
    }

    public void toSignIn(View v){


    }
}
