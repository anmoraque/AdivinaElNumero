package com.anmoraque.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int intento = 0;

    private int numeroAleatorio;

    private int generarNumeroAleatorioDe1a100 () {
        int numeroaleatorio = 0;
        numeroaleatorio = (int) (Math.random() * 100 + 1);
        return numeroaleatorio;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroAleatorio = generarNumeroAleatorioDe1a100();
        Log.d("ETIQUETA_LOG", "Numero aleatorio = " + numeroAleatorio);
    }

    public void adivinar(View view) {
        EditText cajaNumero= findViewById(R.id.numeroUsuario);
        String numeroFormatoCadena = cajaNumero.getText().toString();
        Log.d("ETIQUETA_LOG", "Numero usuario = " + numeroFormatoCadena);
        int numeroFormatoEntero = Integer.parseInt(numeroFormatoCadena);
        Log.d("ETIQUETA_LOG", "Numero usuario formato entero = " + numeroFormatoEntero);

        TextView cajaMensaje= findViewById(R.id.mensajeResultado);
        if (numeroFormatoEntero == numeroAleatorio){
            cajaMensaje.setText ("¡CORRECTO! Ese es el número");
        }
        else {
            if (numeroFormatoEntero > numeroAleatorio) {
                cajaMensaje.setText ("El número buscado es menor");
            }
            else {
                cajaMensaje.setText ("El número buscado es mayor");
            }

            intento++;
            if (intento <= 5) {
                TextView cajaIntentos = findViewById(R.id.numeroIntentos);
                cajaIntentos.setText("Intento número: " + intento);
            }
            else {
                TextView cajaIntentos = findViewById(R.id.numeroIntentos);
                cajaIntentos.setText("Has sobrepasado el numero de intentos");
            }
            cajaNumero.setText("");
        }
}
}