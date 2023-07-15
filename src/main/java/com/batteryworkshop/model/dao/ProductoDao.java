package com.batteryworkshop.model.dao;

import com.batteryworkshop.datasource.Conexion;
import com.batteryworkshop.interfaces.CRUD;
import com.batteryworkshop.model.Categoria;
import com.batteryworkshop.model.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao implements CRUD {

    CategoriaDao categoriaDao = new CategoriaDao();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM producto ORDER BY productoID DESC";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                lista.add(new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        (Categoria) categoriaDao.obtenerObjecto(rs.getInt(5)),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getFloat(8),
                        rs.getBoolean(9))
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

        Producto producto = (Producto) obj;
        sql = "insert into producto(codigo,nombre,descripcion,categoriaID,stock,precioCompra,precioVenta,estado)\n"
                + "values(?,?,?,?,?,?,?,?)";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getCategoria().getCategoriaId());
            ps.setInt(5, producto.getStock());
            ps.setFloat(6, producto.getPrecioCompra());
            ps.setFloat(7, producto.getPrecioVenta());
            ps.setBoolean(8, producto.isEstado());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El producto");
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

        Producto producto = (Producto) obj;
        sql = "update producto set codigo=?,nombre=?,descripcion=?,categoriaID=?,stock=?,precioCompra=?,"
                + "precioVenta=?,estado=?" + " where productoID = ?";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getNombre());
            ps.setInt(4, producto.getCategoria().getCategoriaId());
            ps.setInt(5, producto.getStock());
            ps.setFloat(6, producto.getPrecioCompra());
            ps.setFloat(7, producto.getPrecioVenta());
            ps.setBoolean(8, producto.isEstado());
            ps.setInt(9, producto.getProductoId());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El producto");
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
    
    public void editarStock(Object obj) throws Exception {

        Producto producto = (Producto) obj;
        sql = "update producto set stock=?" + " where codigo = ?";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);         
            ps.setInt(1, producto.getStock());           
            ps.setString(2, producto.getCodigo());
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("Ya existe El producto");
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

        sql = "delete from producto where productoID = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException pe) {
            throw new Exception("No se puede eliimnar  este producto ");
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

        sql = "select * from producto where productoID = " + (int) obj;

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                return new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        (Categoria) categoriaDao.obtenerObjecto(rs.getInt(5)),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getFloat(8),
                        rs.getBoolean(9)
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

        return new Producto();
    }
    
    public Object obtenerObjectoStock(Object obj) {

        sql = "select * from producto where codigo = '" + (String) obj+"'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                return new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        (Categoria) categoriaDao.obtenerObjecto(rs.getInt(5)),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getFloat(8),
                        rs.getBoolean(9)
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

        return new Producto();
    }

    @Override
    public List<Object> listar(Object obj) {

        List lista = new ArrayList();
        sql = "select * from producto \n"
                + "where codigo  like '%" + obj.toString() + "%' \n"
                + "or nombre like '%" + obj.toString() + "%' \n";
//                + "or apellidos like '" + obj.toString() + "%'";

        try {

            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        (Categoria) categoriaDao.obtenerObjecto(rs.getInt(5)),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getFloat(8),
                        rs.getBoolean(9)
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
