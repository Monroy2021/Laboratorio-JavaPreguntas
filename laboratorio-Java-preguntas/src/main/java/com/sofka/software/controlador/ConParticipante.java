package com.sofka.software.controlador;

import com.sofka.software.lecturas;
import com.sofka.software.modelo.ModCategoria;
import com.sofka.software.modelo.ModPreguntas;
import com.sofka.software.modelo.ModRespuestas;
import com.sofka.software.modelo.ModUsuario;

import java.util.ArrayList;
import java.util.Random;

public class ConParticipante {
    static ConsultaDB_mensajes message = ConsultaDB_mensajes.getInstance();
    lecturas scanner = new lecturas();
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


    public void MostrarPreguntas(int id_categoria) {

        ArrayList<ModPreguntas> listapregunta = new ArrayList();
        ConPreguntas preguntas = new ConPreguntas();

        listapregunta = preguntas.consultaPregunta(id_categoria, this.nivel);

        for (int index = 0; index < listapregunta.size(); index++) {
            message.MostrarPreguntas(listapregunta.get(index).getNombre());
        }
        this.id_pregunta = listapregunta.get(0).getId_preguntas();
    }

    public void MostrarOpciones(int id_pregunta) {

        ArrayList<ModRespuestas> listaRespuestas = new ArrayList();
        ConRespuestas respu = new ConRespuestas();
        listaRespuestas = respu.consultaRespuestas(id_pregunta);

        for (int index = 0; index < listaRespuestas.size(); index++) {
            message.MostrarPreguntas(listaRespuestas.get(index).getOpcion());
            message.MostrarPreguntas(String.valueOf(listaRespuestas.get(index).getValorBooleano()));
        }
    }

    public int verificarOpcion(int id_pregunta, int value) {
        int validar = 3;
        ArrayList<ModRespuestas> listaRespuestas = new ArrayList();
        ConRespuestas respu = new ConRespuestas();
        listaRespuestas = respu.consultaRespuestas(id_pregunta);

        switch (value) {
            case 1: {
                validar = listaRespuestas.get(0).getValorBooleano();
                break;
            }
            case 2: {
                validar = listaRespuestas.get(1).getValorBooleano();
                break;
            }
            case 3: {
                validar = listaRespuestas.get(2).getValorBooleano();
                break;
            }
            case 4: {
                validar = listaRespuestas.get(3).getValorBooleano();
                break;
            }
            default: {
                message.opcionIncorrecta();
            }
        }
        return validar;
    }

    public boolean validarOpcion(int validar) {
        if (validar == 1) {
            validarNivel();
            return true;
        }
        return false;
    }

    public boolean validarNivel() {
        if (getNivel() < 5) {
            nivel++;
            return true;
        } else {
            message.ganaste();
            nivel = 1;
            acumulado = "0";
            almacenarAcumulado();
            message.verHistorico();
            int ver = scanner.getInteger();
            if(ver == 1){
                mostrarHistorico();
            }
        }
        return false;
    }

    public void acumulado(int nivel) {
        switch (nivel) {
            case 1:
                this.acumulado = "0";
                break;
            case 2:
                this.acumulado = "500000";
                break;
            case 3:
                this.acumulado = "1500000";
                break;
            case 4:
                this.acumulado = "5000000";
                break;
            case 5:
                this.acumulado = "20000000";
                break;
            default:
                this.acumulado = "0";
        }
    }

    public void almacenarAcumulado() {
        ConUsuario conusuario = new ConUsuario();
        ModUsuario modusuario = new ModUsuario();
        message.digitarNombre();
        String nombre = scanner.getString();
        message.digitarApellido();
        String apellido = scanner.getString();
        message.digitarCorreo();
        String correo = scanner.getString();
        modusuario.setNombre(nombre);
        modusuario.setApellido(apellido);
        modusuario.setCorreo(correo);
        modusuario.setAcumulado(getAcumulado());
        conusuario.guardar(modusuario);
    }

    public void mostrarHistorico() {
        ArrayList<ModUsuario> listaUsuario = new ArrayList();
        ConUsuario usuario = new ConUsuario();
        listaUsuario = usuario.consultUsuario();
        for (int index = 0; index < listaUsuario.size(); index++) {
            message.mostrarHistorico(listaUsuario.get(index).getNombre(),
                    listaUsuario.get(index).getAcumulado());
        }
    }

    public boolean preguntarSeguir() {
        message.seguir();
        int seguir = scanner.getInteger();
        if (seguir == 1) {
            return true;
        }
        almacenarAcumulado();
        message.verHistorico();
        int ver = scanner.getInteger();
        if(ver == 1){
            mostrarHistorico();
        }
        return false;
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

    public String getAcumulado() {
        return acumulado;
    }
}
