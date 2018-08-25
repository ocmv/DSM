package com.oriana.recuerdame;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Edita extends Activity {

    EditText cActividad,cDescripcion,cArea;
    Button bConfirm;
    ProgressDialog progreso;
    private static Context mContext;

    //conexion ws
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_edita);

        cActividad = (EditText) findViewById(R.id.actividad);
        cDescripcion = (EditText) findViewById(R.id.descripcion);
        cArea = (EditText) findViewById(R.id.area);
        bConfirm= (Button) findViewById(R.id.confirm);


        request= Volley.newRequestQueue(this);
       bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebServices();
            }
        });


        }


    private void cargarWebServices(){


        progreso=new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();


        String url="http://10.0.2.2/Tareasproyecto/WsJSONRegistro.php?titulo="+cActividad.getText().toString()+
                "&descripcion="+cDescripcion.getText().toString()+"&area="+cArea.getText().toString();

            url=url.replace(" ","%20");




          jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
              @Override
              public void onResponse(JSONObject response) {
                  Toast.makeText(getApplicationContext(),"Se ha registrado la actividad", Toast.LENGTH_LONG).show();
                  progreso.hide();
                  cActividad.setText("");
                  cDescripcion.setText("");
                  cArea.setText("");
                  Log.i("bien", response.toString());
              }
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {

                      progreso.hide();
                      Toast.makeText(getApplicationContext(),"No se pudo registrar" + error.toString(),Toast.LENGTH_LONG).show();

                      Log.i("ERROR",error.toString());

              }
          }
          );


            request.add(jsonObjectRequest);


    }



}
