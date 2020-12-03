package com.example.apartado_android;

public class Respuesta {

    private String id;
    private String respuesta;

    public Respuesta() {
    }

    public Respuesta(String id, String respuesta) {
        this.id = id;
        this.respuesta = respuesta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
