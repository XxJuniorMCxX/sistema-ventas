
package com.batteryworkshop.model;

import java.util.Date;

/**
 *
 * @author JuniorMiguel
 */
public class Venta {

    private int ventaId;
    private Usuario usuario;
    private String tipoDocumento;
    private Cliente cliente;
    private Float montoPago;
    private Float montoCambio;
    private Date fechaVenta;

    public Venta() {
    }

    public Venta(int ventaId, Usuario usuario, String tipoDocumento, Cliente cliente, Float montoPago, Float montoCambio, Date fechaVenta) {
        this.ventaId = ventaId;
        this.usuario = usuario;
        this.tipoDocumento = tipoDocumento;
        this.cliente = cliente;
        this.montoPago = montoPago;
        this.montoCambio = montoCambio;
        this.fechaVenta = fechaVenta;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Float montoPago) {
        this.montoPago = montoPago;
    }

    public Float getMontoCambio() {
        return montoCambio;
    }

    public void setMontoCambio(Float montoCambio) {
        this.montoCambio = montoCambio;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

}
