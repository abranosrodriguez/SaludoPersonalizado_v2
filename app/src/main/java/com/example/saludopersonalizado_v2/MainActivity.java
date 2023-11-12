package com.example.saludopersonalizado_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button btnSaludo;
    private EditText editTxtNombre, editTxtFecha;
    private String stringEditTxtNombre,stringEditTxtFecha, stringTxtSenor, stringTxtSenor2, txtSenor, txtSenor2;
    private RadioGroup rdbGroup;
    private RadioButton rdbSr, rdbSra;
    private int fecha, numero;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaludo = findViewById(R.id.btnSaludo);
        editTxtNombre = findViewById(R.id.editTxtNombre);
        editTxtFecha = findViewById(R.id.editTxtFecha);
        rdbGroup = findViewById(R.id.rdbGroup);
        rdbSr = findViewById(R.id.rdbSr);
        rdbSra = findViewById(R.id.rdbSra);
        rdbGroup = findViewById(R.id.rdbGroup);

        Date currentTime = Calendar.getInstance().getTime();
        String currentDate = new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());

        btnSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringEditTxtNombre = editTxtNombre.getText().toString();
                stringEditTxtFecha = editTxtFecha.getText().toString();
                if(stringEditTxtNombre.isEmpty() && stringEditTxtFecha.isEmpty()){
                    Toast.makeText(MainActivity.this, "ERROR - Proporciona algún dato", Toast.LENGTH_SHORT).show();
                }else if (stringEditTxtNombre.isEmpty()){
                    Toast.makeText(MainActivity.this, "ERROR - No se ha proporcionado ningún nombre", Toast.LENGTH_SHORT).show();
                }else if(stringEditTxtFecha.isEmpty()){
                    Toast.makeText(MainActivity.this, "ERROR - No se ha proporcionado ninguna fecha", Toast.LENGTH_SHORT).show();
                }else if(rdbGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(MainActivity.this, "ERROR - No has seleccionado ninguna opción", Toast.LENGTH_SHORT).show();
                }else{
                    numero = Integer.parseInt(stringEditTxtFecha);
                    fecha = Integer.parseInt(currentDate);
                    if(fecha -numero <= -1){
                        Toast.makeText(MainActivity.this, "ERROR - Pon una fecha valida", Toast.LENGTH_SHORT).show();
                    }else if(fecha - numero  >= 18 && rdbSr.isChecked()){
                        txtSenor = "Sr";
                        txtSenor2 = "Eres mayor de edad";

                    }else if(fecha - numero  >= 18 && rdbSra.isChecked()){
                        txtSenor = "Sra";
                        txtSenor2 = "Eres mayor de edad";

                    }else if(fecha - numero  <= 18 && rdbSr.isChecked()){
                       txtSenor = "Sr";
                       txtSenor2 = "Eres menor de edad";

                    }else if(fecha - numero  <= 18 && rdbSra.isChecked()){
                        txtSenor = "Sra";
                        txtSenor2 = "Eres menor de edad";
                    }
                    stringTxtSenor = txtSenor.toString();
                    stringTxtSenor2 = txtSenor2.toString();
                    Log.i("TAG",txtSenor2);
                    onClickCambiarActividad(view);
                }

            }
        });

    }
    public void onClickCambiarActividad(View v){
        Intent miIntent = new Intent(this, Saludo.class);
        miIntent.putExtra("datoNombre",stringEditTxtNombre);
        miIntent.putExtra("datoTxtSenor",txtSenor);
        miIntent.putExtra("datoTxtSenor2",txtSenor2);
        startActivity(miIntent);
    }
}