package com.example.comparativogasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);

        textResultado = findViewById(R.id.resultado);
    }

    public void CalculaPreço(View view){

        String PrecoAlcool = editPrecoAlcool.getText(PrecoAlcool);
        String PrecoGasolina = editPrecoGasolina.getText(PrecoGasolina);

        Boolean camposValidados = validarCampos(PrecoAlcool, PrecoGasolina);

        if(camposValidados){

            Double valorAlcool = Double.parseDouble(PrecoAlcool);
            Double valorGasolina = Double.parseDouble(PrecoGasolina);

            Double resultado = valorAlcool / valorGasolina;

            if(resultado >= 0.7){

                textResultado.setText("Melhor utilizar a Gasolina");
            }
            else{
                textResultado.setText("Melhor utiliar o Alcool");
            }
        }

        public Boolean validarCampos(String pAlcool, String pGasolina);{
            Boolean camposValidados = true;

            if(pAlcool == null) || PrecoAlcool.equals(""){
                camposValidados = false;
            }
            else if(pGasolina == null) || PrecoGasolina.equals(""){
                camposValidados = false;
            }

            return camposValidados;
        }
    }
}