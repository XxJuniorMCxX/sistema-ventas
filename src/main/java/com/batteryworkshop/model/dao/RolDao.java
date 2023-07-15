package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.interfaces.CRUD;
import com.batteryworkshop.model.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author JuniorMiguel
 */
public class RolDao implements CRUD {

    //manipular el acceso de datos al modelo
    //conexcion ha sido un exito o un error
    Conexion estado = new Conexion();
    Connection con;
    //prepara toda la consulta que enviamos por java
    PreparedStatement ps;
    //trae todos los resultados que hayamos consultado en la consulta
    ResultSet rs;
    //poder ejecutar una  consulta
    String sql = "";
    //object puede almacenar cualquier tipo de datos numero,cadenas,booleanos,y de tipo objeto(Rol)
    //parse implicito son los que no existen (int)-- explicito strings
    @Override
    public List<Object> listar() {

        //nos trae toda la lista de la tabla rol
        List lista = new ArrayList<>();
        sql = "select *from rol Order By descripcion desc";
        try {
            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //pregunta si aún hay regitros 
            while (rs.next()) {
                //formas de imprimer los datos metodos set y get
//                Rol rol = new Rol();
//                rol.setRolId(rs.getInt(1));
//                rol.setDescripcion(rs.getString(2));
//                lista.add(rol);
//                
//                //2do con los constructores
//                 rol = new Rol(rs.getInt(1), rs.getString(2));
//                 lista.add(rol);

                //3ro 
                lista.add(new Rol(rs.getInt(1),
                        rs.getString(2)));

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
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }

        return lista;
    }

    @Override
    public void registrar(Object obj) throws Exception {
        Rol rol = (Rol) obj;
        sql = "insert into rol(descripcion) values(?);";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, rol.getDescripcion());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Ya existe El rol");
        } catch (Exception p) {
            p.printStackTrace(System.err);
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
        Rol rol = (Rol) obj;
        sql = "update rol set descripcion=? where rolId=?;";
        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, rol.getDescripcion());
            ps.setInt(2, rol.getRolId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Ya existe El rol");
        } catch (Exception p) {
            p.printStackTrace(System.err);
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
        sql = "delete from rol where rolID = " + (int) obj;
        try {
            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("No Se Puede Eliminar Este rol Pertenece a un Usuario");
        } catch (Exception p) {
            p.printStackTrace(System.err);
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
        sql = "select * from rol where rolID = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                return new Rol(
                        rs.getInt(1),
                        rs.getString(2)
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

        return new Rol();
    }

    @Override
    public List<Object> listar(Object obj) {

         List lista = new ArrayList();
        sql = "select * from rol where descripcion  like '%"+obj.toString()+"%'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                          
                lista.add(new Rol(
                        rs.getInt(1),
                        rs.getString(2)
                ));
                
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
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
    
    public Object obtenerObjecto(String descripcion) {
        
        sql = "select * from rol where descripcion = '"+descripcion+"'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                          
                return new Rol(
                        rs.getInt(1),
                        rs.getString(2)
                );
                
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
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

        return new Rol();
    }

}
