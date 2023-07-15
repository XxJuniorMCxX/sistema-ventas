package com.batteryworkshop.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String url = "jdbc:sqlserver://localhost:1433;database=BdProjectVentas";
    String user = "sa";
    String password = "juniorjm/3";
    public Connection Conectar() {
        Connection cnn = null;
        try {
            cnn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            System.out.println(e.getMessage());
            System.out.println("no se pudo realizar la conexion ");
            // Manejo de errores
        }
        return cnn;
    }
}
