package com.sofka.software.controlador;

import com.sofka.software.conexion.Conexion;
import com.sofka.software.modelo.ModCategoria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConCategoria {

    static ConsultaDB_mensajes message = ConsultaDB_mensajes.getInstance();

    public ArrayList<ModCategoria> consultaCategoria() {
        Conexion con = new Conexion();
        ArrayList<ModCategoria> listacate = new ArrayList();
        String sql = "select * from categoria";
        ResultSet rs;
        try {
            rs = con.consultar(sql);
            while(rs.next()){
                ModCategoria cate = new ModCategoria();
                cate.setIdCategoria(rs.getInt("id_categoria"));
                cate.setNombre(rs.getString("nombre_categoria"));

                listacate.add(cate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message.consultaError(String.valueOf(e));
        }
        return listacate;
    }

    public ArrayList<ModCategoria> consultaCategoriaId(int id) {
        Conexion con = new Conexion();
        ArrayList<ModCategoria> listacateId = new ArrayList();
        String sql = "select * from categoria where id_categoria = '" + id + "'";
        ResultSet rs;
        try {
            rs = con.consultar(sql);
            while(rs.next()){
                ModCategoria cateid = new ModCategoria();
                cateid.setIdCategoria(rs.getInt("id_categoria"));
                cateid.setNombre(rs.getString("nombre_categoria"));
                listacateId.add(cateid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message.consultaError(String.valueOf(e));
        }
        return listacateId;
    }
}
