package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.interfaces.CRUD;
import com.batteryworkshop.model.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDao implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar() {

        List lista = new ArrayList<>();
        sql = "SELECT * FROM proveedor ORDER BY proveedorID DESC";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Proveedor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6))
                );

            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

        return lista;
    }

    @Override
    public void registrar(Object obj) throws Exception {

        Proveedor proveedor = (Proveedor) obj;
        sql = "insert into proveedor(dni,razonSocial,correo,telefono,estado)\n"
                + "values(?,?,?,?,?)";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getDocumento());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getCorreo());
            ps.setString(4, proveedor.getTelefono());
            ps.setBoolean(5, proveedor.isEstado());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El proveedor");
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

    }

    @Override
    public void editar(Object obj) throws Exception {

        Proveedor proveedor = (Proveedor) obj;
        sql = "update proveedor set dni=?,razonSocial=?,correo=?,telefono=?,estado=?"
                + " where proveedorID = ?";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getDocumento());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getCorreo());
            ps.setString(4, proveedor.getTelefono());
            ps.setBoolean(5, proveedor.isEstado());
            ps.setInt(6, proveedor.getProveedorId());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El proveedor");
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

    }

    @Override
    public void eliminar(Object obj) throws Exception {

        sql = "delete from proveedor where proveedorID = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("No se puede eliimnar  este proveedor");
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

    }

    @Override
    public Object obtenerObjecto(Object obj) {

        sql = "select * from proveedor where proveedorID = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                return new Proveedor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6)
                );

            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

        return new Proveedor();
    }

    @Override
    public List<Object> listar(Object obj) {

        List lista = new ArrayList();
        sql = "select * from proveedor \n"
                + "where dni  like '%" + obj.toString() + "%' \n"
                + "or razonSocial like '%" + obj.toString() + "%' \n";
//                + "or apellidos like '" + obj.toString() + "%'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Proveedor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6)
                ));

            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

        return lista;

    }

}
