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

    public void DatosGuardados() {
        logger.info("Sus datos fueron guardados satisfactoriamente");
    }

    public void DatosNoGuardados() {
        logger.info("Error sus datos NO fueron guardados");
    }

    public void Acumulado(String e) {
        logger.info("Sus acumulado se almaceno en su usuario");
    }

    public void NoActualizados(String e) {
        logger.info("Error sus datos NO fueron actualizados");
    }

    public void NombreCategoria(String nombre) {
        logger.info(" " + nombre);
    }

    public void MostrarPreguntas(String nombre) {
        logger.info(" " + nombre);
    }

    public void opcionIncorrecta() {
        logger.info("La opcioón seleccionada es incorrecta ");
    }
    public void elegirOpcion(){
        logger.info("Seleccione la respuesta [1] [2] [3] [4]");
    }
    public void ganaste(){
        logger.info("Felicidades ganaste");
    }

    public void seguir(){
        logger.info("Deseas seguir digita [1] si, [2} No");
    }

    public void digitarNombre(){
        logger.info("Digite tu nombre");
    }

    public void digitarApellido(){
        logger.info("Digite tu apellido");
    }
    public void digitarCorreo(){
        logger.info("Digite tu correo");
    }

    public void verHistorico(){
        logger.info("Deseas ver el historico: [1] si, [2] no");
    }
    public void mostrarHistorico(String nombre, String acumulado){
        logger.info(nombre + " Acumulado " + acumulado);
    }

}
