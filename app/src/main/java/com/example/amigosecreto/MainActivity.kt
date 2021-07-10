package com.example.amigosecreto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.Collections.shuffle
import kotlin.math.log10

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var respuesta = findViewById<TextView>(R.id.textrespuesta)
        var txtnombre = findViewById<EditText>(R.id.txtNombre);
        var btnAgregar = findViewById<Button>(R.id.btnAgregar);
        var lista = findViewById<ListView>(R.id.lista);
        val nombre = txtNombre.text;
        val amigos =  mutableListOf<String>();
        var arrayAdapter: ArrayAdapter<*>
        btnAgregar.setOnClickListener {
            amigos.add(nombre.toString())
            arrayAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                amigos
            )
            lista.adapter = arrayAdapter;
            arrayAdapter.notifyDataSetChanged();
        }
        btncrear.setOnClickListener {
             if (amigos.size <= 2){
                 respuesta.setText("No se puede hacer un amigo secreto con 2 o menos personas");
             }
            else{
                 var cadenarevuelta  = mutableListOf<String>(amigos.toString());
                 shuffle(amigos);
                 if (cadenarevuelta.toString() == amigos.toString()){
                     btncrear.performClick();
                 }
                 else{
                     respuesta.setText(amigos.toString());
                 }
             }
        }
    }
}
