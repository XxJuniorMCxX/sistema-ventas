package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.model.DetalleVenta;
import java.sql.*;

public class DetalleVentaDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public void registrar(Object obj, Conexion estado) {

        DetalleVenta detalleVenta = (DetalleVenta) obj;
        sql = "insert into detalleVenta(ventaID,productoID,precioVenta,cantidad,subTotal)\n"
                + "values(?,?,?,?,?)";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalleVenta.getVentaID());
            ps.setInt(2, detalleVenta.getProductoID().getProductoId());
            ps.setFloat(3, detalleVenta.getProductoID().getPrecioVenta());
            ps.setInt(4, detalleVenta.getCantidad());
            ps.setFloat(5, detalleVenta.getSubTotal());
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
