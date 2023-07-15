/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.batteryworkshop.model;

/**
 *
 * @author JuniorMiguel
 */
public class Proveedor {
    private int proveedorId;
    private String documento;
    private String razonSocial;
    private String correo;
    private String telefono;
    private boolean estado;

    public Proveedor() {
    }

    public Proveedor(int proveedorId, String documento, String razonSocial, String correo, String telefono, boolean estado) {
        this.proveedorId = proveedorId;
        this.documento = documento;
        this.razonSocial = razonSocial;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   
}
