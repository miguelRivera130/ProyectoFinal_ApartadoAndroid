package com.example.apartado_android;

public class Pregunta {

    private String id;
    private String estado;
    private String pregunta;

    public Pregunta() {
    }

    public Pregunta(String id, String estado, String pregunta) {
        this.id = id;
        this.estado = estado;
        this.pregunta = pregunta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
