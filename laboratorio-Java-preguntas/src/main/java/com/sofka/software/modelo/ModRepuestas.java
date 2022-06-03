package com.sofka.software.modelo;

public class ModRepuestas {
    private int idRepuestas;
    public String opcion;
    public boolean valorBooleano;
    private int idPreguntas;

    public ModRepuestas() {

    }

    public ModRepuestas(int idRepuestas, String opcion, boolean valorBooleano, int idPreguntas) {
        this.idPreguntas = idPreguntas;
        this.opcion = opcion;
        this.valorBooleano = valorBooleano;
        this.idRepuestas = idRepuestas;
    }

    public int getIdRepuestas() {
        return idRepuestas;
    }

    public void setIdRepuestas(int idRepuestas) {
        this.idRepuestas = idRepuestas;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public boolean isValorBooleano() {
        return valorBooleano;
    }

    public void setValorBooleano(boolean valorBooleano) {
        this.valorBooleano = valorBooleano;
    }

    public int getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(int idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

}
