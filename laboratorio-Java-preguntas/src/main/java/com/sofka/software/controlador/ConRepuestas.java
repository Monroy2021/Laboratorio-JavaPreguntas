package com.sofka.software.controlador;

import com.sofka.software.conexion.Conexion;
import com.sofka.software.modelo.ModRepuestas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConRepuestas {

    static ConsultaDB_mensajes message = ConsultaDB_mensajes.getInstance();

    public ArrayList<ModRepuestas> consultaRepuestas(int id_preguntas){
        Conexion con = new Conexion();
        ArrayList<ModRepuestas> listaRepuesta = new ArrayList();
        String sql = "select * from respuestas where id_preguntas = '" + id_preguntas + "'";
        ResultSet rs;
        try{
            rs = con.consultar(sql);
            while(rs.next()){
                ModRepuestas modrepuestas = new ModRepuestas();
                modrepuestas.setIdRepuestas(rs.getInt("id_respuestas"));
                modrepuestas.setOpcion(rs.getString("opcion"));
                modrepuestas.setValorBooleano(rs.getBoolean("valor_booleano"));
                modrepuestas.setIdPreguntas(rs.getInt("id_preguntas"));
                listaRepuesta.add(modrepuestas);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            message.consultaError(String.valueOf(e));
        }
        return listaRepuesta;
    }
}
