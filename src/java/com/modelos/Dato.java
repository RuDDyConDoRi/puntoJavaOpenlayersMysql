package com.modelos;

/**
 *
 * @author ruddy.condori
 */
public class Dato {

    private int id;
    private String latitud;
    private String longitud;

    public Dato() {
    }

    public Dato(int id, String latitud, String longitud) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitud() {
        return this.latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return this.longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}

