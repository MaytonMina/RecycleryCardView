package com.example.myapplication.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario1 {

    String nombres;
    String area;
    String foto;
    String urlfoto;

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }
    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Usuario1(JSONObject a) throws JSONException {
        nombres =  a.getString("nombres").toString() ;
        area =  a.getString("area").toString() ;
        foto =  a.getString("imgjpg").toString() ;
        urlfoto = a.getString("imgJPG").toString() ;
    }

    public static ArrayList<Usuario1> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario1> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            usuarios.add(new Usuario1(datos.getJSONObject(i)));
        }
        return usuarios;
    }
}
