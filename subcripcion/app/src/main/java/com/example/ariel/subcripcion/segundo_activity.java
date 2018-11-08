package com.example.ariel.subcripcion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class segundo_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_activity);
    }




    public void clickWeb(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.inacap.cl"));
        startActivity(i);
    }


}
