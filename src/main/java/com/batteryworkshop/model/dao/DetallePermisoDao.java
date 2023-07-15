/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.model.DetallePermiso;
import com.batteryworkshop.model.Permiso;
import com.batteryworkshop.model.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuniorMiguel
 */
public class DetallePermisoDao {
    RolDao rolC = new RolDao();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetallePermiso listar(String documento) {
         DetallePermiso detalleP = new DetallePermiso();
        List permisos = new ArrayList();
        sql = "select r.rolId,pe.permisoId,pe.descripcion from usuario us \n"
                + "inner join rol r ON us.rolId = r.rolId \n"
                + "inner join detallePermiso det on det.rolId = r.rolId \n"
                + "inner join permiso pe on pe.permisoId = det.permisoId \n"
                + "where us.documento = '" + documento + "'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleP.setRol((Rol) rolC.obtenerObjecto(rs.getInt(1)));
                permisos.add(new Permiso(rs.getInt(2), rs.getString(3)));
            }
            detalleP.setPermiso(permisos);

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

        return detalleP;

    }

    public DetallePermiso listar(int idRol) {

        DetallePermiso detalleP = new DetallePermiso();
        List lista = new ArrayList<>();
        sql = "SELECT * FROM detallePermiso WHERE rolID = " + idRol;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleP.setRol(new Rol(rs.getInt(1)));
                lista.add(new Permiso(rs.getInt(2)));
            }
            detalleP.setPermiso(lista);

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

        return detalleP;

    }

    public void registrarPermiso(int rol, int permiso) {

        sql = "insert into detallePermiso values(?,?)";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, rol);
            ps.setInt(2, permiso);
            ps.executeUpdate();

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
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

    }

    public void eliminarPermisos(int idRol) {

        sql = "delete from detallepermiso where rolID = " + idRol;
        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

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
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

    }

}
