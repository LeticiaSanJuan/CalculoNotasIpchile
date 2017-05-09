package com.example.usuario2.calculonotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn_ir;
        btn_ir  = (Button) findViewById(R.id.btn_ir);

        btn_ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn_ir = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(btn_ir);



            }
        });//fin btn info













    }
}
