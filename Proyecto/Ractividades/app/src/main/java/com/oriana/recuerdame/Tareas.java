package com.oriana.recuerdame;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.oriana.recuerdame.adapter.ActividadesAdapter;
import com.oriana.recuerdame.entidades.TareasA;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tareas extends Activity  {

    private RecyclerView mRecyclerView;
    private ActividadesAdapter mActividadesAdapter;
    private ArrayList<TareasA> mTareasALista;
    private RequestQueue mRequestQueue;
    EditText campoArea;
    Button boton_buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        campoArea=(EditText) findViewById(R.id.bus_area);
        boton_buscar = (Button) findViewById(R.id.btn_buscar);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTareasALista = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        boton_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebServices();
            }
        });

    }

    private void cargarWebServices() {
//Local
        String url="http://10.0.2.2/Tareasproyecto/WsJSONConsulta.php?area="+campoArea.getText().toString();
//10.0.2.2


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("actividades");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject act = jsonArray.getJSONObject(i);

                                String tituloAct = act.getString("titulo");
                                String descrAct = act.getString("descripcion");


                                mTareasALista.add(new TareasA(tituloAct, descrAct));
                            }

                            mActividadesAdapter = new ActividadesAdapter(Tareas.this, mTareasALista);
                            mRecyclerView.setAdapter(mActividadesAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);

    }


}
