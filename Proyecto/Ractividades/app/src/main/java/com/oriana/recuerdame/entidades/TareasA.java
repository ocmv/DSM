package com.oriana.recuerdame.entidades;

/**
 * Created by Oriana on 13/8/2018.
 */

public class TareasA {

    private String mTitulo;
    private String mDescripcion;

    public TareasA(String titulo, String descripcion){

        mTitulo=titulo;
        mDescripcion=descripcion;

    }


    public String getmDescripcion() {
        return mDescripcion;
    }

    public String getmTitulo() {
        return mTitulo;
    }
}
