package com.example.pipe.persistencia;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickButton(View v) {
        if (v.getId() == R.id.btnCheck) {
            String[] items = {"uno", "dos", "tres"};
            final boolean[] itemSel = new boolean[3];
            final AlertDialog.Builder opciones = new AlertDialog.Builder(this);
            opciones.setTitle("Titulo");
            opciones.setIcon(R.drawable.ic_favorite_black_24dp);
            opciones.setMultiChoiceItems(items, itemSel, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    itemSel[which] = isChecked;
                }

            });

            opciones.setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    for (int x = 0; x < itemSel.length; ++x) {
                        Log.d("LOG_", "Item" + x + "--->" + itemSel[x]);
                    }
                }
            });

            AlertDialog alertLista = opciones.create();
            alertLista.show();


        }


        if (v.getId() == R.id.btnLista) {
            String[] items = {"uno", "dos", "tres"};
            AlertDialog.Builder opciones = new AlertDialog.Builder(this);
            opciones.setTitle("Titulo");
            opciones.setIcon(R.drawable.ic_favorite_black_24dp);
            opciones.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Item" + which, Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog alertLIsta = opciones.create();
            alertLIsta.show();
        }

        if (v.getId() == R.id.btnHora) {
            TimePickerDialog horaDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Log.d("TAG_", hourOfDay + ":" + minute);
                }
            }, 19, 27, true);

            horaDialog.show();
        }


        if (v.getId() == R.id.btnAlertdialog) {
            DatePickerDialog fechaDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Log.d("TAG_", dayOfMonth + "/" + month + "/" + year);
                }
            }, 2018, 10, 14);

            fechaDialog.show();
        }
        if (v.getId() == R.id.btnNormal) {

            AlertDialog.Builder opciones = new AlertDialog.Builder(this);
            opciones.setTitle("Titulo");
            opciones.setMessage("mensaje");
            opciones.setIcon(R.drawable.ic_favorite_black_24dp);
            opciones.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(MainActivity.this, "Gracias por presionar el boton aceptar", Toast.LENGTH_SHORT).show();
                }
            });

            opciones.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Gracias por presionar el boton Cancelar", Toast.LENGTH_SHORT).show();
                }
            });
            opciones.setNeutralButton("Omitir", null);// si queremos dar funcionalidad debemos crear un listener

            AlertDialog a = opciones.create();
            a.show();
        }

        if (v.getId() == R.id.btnGrabar) {
            SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editarPreferencias = preferencias.edit();
            editarPreferencias.putString("usuario", "strobl");
            editarPreferencias.putString("clave", "no viene a clases");
            editarPreferencias.putBoolean("guilty", false);
            editarPreferencias.commit();

        }
        if (v.getId() == R.id.btnLeer) {
            SharedPreferences preferecias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            Map<String, ?> keys = preferecias.getAll();
            for (Map.Entry<String, ?> entry : keys.entrySet()) {
                //entry.getKey();
                Log.d("TAG_", entry.getKey() + " -> " + entry.getValue().toString());
            }
        }
    }
}
