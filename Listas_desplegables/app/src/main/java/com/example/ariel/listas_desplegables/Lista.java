package com.example.ariel.listas_desplegables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Lista extends AppCompatActivity {

    private Switch swCambio;
    private TextView tvMensaje;
    private String[] Items;
    private ArrayAdapter<String> adaptadorItems;
    private ListView lvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Items= new String[6];
        Items[0]="uno";
        Items[1]="dos";
        Items[2]="tres";
        Items[3]="cuantro";
        Items[4]="cinco";
        Items[5]="seis";
        adaptadorItems=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Items);
        //referencias
        swCambio=(Switch)findViewById(R.id.swCambio);
        tvMensaje=(TextView)findViewById(R.id.tvMensaje);
        lvItem=(ListView)findViewById(R.id.lvItem);
        //eventos

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Lista.this,"Click en :" + position,Toast.LENGTH_LONG).show();
            }
        });







    }
}
