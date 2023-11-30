package com.example.listsimp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // La clase Nodo representa los datos en la lista
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int valor) {
            dato = valor;
            siguiente = null;
        }
    }

    // Variables para el inicio y fin de la lista
    private Nodo inicio = null;
    private Nodo ultimo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se obtienen referencias a los elementos de la interfaz
        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);

        // Se configura el evento del botón
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic, se llama a la función para agregar un nuevo nodo
                agregarNodo();
            }

            // Función para agregar un nuevo nodo a la lista
            private void agregarNodo() {
                // Se obtiene el valor del EditText y se crea un nuevo nodo
                int valor = Integer.parseInt(editText.getText().toString());
                Nodo nuevoNodo = new Nodo(valor);

                // Se verifica si la lista está vacía
                if (inicio == null) {
                    inicio = nuevoNodo;
                    ultimo = nuevoNodo;
                } else {
                    // Si no está vacía, se añade el nuevo nodo al final
                    ultimo.siguiente = nuevoNodo;
                    ultimo = nuevoNodo;
                }

                // Se limpia el EditText después de agregar el nodo
                editText.setText("");
                // Se actualiza la visualización de la lista
                actualizarSalida();
            }

            // Función para actualizar y mostrar la lista actual

        });
    }
    private void actualizarSalida() {
        StringBuilder res = new StringBuilder();
        Nodo temp = inicio;

        // Se recorre la lista y se construye una cadena de resultados
        while (temp != null) {
            res.append(temp.dato).append("\n");
            temp = temp.siguiente;
        }

        // Se actualiza el TextView con la cadena resultante
        final TextView tv = findViewById(R.id.textView);
        tv.setText(res.toString());
    }
}
