package com.example.joseg.loginusuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText etUser = (EditText)findViewById(R.id.etUserRegister);
    EditText etPass = (EditText)findViewById(R.id.etPasswordRegister);
    EditText etPass2 = (EditText)findViewById(R.id.etPasswordRepRegister);
    EditText etFName = (EditText)findViewById(R.id.etFirtsNameRegister);
    EditText etLName = (EditText)findViewById(R.id.etLastNameRegister);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void SignInButtonClick(View v){
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();
        String pass2 = etPass2.getText().toString();
        String fname = etFName.getText().toString();
        String lname = etLName.getText().toString();


        if(user.isEmpty()){
            Toast.makeText(this,"Error: Insert User!",Toast.LENGTH_SHORT);
        }else if(pass.isEmpty()){
            Toast.makeText(this,"Error: Insert Password!",Toast.LENGTH_SHORT);
        }else if(pass2.isEmpty() || !pass.equals(pass2)){
            if(pass2.isEmpty()){
                Toast.makeText(this,"Error: Repeat Password!",Toast.LENGTH_SHORT);
            }else{
                Toast.makeText(this,"Error: Passwords don't macht!",Toast.LENGTH_SHORT);
            }
        }else if(fname.isEmpty()){
            Toast.makeText(this,"Error: Insert First Name!",Toast.LENGTH_SHORT);
        }else if(lname.isEmpty()){
            Toast.makeText(this,"Error: Insert Last Name!",Toast.LENGTH_SHORT);
        }else{



        }

    }

    public void CleanButtonClick(View v){
        etUser.setText("");
        etPass.setText("");
        etPass2.setText("");
        etFName.setText("");
        etLName.setText("");
    }

}
