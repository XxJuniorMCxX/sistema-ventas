/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.batteryworkshop.model;

/**
 *
 * @author JuniorMiguel
 */
public class DetalleVenta {
    
    private int detalleVentaID;
    private int ventaID;
    private Producto productoID;
    private int cantidad;
    private float subTotal; 

    public DetalleVenta() {
    }

    public DetalleVenta(int detalleVentaID, int ventaID, Producto productoID, int cantidad, float subTotal) {
        this.detalleVentaID = detalleVentaID;
        this.ventaID = ventaID;
        this.productoID = productoID;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }
 
    
    public int getDetalleVentaID() {
        return detalleVentaID;
    }

    public void setDetalleVentaID(int detalleVentaID) {
        this.detalleVentaID = detalleVentaID;
    }

    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public Producto getProductoID() {
        return productoID;
    }

    public void setProductoID(Producto productoID) {
        this.productoID = productoID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "detalleVentaID=" + detalleVentaID + ", ventaID=" + ventaID + ", productoID=" + productoID + ", cantidad=" + cantidad + ", subTotal=" + subTotal + '}';
    }
    
    
        
}
