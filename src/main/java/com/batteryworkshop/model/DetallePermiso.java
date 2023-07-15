/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.batteryworkshop.model;

import java.util.List;

/**
 *
 * @author JuniorMiguel
 */
public class DetallePermiso {
    private Rol rol;
    private List<Permiso> permiso;

    public DetallePermiso() {
    }

    public DetallePermiso(Rol rol) {
        this.rol = rol;
    }
    
    public DetallePermiso(Rol rol, List<Permiso> permiso) {
        this.rol = rol;
        this.permiso = permiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Permiso> getPermiso() {
        return permiso;
    }

    public void setPermiso(List<Permiso> permiso) {
        this.permiso = permiso;
    }
    
}