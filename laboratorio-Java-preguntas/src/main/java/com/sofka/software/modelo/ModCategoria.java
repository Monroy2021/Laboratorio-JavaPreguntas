package com.sofka.software.modelo;

public class ModCategoria {
    private int idCategoria;
    private String nombreCategoria;

    public ModCategoria() {

    }

    public ModCategoria(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombreCategoria;
    }

    public void setNombre(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
