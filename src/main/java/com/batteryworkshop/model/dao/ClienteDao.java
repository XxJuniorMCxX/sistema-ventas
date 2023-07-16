package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.interfaces.CRUD;
import com.batteryworkshop.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar() {

        List lista = new ArrayList<>();
        sql = "SELECT * FROM cliente ORDER BY clienteID DESC";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7))
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

        Cliente cliente = (Cliente) obj;
        sql = "insert into cliente(dni,nombres,apellidos,correo,telefono,estado)\n"
                + "values(?,?,?,?,?,?)";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getTelefono());
            ps.setBoolean(6, cliente.isEstado());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El cliente");
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

        Cliente cliente = (Cliente) obj;
        sql = "update cliente set dni=?,nombres=?,apellidos=?,correo=?,telefono=?,estado=?"
                + " where clienteID = ?";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getTelefono());
            ps.setBoolean(6, cliente.isEstado());
            ps.setInt(7, cliente.getClienteId());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El cliente");
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

        sql = "delete from cliente where clienteID = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("No se puede eliimnar  este cliente");
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

        sql = "select * from cliente where clienteID = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                return new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7)
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

        return new Cliente();
    }

    public Cliente obtenerObjectoDni(String dni) {

        Cliente clienteObt = new Cliente();
        sql = "select * from cliente where dni = '" + dni + "'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                clienteObt.setClienteId(rs.getInt(1));
                clienteObt.setDocumento(rs.getString(2));
                clienteObt.setNombres(rs.getString(3));
                clienteObt.setApellidos(rs.getString(4));
                clienteObt.setCorreo(rs.getString(5));
                clienteObt.setTelefono(rs.getString(6));
                clienteObt.setEstado(rs.getBoolean(7));
               

            }else{
                return null;
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

         return clienteObt;
    }

    @Override
    public List<Object> listar(Object obj) {

        List lista = new ArrayList();
        sql = "select * from cliente \n"
                + "where dni  like '%" + obj.toString() + "%' \n"
                + "or nombres like '%" + obj.toString() + "%' \n"
                + "or apellidos like '" + obj.toString() + "%'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7)
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
