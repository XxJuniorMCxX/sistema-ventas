/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.batteryworkshop.model;

//Pilares de la Programacion abstraccion,polimorfismo,encapsulamiento,herencia
/**
 *
 * @author JuniorMiguel
 */
public class Permiso {
    private int permisoId;
    private String desripcion;

    public Permiso() {
    }

    public Permiso(int permisoId) {
        this.permisoId = permisoId;
    }
    
    public Permiso(int permisoId, String desripcion) {
        this.permisoId = permisoId;
        this.desripcion = desripcion;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }

    public int getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(int permisoId) {
        this.permisoId = permisoId;
    }
    
    
}
