/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.batteryworkshop.view;

import com.batteryworkshop.model.DetallePermiso;
import com.batteryworkshop.model.Permiso;
import com.batteryworkshop.model.Usuario;
import com.batteryworkshop.model.dao.DetallePermisoDao;
import com.batteryworkshop.view.modal.FrmActualizarStock;
import com.batteryworkshop.view.modal.FrmDetallePedido;
import com.batteryworkshop.view.modal.FrmDetalleVenta;
import com.batteryworkshop.view.modal.FrmRegistrarCategoria;
import com.batteryworkshop.view.modal.FrmRegistrarPedido;
import com.batteryworkshop.view.modal.FrmRegistrarProducto;
import com.batteryworkshop.view.modal.FrmRegistrarVenta;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author JuniorMiguel
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {
    DetallePermisoDao dpC= new DetallePermisoDao();
    public static Usuario usuario;//static para navegar de ventana a ventana y enviar datos

    /**
     * Creates new form FrmPrincipal
     */
    public FrmMenuPrincipal() {
        initComponents();
//        mnuUsuario.setText(usuario.getNombres());
        this.setExtendedState(6);
        desabilitar_menu();
        cargar_permisos();
        cargarUsuario();
        
    }
//hacer que aparesca el nombre del usuario en el menu principal mnnuUsuario
    private void cargarUsuario() {
        String nombreActual = "";
        String nombre = usuario.getNombres().trim();
        String apellidos = usuario.getApellidos().trim();
        int indiceN = nombre.indexOf(" ");
        int indiceA = apellidos.indexOf(" ");
        if (indiceA == -1) {
            nombreActual += nombre + " ";
        } else {
//          nombreActual=nombreActual+nombre.substring(0, indiceNombre);
            nombreActual += nombre.substring(0, indiceN) + " ";
        }

        if (indiceN == -1) {
            nombreActual += apellidos + " ";
        } else {
            nombreActual += apellidos.substring(0, indiceA);
        }
        mnuUsuario.setText(nombreActual);

    }

    private void desabilitar_menu() {
        mnuAdmin.setVisible(false);
//        mnuCategoria.setVisible(false);
        mnuCliente.setVisible(false);
        mnuCompra.setVisible(false);
        mnuMantenimiento.setVisible(false);
//        mnuProducto.setVisible(false);
        mnuProveedor.setVisible(false);
        mnuReporte.setVisible(false);
        mnuVenta.setVisible(false);
    }
    private void cargar_permisos(){
        DetallePermiso detalleP=dpC.listar(usuario.getDocumento());
        //lista de persmisos traelos
        for (Permiso permiso : detalleP.getPermiso()) {
            switch (permiso.getDesripcion()) {
                case "mnuAdmin":
                    mnuAdmin.setVisible(true);
                    break;
                case "mnuCliente":
                    mnuCliente.setVisible(true);
                    break;
                case "mnuCompra":
                    mnuCompra.setVisible(true);
                    break;
                case "mnuMantenimiento":
                    mnuMantenimiento.setVisible(true);
                    break;
                case "mnuProveedor":
                    mnuProveedor.setVisible(true);
                    break;
                case "mnuReporte":
                    mnuReporte.setVisible(true);
                    break;
                case "mnuVenta":
                    mnuVenta.setVisible(true);
                    break;    
                default:
                
                    throw new AssertionError();
            }
            
        }
    }

    public static void centrarVentana(JInternalFrame frame) {
        escritorio.add(frame);
        Dimension dimension = escritorio.getSize();
        Dimension ventana = frame.getSize();
        frame.setLocation((dimension.width - ventana.width) / 2, (dimension.height - ventana.height) / 2);
        frame.show();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMantenimiento = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        mnuCategoria = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuProducto = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        mnuVenta = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        mnuCompra = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        mnuCliente = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        mnuProveedor = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnuReporte = new javax.swing.JMenu();
        mnuAdmin = new javax.swing.JMenu();
        mnuGestionarRol = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setName("escritorio"); // NOI18N

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1202, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        mnuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mantenimiento50.png"))); // NOI18N
        mnuMantenimiento.setText("Mantenimiento");
        mnuMantenimiento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuMantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuMantenimiento.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuMantenimiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem13.setText("Actualizar Stock");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(jMenuItem13);

        jMenuBar1.add(mnuMantenimiento);

        mnuCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorize_50px.png"))); // NOI18N
        mnuCategoria.setText("Categoria");
        mnuCategoria.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuCategoria.setMinimumSize(new java.awt.Dimension(120, 90));
        mnuCategoria.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem4.setText("Nueva Categoria");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuCategoria.add(jMenuItem4);

        jMenuItem5.setText("Gestionar Categoria");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuCategoria.add(jMenuItem5);

        jMenuBar1.add(mnuCategoria);

        mnuProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/product1_50px.png"))); // NOI18N
        mnuProducto.setText("Producto");
        mnuProducto.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        mnuProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuProducto.setMinimumSize(new java.awt.Dimension(120, 90));
        mnuProducto.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem6.setText("Nuevo Producto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuProducto.add(jMenuItem6);

        jMenuItem7.setText("Gestionar Producto");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnuProducto.add(jMenuItem7);

        jMenuBar1.add(mnuProducto);

        mnuVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venta_stock_50px.png"))); // NOI18N
        mnuVenta.setText("Venta");
        mnuVenta.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuVenta.setMinimumSize(new java.awt.Dimension(120, 90));
        mnuVenta.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem11.setText("Registrar Venta");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        mnuVenta.add(jMenuItem11);

        jMenuItem12.setText("Ver Detalle");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        mnuVenta.add(jMenuItem12);

        jMenuBar1.add(mnuVenta);

        mnuCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/invoice_50px.png"))); // NOI18N
        mnuCompra.setText("Compras");
        mnuCompra.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuCompra.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem1.setText("Registrar Compra");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuCompra.add(jMenuItem1);

        jMenuItem8.setText("Ver Detalle ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mnuCompra.add(jMenuItem8);

        jMenuBar1.add(mnuCompra);

        mnuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sql_database_administrators_group_50px.png"))); // NOI18N
        mnuCliente.setText("Clientes");
        mnuCliente.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuCliente.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rol30.png"))); // NOI18N
        jMenuItem9.setText("Gestionar Cliente");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mnuCliente.add(jMenuItem9);

        jMenuBar1.add(mnuCliente);

        mnuProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/supplier_50px.png"))); // NOI18N
        mnuProveedor.setText("Proveedores");
        mnuProveedor.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuProveedor.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rol30.png"))); // NOI18N
        jMenuItem10.setText("Gestionar Proveedor");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        mnuProveedor.add(jMenuItem10);

        jMenuBar1.add(mnuProveedor);

        mnuReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/combo_chart_50px.png"))); // NOI18N
        mnuReporte.setText("Reportes");
        mnuReporte.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuReporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuReporte.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuReporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(mnuReporte);

        mnuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin_settings_male_50px.png"))); // NOI18N
        mnuAdmin.setText("Admin");
        mnuAdmin.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuAdmin.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        mnuGestionarRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rol30.png"))); // NOI18N
        mnuGestionarRol.setText("Gestionar Rol");
        mnuGestionarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionarRolActionPerformed(evt);
            }
        });
        mnuAdmin.add(mnuGestionarRol);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user30.png"))); // NOI18N
        jMenuItem2.setText("Gestionar Usuario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuAdmin.add(jMenuItem2);

        jMenuBar1.add(mnuAdmin);

        mnuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_50px.png"))); // NOI18N
        mnuUsuario.setText("Usuario");
        mnuUsuario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuUsuario.setPreferredSize(new java.awt.Dimension(120, 90));
        mnuUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mnuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuarioActionPerformed(evt);
            }
        });

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarSesion30.png"))); // NOI18N
        jMenuItem3.setText("Cerrar Sesion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuUsuario.add(jMenuItem3);

        jMenuBar1.add(mnuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispose();
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mnuGestionarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionarRolActionPerformed
        centrarVentana(new FrmGestionarRol());
    }//GEN-LAST:event_mnuGestionarRolActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        centrarVentana(new FrmGestionarUsuario());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuarioActionPerformed
        this.dispose();

    }//GEN-LAST:event_mnuUsuarioActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        centrarVentana(new FrmGestionarCliente());
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        centrarVentana(new FrmGestionarProveedor());
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        centrarVentana(new FrmGestionarCategoria());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        centrarVentana(new FrmRegistrarProducto());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        centrarVentana(new FrmGestionarProducto());
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       centrarVentana(new FrmRegistrarCategoria());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        centrarVentana(new FrmActualizarStock());
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        centrarVentana(new FrmRegistrarPedido());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        centrarVentana(new FrmDetallePedido());
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        centrarVentana(new FrmRegistrarVenta());
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        centrarVentana(new FrmDetalleVenta());
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Windows look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
////                                   
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmMenuPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu mnuAdmin;
    private javax.swing.JMenu mnuCategoria;
    private javax.swing.JMenu mnuCliente;
    private javax.swing.JMenu mnuCompra;
    private javax.swing.JMenuItem mnuGestionarRol;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenu mnuProducto;
    private javax.swing.JMenu mnuProveedor;
    private javax.swing.JMenu mnuReporte;
    private javax.swing.JMenu mnuUsuario;
    private javax.swing.JMenu mnuVenta;
    // End of variables declaration//GEN-END:variables
}
