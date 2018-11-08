package com.example.joseguzman.agenda;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.joseguzman.agenda.Modelo.Lista;
import com.example.joseguzman.agenda.Modelo.Tarea;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    public static Lista misTareas = new Lista("misTareas");

    static ListView lvListas;
    Button btnNuevaTarea;
    static Lista milista = new Lista("misTareas");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvListas = (ListView) findViewById(R.id.lvListas);
        btnNuevaTarea = (Button) findViewById(R.id.btnNuevaTarea);

        try{
            if( getIntent() != null){
                milista = ((Lista) getIntent().getExtras().getSerializable("lista"));
            }
            ArrayAdapter<Tarea> adapter = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1, milista.getLista() ) ;
            lvListas.setAdapter(adapter);
        }catch (Exception e){


        }




        btnNuevaTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNuevaTarea = new Intent (v.getContext(), NuevaTarea.class);
                startActivity(intentNuevaTarea);
            }
        });

        lvListas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(view.getContext(),TareaDetalle.class);
                i.putExtra("tarea", (Tarea)parent.getItemAtPosition(position));
                startActivity(i);
            }



        });

        lvListas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String tareaeliminada = milista.getLista().get(i).toString();
                    milista.getLista().remove(i);
                    ArrayAdapter<Tarea> adapter = new ArrayAdapter<Tarea>(view.getContext(), android.R.layout.simple_list_item_1, milista.getLista() ) ;
                    lvListas.setAdapter(adapter);
                    Toast.makeText(view.getContext(),getResources().getString(R.string.TareaEliminada)+" "+tareaeliminada , Toast.LENGTH_LONG ).show();

                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<Tarea> adapter = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1, milista.getLista() ) ;
        lvListas.setAdapter(adapter);
    }
}
