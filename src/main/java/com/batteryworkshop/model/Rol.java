/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.batteryworkshop.model;

/**
 *
 * @author JuniorMiguel
 */
public class Rol {
    private int rolId;
    private String descripcion;

    public Rol() {
    }

    public Rol(int rolId) {
        this.rolId = rolId;
    }

    public Rol(int rolId, String descripcion) {
        this.rolId = rolId;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
}
