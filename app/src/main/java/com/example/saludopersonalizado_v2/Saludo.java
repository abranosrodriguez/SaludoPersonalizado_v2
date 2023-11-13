package com.example.saludopersonalizado_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView textViewSaludo;
    private int datoSr;
    private Button btnFinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        textViewSaludo = findViewById(R.id.txtViewSaludo);
        Intent intent = getIntent();
        String datoNombre = intent.getStringExtra("datoNombre");
        String datoSenor = intent.getStringExtra("datoTxtSenor");
        String datoSenor2 = intent.getStringExtra("datoTxtSenor2");
        textViewSaludo.setText("Hola "+datoSenor +" "+ datoNombre +"\n"+datoSenor2);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}