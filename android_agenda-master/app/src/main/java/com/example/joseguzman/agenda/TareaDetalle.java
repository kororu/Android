package com.example.joseguzman.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.joseguzman.agenda.Modelo.Lista;
import com.example.joseguzman.agenda.Modelo.Tarea;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.joseguzman.agenda.Main.milista;

public class TareaDetalle extends AppCompatActivity {

    Tarea tarea;
    TextView tvIdTarea;
    EditText etDetalleTarea;
    TextView dtFechaInicioTarea;
    EditText dtFechaFinTarea;
    Button btnGuardarCambiosTarea;
    Button btnVolverTarea;
    CheckBox chbTerminarTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_detalle);

        tvIdTarea = (TextView) findViewById(R.id.tvIdTarea);
        etDetalleTarea = (EditText) findViewById(R.id.etDetalleTarea);
        dtFechaInicioTarea = (TextView) findViewById(R.id.dtFechaInicioTarea);
        dtFechaFinTarea = (EditText) findViewById(R.id.dtFechaFinTarea);
        btnGuardarCambiosTarea = (Button) findViewById(R.id.btnGuardarCambiosTarea);
        btnVolverTarea = (Button) findViewById(R.id.btnVolverTarea);
        chbTerminarTarea = (CheckBox) findViewById(R.id.chbTerminarTarea);


        final SimpleDateFormat spformat = new SimpleDateFormat("dd/mm/yyyy");
        spformat.setLenient(false);

        dtFechaInicioTarea.setEnabled(false);
        dtFechaFinTarea.setEnabled(false);

            try{
                tarea = ((Tarea) getIntent().getExtras().getSerializable("tarea"));
                boolean terminada = tarea.isTerminada();
                tvIdTarea.setText(tarea.getId() + "");
                dtFechaInicioTarea.setText(spformat.format(tarea.getFechaInicio()));
                dtFechaFinTarea.setText(spformat.format(tarea.getFechaTermino()));
                etDetalleTarea.setText(tarea.getDetalle());
                etDetalleTarea.setEnabled(!terminada);
                dtFechaFinTarea.setEnabled(!terminada);
                chbTerminarTarea.setChecked(terminada);

            }catch (Exception e){


            }

        btnGuardarCambiosTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Tarea t : milista.getLista()){
                    if(t.getId() == Integer.parseInt(tvIdTarea.getText().toString())){
                        t.setDetalle(etDetalleTarea.getText().toString());
                        try{
                            String fechat = dtFechaFinTarea.getText().toString();
                            /*t.setFechaTermino(spformat.parse(fechat));*/
                            t.setTerminada(chbTerminarTarea.isChecked());
                            finish();
                        }catch (Exception e){
                            dtFechaFinTarea.setError("Le fecha debe tener formato: dd/mm/yyyy");
                        }
                    }
                }
            }
        });



        btnVolverTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        chbTerminarTarea.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //TERMINAR TAREA

                }else {
                    //HABILITAR
                }

            }
        });


    }
}
