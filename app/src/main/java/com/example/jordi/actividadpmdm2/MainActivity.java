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

    public void desactivarElementos(){
        btEnviar.setEnabled(false);
        etNom.setEnabled(false);
        radioGroup.setEnabled(false);
        radioFemella.setEnabled(false);
        radioMascle.setEnabled(false);
    }
}
