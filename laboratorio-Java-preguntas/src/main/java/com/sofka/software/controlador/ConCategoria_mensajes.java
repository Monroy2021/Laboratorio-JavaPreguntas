package com.sofka.software.controlador;

import com.sofka.software.conexion.conexion_mensajes;
import org.jboss.logging.Logger;

public class ConCategoria_mensajes {

    private static final Logger logger = Logger.getLogger(ConCategoria_mensajes.class);

    public static ConCategoria_mensajes getInstance() {
        return new ConCategoria_mensajes();
    }

    public void consultaError(String e) {
        logger.info("Error en la consulta : " + e);
    }
}
