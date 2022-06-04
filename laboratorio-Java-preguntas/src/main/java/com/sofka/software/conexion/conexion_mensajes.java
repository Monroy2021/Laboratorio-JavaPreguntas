package com.sofka.software.conexion;

import org.jboss.logging.Logger;

public class conexion_mensajes {

    private static final Logger logger = Logger.getLogger(conexion_mensajes.class);

    public static conexion_mensajes getInstance() {
        return new conexion_mensajes();
    }

    public void exitosa() {
        logger.info("Conexion exitosa:");
    }

    public void fallida() {
        logger.info("Conexion fallida:");
    }

    public void Error(String e) {
        logger.info("Error en conexión : " + e);
    }

    public void Desconectado() {
        logger.info("Desconectado: ");
    }

    public void Cerrar(String e) {
        logger.info("Desconectado:" + e);
    }

    public void ejecución(String e) {
        logger.info("Error en ejecución :" + e);
    }

    public void consulta(String e) {
        logger.info("Error en la consulta :" + e);
    }

}
