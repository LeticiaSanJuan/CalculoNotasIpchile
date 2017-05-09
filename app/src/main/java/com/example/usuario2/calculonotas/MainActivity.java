package com.example.usuario2.calculonotas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText et_epr1, et_epe1, et_epr2, et_epe2, et_eva1, et_eva2, et_eva3, et_eva4, et_prom, et_examen, et_promfin;
    Button btn_calcular, btn_examen , btn_info;
     Double nota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_epr1 = (EditText) findViewById(R.id.et_epr1);
        et_epe1 = (EditText) findViewById(R.id.et_epe1);
        et_epr2 = (EditText) findViewById(R.id.et_epr2);
        et_epe2 = (EditText) findViewById(R.id.et_epe2);
        et_eva1 = (EditText) findViewById(R.id.et_eva1);
        et_eva2 = (EditText) findViewById(R.id.et_eva2);
        et_eva3 = (EditText) findViewById(R.id.et_eva3);
        et_eva4 = (EditText) findViewById(R.id.et_eva4);
        et_prom = (EditText) findViewById(R.id.et_prom);

        et_examen = (EditText) findViewById(R.id.et_examen);
        et_promfin = (EditText)findViewById(R.id.et_promfin);

        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_examen = (Button) findViewById(R.id.btn_examen);
        btn_info  = (Button) findViewById(R.id.btn_info);


        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contexto = getApplicationContext();

                Double epr1 = Double.parseDouble(et_epr1.getText().toString()) / 10;
                Double epe1 = Double.parseDouble(et_epe1.getText().toString()) / 10;
                Double epr2 = Double.parseDouble(et_epr2.getText().toString()) / 10;
                Double epe2 = Double.parseDouble(et_epe2.getText().toString()) / 10;
                Double eva1 = Double.parseDouble(et_eva1.getText().toString()) / 10;
                Double eva2 = Double.parseDouble(et_eva2.getText().toString()) / 10;
                Double eva3 = Double.parseDouble(et_eva3.getText().toString()) / 10;
                Double eva4 = Double.parseDouble(et_eva4.getText().toString()) / 10;


                Double porcEpr1 = epr1 * 0.10;
                Double porcEpe1 = epe1 * 0.15;
                Double porcEpr2 = epr2 * 0.20;
                Double porcEpe2 = epe2 * 0.25;

                Double sumSolem = porcEpr1 + porcEpe1 + porcEpr2 + porcEpe2;
                Double sumEvas = (eva1 + eva2 + eva3 + eva4) / 4;
                Double porcEvas = sumEvas * 0.30;

                Double nota = sumSolem + porcEvas;
                String prom = String.valueOf(nota);
                et_prom.setText(prom);

                //Toast.makeText(contexto, "" + prom, Toast.LENGTH_SHORT).show();

                if (epr1 < 4.0 || epe1 < 4.0 || epr2 < 4.0 || epe2 < 4.0 ) {
                    Toast.makeText(contexto, "" + "Tienes una solemne con nota bajo 4.0, debes dar examen :(", Toast.LENGTH_SHORT).show();
                }else{
                    if (nota<5.5) {

                        Toast.makeText(contexto, "" + "Tu promedio es bajo 5.5, debes dar examen :(", Toast.LENGTH_SHORT).show();
                    }else{
                        if (epr1 > 4.0 || epe1 > 4.0 || epr2 > 4.0 || epe2 > 4.0 && nota>=5.5) {
                            Toast.makeText(contexto, "" + "Estas eximido :)", Toast.LENGTH_SHORT).show();
                        }
                    }
                }



                /*
                 if (epr1 < 4.0 || epe1 < 4.0 || epr2 < 4.0 || epe2 < 4.0 ) {
                    Toast.makeText(contexto, "" + "Tienes una solemne con nota bajo 4.0, debes dar examen :(", Toast.LENGTH_SHORT).show();
                }
                if (nota<5.5) {

                    Toast.makeText(contexto, "" + "Tu promedio es bajo 5.5, debes dar examen :(", Toast.LENGTH_SHORT).show();
                }
                if (epr1 > 4.0 || epe1 > 4.0 || epr2 > 4.0 || epe2 > 4.0 && nota>=5.5) {
                    Toast.makeText(contexto, "" + "Estas eximido :)", Toast.LENGTH_SHORT).show();
                }
                */



            }// fin public void


        });//fin clickview

        btn_examen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double notaexamen = Double.parseDouble(et_examen.getText().toString()) / 10;
                Double notapresentacion = Double.parseDouble(et_prom.getText().toString());

                Double notapres = notapresentacion * 0.70;
                Double ex = notaexamen * 0.30;
                Double notafin = notapres + ex;
                String notafinString = String.valueOf(notafin);


                et_promfin.setText(notafinString);

                Context contexto = getApplicationContext();

                if (notafin >=4.0) {
                    Toast.makeText(contexto, "" + "Tu promedio final es sobre 4.0, has aprobado :D", Toast.LENGTH_SHORT).show();
                }
                if (notafin<4.0){
                    Toast.makeText(contexto, "" + "Tu promedio final es bajo 4.0, has reprobado :'(", Toast.LENGTH_SHORT).show();
                }





            }
        });//fin btn examen



        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn_info = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(btn_info);



            }
        });//fin btn info


    }
}



