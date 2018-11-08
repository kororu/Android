package com.example.ariel.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //inicializando
    private Switch swOpcion;
    private TextView tvMensaje;
    private ListView lsItem;
    private String[] Clientes;
    private String[] Productos;
    private Spinner spLista;
    private ArrayAdapter<String> Adaptador;
    private ArrayAdapter<String> Adaptador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //referencias

        Clientes =new String[6];
        Clientes[0]= "Ariel";
        Clientes[1]= "Alejandra";
        Clientes[2]= "Erik";
        Clientes[3]= "Canela";
        Clientes[4]= "Lucy";
        Clientes[5]= "Tocinito";

        Productos = new String[6];
        Productos[0]="Pan";
        Productos[1]="Jamon";
        Productos[2]="Queso";
        Productos[3]="Tocino";
        Productos[4]="Harina";
        Productos[5]="Canela";

        Adaptador=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Clientes);
        Adaptador2=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Productos);

        swOpcion=(Switch) findViewById(R.id.swOpcion);
        tvMensaje=(TextView) findViewById(R.id.tvMensaje);
        lsItem=(ListView) findViewById(R.id.lsItem);
        spLista=(Spinner) findViewById(R.id.spLista);


        swOpcion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvMensaje.setText("Productos");
                    lsItem.setAdapter(Adaptador2);
                    spLista.setAdapter(Adaptador2);
                }else{
                    tvMensaje.setText("Clientes");
                    lsItem.setAdapter(Adaptador);
                    spLista.setAdapter(Adaptador);
                }
            }
        });
lsItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Seleccionaste: " + parent.getItemAtPosition(position).toString() , Toast.LENGTH_LONG).show();
    }
});
lsItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Click Largo", Toast.LENGTH_LONG).show();
        return false;
    }
});

    }
}
