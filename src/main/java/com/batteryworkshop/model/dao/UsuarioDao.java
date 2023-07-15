package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.interfaces.CRUD;
import com.batteryworkshop.model.Rol;
import com.batteryworkshop.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements CRUD {

    RolDao rolC = new RolDao();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM usuario WHERE estado=1 ORDER BY usuarioID DESC";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getDate(9),
                        (Rol) rolC.obtenerObjecto(rs.getInt(10)))
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

        Usuario usuario = (Usuario) obj;
        sql = "insert into usuario(documento,nombres,apellidos,correo,clave,telefono,estado,fechaNacimiento,rolID)\n"
                + "values(?,?,?,?,?,?,?,?,?)";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getDocumento());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getClave());
            ps.setString(6, usuario.getTelefono());
            ps.setBoolean(7, usuario.isEstado());
            ps.setDate(8, usuario.getFechaNacimiento());
            ps.setInt(9, usuario.getRol().getRolId());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El usuario");
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

        Usuario usuario = (Usuario) obj;
        sql = "update usuario set documento=?,nombres=?,apellidos=?,correo=?,clave=?,telefono=?,fechaNacimiento=?,rolID=?"
                + " where usuarioID = ?";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getDocumento());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getClave());
            ps.setString(6, usuario.getTelefono());
//            ps.setBoolean(7, usuario.isEstado());
            ps.setDate(7, usuario.getFechaNacimiento());
            ps.setInt(8, usuario.getRol().getRolId());
            ps.setInt(9, usuario.getUsuarioId());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El usuario");
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

        sql = "DELETE FROM usuario where usuarioID ="+ (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("No se puede eliimnar porque este usuario lo tiene un usuario");
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

        sql = "select * from usuario where usuarioID = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                return new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getDate(9),
                        (Rol) rolC.obtenerObjecto(rs.getInt(10))
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

        return new Usuario();
    }

    @Override
    public List<Object> listar(Object obj) {

        List lista = new ArrayList();
        sql = "select * from usuario \n"
                + "where documento  like '%" + obj.toString() + "%' \n"
                + "or nombres like '%" + obj.toString() + "%' \n"
                + "or apellidos like '" + obj.toString() + "%'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getDate(9),
                        (Rol) rolC.obtenerObjecto(rs.getInt(10))
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

    public Object iniciarSesion(String documento, String clave) {

        sql = "select * from usuario where estado=1 AND documento = '" + documento + "' and clave = '" + clave + "'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                return new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getDate(9),
                        (Rol) rolC.obtenerObjecto(rs.getInt(10))
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

        return new Usuario();
    }

}
