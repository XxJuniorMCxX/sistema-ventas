/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.batteryworkshop.interfaces;

import java.util.List;

/**
 *
 * @author JuniorMiguel
 */
public interface CRUD {
    public List<Object> listar() throws Exception;
    
    public void registrar(Object obj) throws Exception;
    
    public void editar(Object obj) throws Exception;
    
    public void eliminar(Object obj) throws Exception;
    
    public Object obtenerObjecto(Object obj) throws Exception;
    
    public List<Object> listar(Object obj) throws Exception;
    
    
}
