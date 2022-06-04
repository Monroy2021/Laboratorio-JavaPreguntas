package com.sofka.software;

import com.sofka.software.controlador.ConCategoria;
import com.sofka.software.controlador.ConParticipante;
import com.sofka.software.controlador.ConsultaDB_mensajes;
import com.sofka.software.modelo.ModCategoria;

import java.util.ArrayList;

public class Main {

    static ConsultaDB_mensajes message = ConsultaDB_mensajes.getInstance();

    public static void main(String[] args) {

        ConCategoria categoria = new ConCategoria();
        lecturas scanner = new lecturas();

        ArrayList<ModCategoria> listaCategorias = new ArrayList();
        ArrayList<ModCategoria> listaCategoriaId = new ArrayList();

        ConParticipante persona = new ConParticipante();
        boolean respuesta;
        do {
            int id = persona.elegirCategoria();
            persona.mostrarCategoria(id);
            //llamando los geter para tener el valor del nivel
            persona.MostrarPreguntas(id); // mostrar pregunta
            int idPre = persona.getId_pregunta();
            persona.MostrarOpciones(idPre);
            message.elegirOpcion();
            int opcionElegida = scanner.getInteger();
            int correctaIncorrecta = persona.verificarOpcion(idPre,opcionElegida);
            boolean correctaFalse = persona.validarOpcion(correctaIncorrecta);
            if(correctaFalse){
                persona.acumulado(persona.getNivel());
                respuesta = persona.preguntarSeguir();
            }else {
                respuesta = false;
            }
        }while (respuesta);

    }
}