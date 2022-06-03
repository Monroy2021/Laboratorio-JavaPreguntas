package com.sofka.software.controlador;

import com.sofka.software.modelo.ModCategoria;
import com.sofka.software.modelo.ModPreguntas;
import com.sofka.software.modelo.ModRepuestas;

import java.util.ArrayList;
import java.util.Random;

public class ConParticipante {
    static ConsultaDB_mensajes message = ConsultaDB_mensajes.getInstance();

    public int nivel = 1;
    public String acumulado = "0";
    public int id_pregunta;

    public ConParticipante() {

    }

    public int elegirCategoria() {
        ArrayList<ModCategoria> listacate = new ArrayList();

        ConCategoria consucategoria = new ConCategoria();

        listacate = consucategoria.consultaCategoria();

        Random aleatorio = new Random();
        int ramdomIndex = aleatorio.nextInt(listacate.size());

        return listacate.get(ramdomIndex).getIdCategoria();

        //for(int index = 0; index < listacate.size(); index ++){
        //System.out.println(listacate.get(index).getNombre());
        //}
    }

    public void mostrarCategoria(int id) {

        ArrayList<ModCategoria> listacate = new ArrayList();

        ConCategoria mostra = new ConCategoria();

        listacate = mostra.consultaCategoriaId(id);
        for (int index = 0; index < listacate.size(); index++) {
            message.NombreCategoria(listacate.get(index).getNombre());
        }
        // return listacate.get(id).getNombre();
    }


    public void MostrarPreguntas(int id_categoria, int id_nivel) {

        ArrayList<ModPreguntas> listapregunta = new ArrayList();
        ConPreguntas preguntas = new ConPreguntas();

        listapregunta = preguntas.consultaPregunta(id_categoria, id_nivel);

        for (int index = 0; index < listapregunta.size(); index++) {
            message.MostrarPreguntas(listapregunta.get(index).getNombre());
            this.id_pregunta = listapregunta.get(index).getId_preguntas();
        }
    }

    public void MostrarOpciones(int id_pregunta) {

        ArrayList<ModRepuestas> listaRespuestas = new ArrayList();
        ConRespuestas respu = new ConRespuestas();

        for (int index = 0; index < listaRespuestas.size(); index++) {
            message.MostrarPreguntas(listaRespuestas.get(index).getOpcion());
        }
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


}
