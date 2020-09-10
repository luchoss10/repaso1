package com.example.repaso1.entidades;

//POJO, campos en la base de datos
public class Usuario {

    //Estructura de la tabla en la DB
    private  Integer id;
    private  String name;
    private  String telefono;

    public Usuario(Integer id, String name, String telefono) {
        this.id = id;
        this.name = name;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
