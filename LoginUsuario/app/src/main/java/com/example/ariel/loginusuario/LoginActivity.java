package com.example.ariel.loginusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private Usuario [] losUsuario= new Usuario[3];
    private EditText txtUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //txtUsuario = (EditText) findViewById(R.id.txtUsuario);

        losUsuario[0] = new Usuario ("Ariel","Ponce","aponce",123);
        losUsuario[1] = new Usuario ("Alejandra","Martinez","amartinez",123);
        losUsuario[2] = new Usuario ("Erik","Ponce","eponce",123);
    }
public void clickBoton(View v){
 if(v.getId() == R.id.btAceptar){
String userout =((EditText)findViewById(R.id.txtUsuario)).getText().toString();
     String claveout =((EditText)findViewById(R.id.txtClave)).getText().toString();

     Usuario valido = null;

     boolean validuser=false , validpass=false;
     for (Usuario u : losUsuario){
    if(userout.equals(u.getUsuario())){
        validuser =true;
        if(claveout.equals(u.getClave()+"")){
            validpass=true;
            valido=u;
            break;
        }
    }


}

if(validuser==true && validpass==true){
     Intent i = new Intent(this, UsuarioActivity.class);
     i.putExtra("nombre", valido.NombreCompleto(valido) );
    startActivity(i);

     }else if (validuser==false){
         Toast.makeText(this, "Usuario Erroneo", Toast.LENGTH_SHORT  ).show();
}else{
         Toast.makeText(this, "Contraseña Erronea", Toast.LENGTH_SHORT).show();
     }
 }else {
     finish();
 }
}






}
