package com.oriana.recuerdame;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button botn_ver;
    private Button botn_agg;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearLista();
        crearNuevaTarea();
           }


    private void crearNuevaTarea() {
        this.botn_agg = (Button) findViewById(R.id.btn_agg);
        this.botn_agg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                agregaTarea();
            }
        });
    }

    private void crearLista() {
        this.botn_ver = (Button) findViewById(R.id.btn_ver);
        this.botn_ver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                irListado();
            }
        });
    }

    public void irListado() {
        Intent i = new Intent(this, Tareas.class);
        startActivity(i);
    }

    public void agregaTarea() {
        Intent i = new Intent(this, Edita.class);
        startActivity(i);
    }


}
