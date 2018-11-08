package com.example.ariel.fechas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
 EditText etFechaNacimiento;
 TextView tvDiaSemana;
 TextView tvEdadComp;
 TextView tvProxCumple;
 Button btnAceptar;
 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
 SimpleDateFormat formatodiasemana = new SimpleDateFormat("EEEE");
 String fechaStr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFechaNacimiento =(EditText) findViewById(R.id.etFechaNacimiento);
        tvDiaSemana =(TextView) findViewById(R.id.tvDiaSemana);
        tvEdadComp =(TextView) findViewById(R.id.tvEdadComp);
        tvProxCumple =(TextView) findViewById(R.id.tvProxCumple);
        btnAceptar=(Button) findViewById(R.id.btnAceptar);

btnAceptar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String fechaStr = etFechaNacimiento.getText().toString();

        try {
            formatofecha.setLenient(false);
            Date Fecha = formatofecha.parse(fechaStr);
            if(Fecha.compareTo(new Date())<0){
                Calendar cal = Calendar.getInstance();
                cal.setTime(Fecha);
                tvDiaSemana.setText(getResources().getString(R.string.naciste) + formatodiasemana.format(Fecha));
                tvEdadComp.setText(obtenerEdadMasDias(cal));


            }else{
                etFechaNacimiento.setError(getResources().getString(R.string.laFechaIngresada));
                tvDiaSemana.setText("");
                tvDiaSemana.setText("");
                tvProxCumple.setText("");
            }
        }catch (ParseException e){
            Log.d("TAG_", e.toString());
            etFechaNacimiento.setError(getResources().getString(R.string.ElFormatoDebeSer));
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
});

    }
    public String ObEdadCompleta(Calendar Fecha){
        int mesNac, diaNac, anoNac;
        diaNac =formatofecha.getCalendar().get(Calendar.DAY_OF_MONTH);
        mesNac=formatofecha.getCalendar().get(Calendar.MONTH)+1;
        anoNac=formatofecha.getCalendar().get(Calendar.YEAR);

        int actmes, actdia, actano;
        Calendar cal = Calendar.getInstance();
        actdia =cal.get(Calendar.DAY_OF_MONTH);
        actmes=cal.get(Calendar.MONTH);
        actano=cal.get(Calendar.YEAR);

        int edaddia=0, edadmes=0, edadano=0;
        edadano=actano - anoNac;
        if (mesNac > actmes) {
            edadano=edadano-1;
            edadmes=12 -(mesNac - actmes);
            edaddia= actdia;
        } else if (mesNac == actmes) {
            if (diaNac > actdia) {
                edadano= edadano-1;
                edadmes=11;
                edaddia=actdia;
            }else{
                edadmes=0;
                edaddia=actdia-diaNac;
            }
        }else{
            edadmes=actmes - mesNac;
            edaddia=actdia;
        }

        String edadCompleta = getResources().getString(R.string.UstedTiene)+ edadano + getResources().getString(R.string.Anos) + edadmes + getResources().getString(R.string.Meses)+ edaddia + getResources().getString(R.string.Dias);
        return (edadCompleta);
    }

    public String obtenerEdadMasDias(Calendar fechaNac){
        int anos = Calendar.getInstance().get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diaNac = fechaNac.get(Calendar.DAY_OF_YEAR);
        int hoy = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        int dias = 0;

        if (hoy<diaNac){ // aun no cumple
            anos=anos-1;
            dias = ( Calendar.getInstance().getMaximum(Calendar.DAY_OF_YEAR) - diaNac ) + hoy;
        }else{
            dias = hoy - diaNac;
        }
        return getResources().getString(R.string.Tienes) + anos + getResources().getString(R.string.AnosY) + dias + getResources().getString(R.string.Dias);
    }

}
