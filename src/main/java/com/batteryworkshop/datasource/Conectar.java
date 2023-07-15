package com.batteryworkshop.datasource;

import com.batteryworkshop.model.Rol;
import com.batteryworkshop.model.dao.RolDao;
import java.util.List;

public class Conectar {

    public static void main(String[] args) {

//        Conexion cnn = new Conexion();
//        cnn.Conectar();
        //Mostrar consultas de prueba
//        RolDao rolC = new RolDao();
//        List lista = rolC.listar();
//        Rol rol;
//        for (int i = 0; i < lista.size(); i++) {
//            rol = (Rol)lista.get(i);
//            System.out.println(rol.getRolId() + " " + rol.getDescripcion());
//        }
        //Pruebas capturar 1er y segundo nombre
        String nombre="junior";
        int indiceNombre=nombre.indexOf(" ");
        System.out.println("Indice Posicion N°: " + indiceNombre);
        System.out.println("Indice " + nombre.substring(0, indiceNombre));
        
    }
}
