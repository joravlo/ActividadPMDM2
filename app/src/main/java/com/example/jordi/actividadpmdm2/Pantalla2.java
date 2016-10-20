package com.example.jordi.actividadpmdm2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    TextView tvPresentacio;
    Button btContinuar;
    EditText etEdat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        tvPresentacio = (TextView) findViewById(R.id.tvPresentacio);
        btContinuar = (Button) findViewById(R.id.btContinuar);
        etEdat = (EditText) findViewById(R.id.etEdat);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("NOM");
        tvPresentacio.setText("Hola en "+nombre+", indica'ns les següents dades:");

        btContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("EDAT",etEdat.getText().toString());
                setResult(Activity.RESULT_OK,intent1);
                finish();
            }
        });
    }
}
