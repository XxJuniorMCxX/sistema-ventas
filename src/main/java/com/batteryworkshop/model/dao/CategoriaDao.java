package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.interfaces.CRUD;
import com.batteryworkshop.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuniorMiguel
 */
public class CategoriaDao implements CRUD {

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

    @Override
    public List<Object> listar() {

        //nos trae toda la lista de la tabla categoria
        List lista = new ArrayList<>();
        sql = "select *from categoria Order By descripcion desc";
        try {
            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //pregunta si aún hay regitros 
            while (rs.next()) {
                //formas de imprimer los datos metodos set y get
//                Categoria categoria = new Categoria();
//                categoria.setCategoriaId(rs.getInt(1));
//                categoria.setDescripcion(rs.getString(2));
//                lista.add(categoria);
//                
//                //2do con los constructores
//                 categoria = new Categoria(rs.getInt(1), rs.getString(2));
//                 lista.add(categoria);

                //3ro 
                lista.add(new Categoria(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));

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
        Categoria categoria = (Categoria) obj;
        sql = "insert into categoria(descripcion) values(?);";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoria.getDescripcion());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Ya existe La Categoria");
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
        Categoria categoria = (Categoria) obj;
        sql = "update categoria set descripcion=? where categoriaId=?;";
        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoria.getDescripcion());        
            ps.setInt(2, categoria.getCategoriaId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Ya existe La Categoria");
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
        sql = "delete from categoria where categoriaId = " + (int) obj;
        try {
            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("No Se Puede Eliminar Esta Categoria ");
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
        sql = "select * from categoria where categoriaId = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                return new Categoria(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                        
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

        return new Categoria();
    }

    @Override
    public List<Object> listar(Object obj) {

         List lista = new ArrayList();
        sql = "select * from categoria where descripcion  like '%"+obj.toString()+"%'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                          
                lista.add(new Categoria(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
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
        
        sql = "select * from categoria where descripcion = '"+descripcion+"'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                          
                return new Categoria(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
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

        return new Categoria();
    }

}
