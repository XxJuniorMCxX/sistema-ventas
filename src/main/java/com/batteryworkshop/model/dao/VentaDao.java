package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.model.Venta;
import java.sql.*;

public class VentaDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public int registrar(Object obj, Conexion estado) {

        int idGenerado = 0;
        Venta venta = (Venta) obj;
        sql = "insert into venta(usuarioId,tipoDocumento,documentoCliente,nombreCliente,montoPago,montoCambio,fechaVenta)\n"
                + "values(?,?,?,?,?,?,?)";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getUsuario().getUsuarioId());
            ps.setString(2, venta.getTipoDocumento());
            ps.setString(3, venta.getCliente().getDocumento());
            ps.setString(4, venta.getCliente().getNombres().toUpperCase()
                    .concat(" ").concat(venta.getCliente().getApellidos().toUpperCase()));
            ps.setFloat(5, venta.getMontoPago());
            ps.setFloat(6, venta.getMontoCambio());
            ps.setDate(7, (Date) venta.getFechaVenta());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
                System.out.println("ID generado: " + idGenerado);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
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

        return idGenerado;
    }

}
