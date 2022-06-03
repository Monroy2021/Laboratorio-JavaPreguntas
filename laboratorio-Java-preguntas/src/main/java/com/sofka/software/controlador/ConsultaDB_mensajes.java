package com.sofka.software.controlador;


import org.jboss.logging.Logger;

public class ConsultaDB_mensajes {

    private static final Logger logger = Logger.getLogger(ConsultaDB_mensajes.class);

    public static ConsultaDB_mensajes getInstance() {
        return new ConsultaDB_mensajes();
    }

    public void consultaError(String e) {
        logger.info("Error en la consulta : " + e);
    }

    public void ErrorGuardar(String e) {
        logger.info("Error en Guardar: " + e);
    }

    public void ErrorModificar(String e) {
        logger.info("Error en Modificar: " + e);
    }


}
