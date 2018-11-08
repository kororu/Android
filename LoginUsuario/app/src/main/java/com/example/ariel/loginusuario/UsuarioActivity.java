package com.example.ariel.loginusuario;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        //mostrar nombre en el textview de la actividad
        Bundle bundle = getIntent().getExtras();
        String nombreobtenido =bundle.getString("nombre");
     TextView txtnombrecompleto = (TextView) findViewById(R.id.txtnombrecompleto);
      txtnombrecompleto.setText("Buenos dias "+ nombreobtenido);
          }
    public void clickLlamar(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+56948821559"));
        startActivity(i);
    }
    public void clickWeb(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.cl"));
        startActivity(i);
    }
    public void clickContact(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
        startActivity(i);
    }
    public void clickCamera(View v) {
        Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(i);
    }

}
