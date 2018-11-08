package com.example.joseguzman.agenda;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.joseguzman.agenda.Modelo.Lista;
import com.example.joseguzman.agenda.Modelo.Tarea;

import java.util.ArrayList;
import java.util.List;

import static com.example.joseguzman.agenda.Main.milista;

public class NuevaTarea extends AppCompatActivity {


    ListView lvListas;
    Button btnGuardarNuevaTarea;
    EditText etDetalleTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_tarea);

        lvListas = (ListView) findViewById(R.id.lvListas);
        btnGuardarNuevaTarea = (Button) findViewById(R.id.btnGuardarNuevaTarea);
        etDetalleTarea = (EditText) findViewById(R.id.etDetalleTarea);


        //Accion de Click en Boton Guardar Nueva Tarea.
        btnGuardarNuevaTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detalle = etDetalleTarea.getText().toString();
                if(detalle.isEmpty()){
                    etDetalleTarea.setError(getResources().getString(R.string.errorDetalleTareaEmpty));
                }else {
                        Tarea t = new Tarea(detalle,milista);
                        milista.añadirTarea(t);
                        finish();
                }
            }
        });


    }
}
