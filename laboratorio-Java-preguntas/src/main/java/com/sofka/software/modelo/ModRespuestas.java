package com.sofka.software.modelo;

public class ModRespuestas {
    private int idRespuestas;
    public String opcion;
    public int valorBooleano;
    private int idPreguntas;

    public ModRespuestas() {

    }

    public ModRespuestas(int idRespuestas, String opcion, int valorBooleano, int idPreguntas) {
        this.idPreguntas = idPreguntas;
        this.opcion = opcion;
        this.valorBooleano = valorBooleano;
        this.idRespuestas = idRespuestas;
    }

    public int getIdRespuestas() {
        return idRespuestas;
    }

    public void setIdRespuestas(int idRepuestas) {
        this.idRespuestas = idRepuestas;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public int getValorBooleano() {
        return valorBooleano;
    }

    public void setValorBooleano(int valorBooleano) {
        this.valorBooleano = valorBooleano;
    }

    public int getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(int idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

}
