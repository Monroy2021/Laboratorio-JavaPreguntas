package com.sofka.software;

import java.util.Scanner;

public  class lecturas {

    /**
     * creacion del Objecto protejido como constante para
     * el scanneer
     */
    protected static final Scanner scanneer = new Scanner(System.in);

    /**
     * Metodo para capturar datos de tipo int (Integer)
     *
     * @return retorna el capturador
     */
    public Integer getInteger() {
        return Integer.parseInt(scanneer.nextLine());
    }

    /**
     * Metodo para capturar datos de tipo double
     *
     * @return retorna el capturador
     */
    public Double getDouble() {
        return Double.parseDouble(scanneer.nextLine());
    }

    /**
     * Metodo para capturar datos de tipo char
     *
     * @return retorna el capturador
     */
    public char getChar() {
        return scanneer.nextLine().charAt(0);
    }

    /**
     * Metodo abstracto para crearle el cuerpo desde
     * la subclase que hereda
     */
    public  String getString(){
       return scanneer.nextLine();
    };

    /**
     * Metodo para cerrar el scanner abierto
     */
    public void close() {
        scanneer.close();
    }

}

