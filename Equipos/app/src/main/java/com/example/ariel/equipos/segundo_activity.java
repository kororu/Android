package com.example.ariel.equipos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class segundo_activity extends AppCompatActivity {
    TextView tvDptoUsuario;
    TextView tvNombreUsuario;
    TextView tvTotalMonto;
    ListView lvEquiposCargo;
    Button btnCargarEquipo;
    Button btnDescargarEquipo;
    AutoCompleteTextView autoTvNroSerie;
    TextView tvDescEquipo;
    TextView tvValorEquipo;
    Button btnFinalizar;

   List<Equipo> equiposAsig;
    ListAdapter adapter;
    ArrayAdapter adapterAutoComplete;
    Equipo e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_activity);

        tvDptoUsuario = (TextView) findViewById(R.id.tvDptoUsuario);
        tvNombreUsuario = (TextView) findViewById(R.id.tvNombreUsuario);
        tvTotalMonto = (TextView) findViewById(R.id.tvTotalMonto);
        lvEquiposCargo = (ListView) findViewById(R.id.lvEquiposCargo);
        btnCargarEquipo = (Button) findViewById(R.id.btnCargarEquipo);
        btnDescargarEquipo = (Button) findViewById(R.id.btnDescargarEquipo);
        autoTvNroSerie = (AutoCompleteTextView) findViewById(R.id.autoTvNroSerie);
        tvDescEquipo = (TextView) findViewById(R.id.tvDescEquipo);
        tvValorEquipo = (TextView) findViewById(R.id.tvValorEquipo);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);

        final Usuario usuario = (Usuario) getIntent().getExtras().getSerializable("usuario");
        tvNombreUsuario.setText(usuario.getNombre() + " " + usuario.getApellido());
        tvDptoUsuario.setText(usuario.getDepartamento());

        actualizarVistas(usuario);

        autoTvNroSerie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Equipo e = BaseDatos.buscarEquipo(autoTvNroSerie.getText().toString());
                tvDescEquipo.setText(e.getDescripcion());
                tvValorEquipo.setText(e.getValor()+"");
            }
        });

        btnCargarEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Equipo e = BaseDatos.buscarEquipo(autoTvNroSerie.getText().toString());

                if (e != null) {
                    boolean disponible = false;

                    for (Equipo equipo : BaseDatos.equiposDisponibles()
                            ) {
                        if (equipo.getSerie().equals(e.getSerie())) {
                            disponible = true;
                        }
                    }
                    if (disponible) {
                        BaseDatos.cargarEquipoAlUsuario(usuario.getUsuario(), e.getSerie());
                        actualizarVistas(usuario);
                        autoTvNroSerie.setText("");
                        tvDescEquipo.setText("");
                        tvValorEquipo.setText("");
                    } else {
                        autoTvNroSerie.setError(getResources().getString(R.string.autoTvSerieErrorYaAsignado));
                    }
                } else {
                    autoTvNroSerie.setError(getResources().getString(R.string.autoTvSerieErrorNoExiste));
                }
            }
        });

        lvEquiposCargo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 e = (Equipo) lvEquiposCargo.getItemAtPosition(position);
            }
        });

        btnDescargarEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //e=(Equipo) lvEquiposCargo.getItemAtPosition(position);
                BaseDatos.descargarEquipoAlUsuario(usuario.getUsuario(),e.getSerie());
                actualizarVistas(usuario);
            }
        });


        lvEquiposCargo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Equipo e = (Equipo) lvEquiposCargo.getItemAtPosition(position);
                BaseDatos.descargarEquipoAlUsuario(usuario.getUsuario(),e.getSerie());
                actualizarVistas(usuario);
                return false;
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void actualizarVistas(Usuario usuario) {

        equiposAsig = BaseDatos.equiposPorUsuario(usuario.getUsuario());
        adapter = new ArrayAdapter<Equipo>(this, android.R.layout.simple_list_item_1, equiposAsig);
        lvEquiposCargo.setAdapter(adapter);

        double total = 0;
        for (Equipo equipo : equiposAsig
                ) {
            total = total + equipo.getValor();
        }
        tvTotalMonto.setText("$ " + total);


        List<String> seriesDisp = new ArrayList<>();
        for (Equipo e : BaseDatos.equiposDisponibles()
                ) {
            seriesDisp.add(e.getSerie());
        }
        adapterAutoComplete = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seriesDisp);
        autoTvNroSerie.setAdapter(adapterAutoComplete);


    }
    }
