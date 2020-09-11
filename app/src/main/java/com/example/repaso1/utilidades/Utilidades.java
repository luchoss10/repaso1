package com.example.repaso1.utilidades;

public class Utilidades {

    //Constantes, o nombres dde los campos de la tabla usuario.

    public  static final String TABLA_USUARIO="usuario";
    public  static final String CAMPO_ID="id";
    public  static final String CAMPO_NOMBRE="nombre";
    public  static final String CAMPO_TELEFONO="telefono";


    //Script para crear la tabla.
    public  static String CREAR_TABLA_USUARIO="CREATE TABLE "+ TABLA_USUARIO + " ("+CAMPO_ID+ "INTEGER, "+CAMPO_NOMBRE+"TEXT,"+CAMPO_TELEFONO +"TEXT)";

}
