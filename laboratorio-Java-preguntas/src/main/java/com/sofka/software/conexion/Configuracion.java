package com.sofka.software.conexion;

public interface Configuracion {
    String DRIVER = "com.mysql.jdbc.Driver";
    String DATA_BASE = "concurso_respuestas";
    String CONNECTION_URL = "jdbc:mysql://localhost:3306/" + DATA_BASE;
    String USERNAME = "root";
    String PASSWORD = "";
}
