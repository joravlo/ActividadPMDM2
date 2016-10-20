package com.example.jordi.actividadpmdm2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btEnviar;
    TextView tvText;
    EditText etNom;
    RadioGroup radioGroup;
    RadioButton radioFemella, radioMascle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEnviar = (Button) findViewById(R.id.btEnviar);
        tvText = (TextView) findViewById(R.id.tvText);
        etNom = (EditText) findViewById(R.id.etNom);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioFemella = (RadioButton) findViewById(R.id.rdFemella);
        radioMascle = (RadioButton) findViewById(R.id.rbMascle);

        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("MENSAJE");
            boolean enviar = savedInstanceState.getBoolean("ENVIAR");
            boolean nom = savedInstanceState.getBoolean("NOM");
            boolean radiogroup = savedInstanceState.getBoolean("RADIOGROUP");
            boolean mascle = savedInstanceState.getBoolean("MASCLE");
            boolean femella = savedInstanceState.getBoolean("FEMELLA");
            if (enviar == false)
                btEnviar.setEnabled(false);
            if (nom == false)
                etNom.setEnabled(false);
            if (radiogroup == false)
                radioGroup.setEnabled(false);
            if (mascle == false)
                radioFemella.setEnabled(false);
            if (femella == false)
                radioMascle.setEnabled(false);

            tvText.setText(message);
        }

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                intent.putExtra("NOM", etNom.getText().toString());
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                desactivarElementos();
                String edat = data.getStringExtra("EDAT");
                int edatNum = Integer.parseInt(edat);
                if((edatNum >= 18) && (edatNum < 25)){
                    tvText.setText("Com que tens "+edatNum+" anys, ja eres major de edat");
                } else if ((edatNum >= 25) && (edatNum < 35)){
                    tvText.setText("Com que tens "+edatNum+" anys, estas en la flor de la vida");
                } else {
                    tvText.setText("Com que tens "+edatNum+" anys, ai ai ai...");
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("MENSAJE",tvText.getText().toString());
        outState.putBoolean("ENVIAR", btEnviar.isEnabled());
        outState.putBoolean("NOM", etNom.isEnabled());
        outState.putBoolean("RADIOGROUP", radioGroup.isEnabled());
        outState.putBoolean("MASCLE", radioMascle.isEnabled());
        outState.putBoolean("FEMELLA", radioFemella.isEnabled());
        super.onSaveInstanceState(outState);
    }

    public void desactivarElementos(){
        btEnviar.setEnabled(false);
        etNom.setEnabled(false);
        radioGroup.setEnabled(false);
        radioFemella.setEnabled(false);
        radioMascle.setEnabled(false);
    }
}
