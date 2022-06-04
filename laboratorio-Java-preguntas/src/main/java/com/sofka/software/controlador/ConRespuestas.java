package com.sofka.software.controlador;

import com.sofka.software.conexion.Conexion;
import com.sofka.software.modelo.ModRespuestas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConRespuestas {

    static ConsultaDB_mensajes message = ConsultaDB_mensajes.getInstance();

    public ArrayList<ModRespuestas> consultaRespuestas(int id_preguntas){
        Conexion con = new Conexion();
        ArrayList<ModRespuestas> listaRespuesta = new ArrayList();
        String sql = "select * from respuestas where id_preguntas = '" + id_preguntas + "'";
        ResultSet rs;
        try{
            rs = con.consultar(sql);
            while(rs.next()){
                ModRespuestas modrespuestas = new ModRespuestas();
                modrespuestas.setIdRespuestas(rs.getInt("id_respuestas"));
                modrespuestas.setOpcion(rs.getString("opcion"));
                modrespuestas.setValorBooleano(rs.getInt("valor_booleano"));
                modrespuestas.setIdPreguntas(rs.getInt("id_preguntas"));
                listaRespuesta.add(modrespuestas);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            message.consultaError(String.valueOf(e));
        }
        return listaRespuesta;
    }
}
