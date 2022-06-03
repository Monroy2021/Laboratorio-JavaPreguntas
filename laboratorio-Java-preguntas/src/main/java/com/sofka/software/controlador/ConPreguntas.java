package com.sofka.software.controlador;

import com.sofka.software.conexion.Conexion;
import com.sofka.software.modelo.ModPreguntas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConPreguntas {
    static ConsultaDB_mensajes message = ConsultaDB_mensajes.getInstance();

    public ArrayList<ModPreguntas> consultaPregunta(int id_categoria, int id_nivel) {
        Conexion con = new Conexion();
        ArrayList<ModPreguntas> listapregun = new ArrayList();
        String sql = "SELECT * FROM preguntas WHERE id_categoria = '" + id_categoria + "' and id_nivel = '" + id_nivel + "' ";
        ResultSet rs;
        try {
            rs = con.consultar(sql);
            while (rs.next()) {
                ModPreguntas pregun = new ModPreguntas();
                pregun.setId_preguntas(rs.getInt("id_preguntas"));
                pregun.setNombre(rs.getString("nombre"));
                pregun.setImg(rs.getString("img"));
                pregun.setId_categoria(rs.getInt("id_categoria"));
                pregun.setId_nivel(rs.getInt("id_nivel"));
                listapregun.add(pregun);
            }
        } catch (SQLException e) {
            e.printStackTrace();


            message.consultaError(String.valueOf(e));
        }
        return listapregun;
    }
}
