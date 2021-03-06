package com.example.comparativogasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;
    private Object pGasolina;
    private Object pAlcool;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);

        textResultado = findViewById(R.id.resultado);
    }

    public void CalculaPreço(View view){

        PrecoAlcool = editPrecoAlcool.getText( PrecoAlcool);
        PrecoGasolina = editPrecoGasolina.getText( PrecoGasolina);

        Boolean camposValidados = validarCampos(PrecoAlcool, PrecoGasolina);

        if(camposValidados){

            Double valorAlcool = Double.parseDouble(String.valueOf(PrecoAlcool));
            Double valorGasolina = Double.parseDouble(String.valueOf(PrecoGasolina));

            Double resultado = valorAlcool / valorGasolina;

            if(resultado >= 0.7){

                textResultado.setText("Melhor utilizar a Gasolina");
            }
            else{
                textResultado.setText("Melhor utiliar o Alcool");
            }
        }
    }
    public Boolean validarCampos( String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if((pAlcool == null) || PrecoAlcool.equals("")){
            camposValidados = false;
        }
        else if((pGasolina == null) || PrecoGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}