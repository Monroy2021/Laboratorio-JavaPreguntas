package com.sofka.software.controlador;

import com.sofka.software.conexion.Conexion;
import com.sofka.software.modelo.ModUsuario;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ConUsuario {

    static ConsultaDB_mensajes message = ConsultaDB_mensajes.getInstance();

    public void guardar(ModUsuario usuario) {
        Logger logger = Logger.getLogger("log");
        String sql = "insert into jugador(nombre,apellido,correo,acumulado)"
                + "values ('" + usuario.getNombre() + "','" + usuario.getApellido() + "','" + usuario.getCorreo() + "'," + usuario.getAcumulado() + ")";
        Conexion con = new Conexion();
        try {
            if (con.ejecutar(sql)) {
                logger.info("Sus datos fueron guardados satisfactoriamente");

            } else {
                logger.info("Error sus datos NO fueron guardados");

            }

        } catch (Exception e) {
            e.printStackTrace();
            message.ErrorGuardar(String.valueOf(e));
        }
    }

    public ArrayList<ModUsuario> consultUsuario() {
        Conexion con = new Conexion();
        ArrayList<ModUsuario> listausuario = new ArrayList();
        String sql = "select * from jugador";
        ResultSet rs;
        try {
            rs = con.consultar(sql);
            while (rs.next()) {
                ModUsuario modusuario = new ModUsuario();
                modusuario.setId_jugador(rs.getInt("id_jugador"));
                modusuario.setNombre(rs.getString("nombre"));
                modusuario.setApellido(rs.getString("apellido"));
                modusuario.setCorreo(rs.getString("correo"));
                modusuario.setAcumulado(rs.getString("acumulado"));
                listausuario.add(modusuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();

            message.consultaError(String.valueOf(e));

        }
        return listausuario;
    }

    public ModUsuario consultUsuario(int id_usuario) {
        Conexion con = new Conexion();
        ModUsuario modusuario = new ModUsuario();
        ConUsuario conusuario = new ConUsuario();
        String sql = "select * from jugador where id_jugador=" + id_usuario;
        ResultSet rs;
        try {
            rs = con.consultar(sql);
            if (rs.next()) {
                modusuario.setId_jugador(rs.getInt("id_jugador"));
                modusuario.setNombre(rs.getString("nombre"));
                modusuario.setApellido(rs.getString("apellido"));
                modusuario.setCorreo(rs.getString("correo"));
                modusuario.setAcumulado(rs.getString("acumulado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message.consultaError(String.valueOf(e));

        }
        return modusuario;
    }

    public void modificar(int id_usuario, String acumulado) {

        Logger logger = Logger.getLogger("log");
        String sql = "update jugador set acumulado='" + acumulado + "'" + "where id_jugador = " + id_usuario;
        Conexion con = new Conexion();
        try {
            if (con.ejecutar(sql)) {

                logger.info("Sus acumulado se almaceno en su usuario");

            } else {
                logger.info("Error sus datos NO fueron actualizados");
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.ErrorModificar(String.valueOf(e));

        }
    }
}
