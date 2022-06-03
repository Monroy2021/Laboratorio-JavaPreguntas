package com.sofka.software;

import com.sofka.software.conexion.Conexion;
import com.sofka.software.controlador.ConCategoria;
import com.sofka.software.modelo.ModCategoria;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        Object conexion = Conexion.getConnection();

        System.out.println(conexion);

        ConCategoria categoria = new ConCategoria();

        ArrayList<ModCategoria> listaCategorias = new ArrayList();
        ArrayList<ModCategoria> listaCategoriaId = new ArrayList();

        /*listaCategorias = categoria.consultaCategoria();
        for (int i = 0; i < listaCategorias.size(); i++) {
            System.out.println(listaCategorias.get(i).getNombre());
            System.out.println(listaCategorias.get(i).getIdCategoria());
        }*/

        listaCategoriaId = categoria.consultaCategoriaId(5);
        for (int i = 0; i < listaCategoriaId.size(); i++) {
            System.out.println(listaCategoriaId.get(i).getNombre());
            System.out.println(listaCategoriaId.get(i).getIdCategoria());
        }

        lecturas scanner = new lecturas();
        scanner.getChar();
    }
}