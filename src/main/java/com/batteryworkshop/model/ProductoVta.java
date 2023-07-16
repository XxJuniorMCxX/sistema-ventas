/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.batteryworkshop.model;

/**
 *
 * @author JuniorMiguel
 */
public class ProductoVta {

    private Producto producto;
    private int cantidad;

    public ProductoVta() {
    }

    public ProductoVta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoVta{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }

    

}
