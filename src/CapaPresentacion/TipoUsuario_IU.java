/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package CapaPresentacion;

import CapaDatos.TipoUsuario;
import CapaNegocio.TipoUsuarioBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROSELITA
 */
public class TipoUsuario_IU extends javax.swing.JInternalFrame {

    /**
     * Creates new form TipoUsuario_IU
     */
    public TipoUsuario_IU() {
        initComponents();
        reportar();
    }

    public void reportar() {

        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;
            TipoUsuarioBD oTipoUsuarioBD = new TipoUsuarioBD();
            tabla_temporal = oTipoUsuarioBD.reportarTipoUsuario();
            tabla_reporte_TipoUsuario.setModel(tabla_temporal);

            int cant = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cant);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void limpiar() {

        txtCodigo.setText("");
        txtNombre.setText("");
        txtNombre.requestFocus();

    }

    private void exito(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "MENSAJE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void error(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

    }

    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_TipoUsuario = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TIPO USUARIOS");

        txtCodigo.setEnabled(false);

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel1.setText("CODIGO");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("CANTIDAD");

        txtCantidad.setEnabled(false);

        tabla_reporte_TipoUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_reporte_TipoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_TipoUsuarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_TipoUsuario);

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/guardar.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        btnRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRegistrarKeyPressed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/lapiz.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/eliminar2.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLimpiarKeyPressed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/cerrar.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        if (txtNombre.getText().length() > 0) {
            if (txtCodigo.getText().length() == 0) {
                TipoUsuario oTipoUsuario = new TipoUsuario();

                TipoUsuarioBD oTipoUsuarioBD = new TipoUsuarioBD();

                oTipoUsuario.setTuNombre(txtNombre.getText().trim().toUpperCase());

                boolean rpta = oTipoUsuarioBD.registrarTipoUsuario(oTipoUsuario);
                if (rpta) {
                    exito("Se registro correctamente");
                    reportar();
                    limpiar();

                } else {
                    error("Tienes problemaas al registrar");
                }

            } else {
                error("No puedes registrar porque ya existe");

            }

        } else {
            error("Ingresa el nombre");
            txtNombre.requestFocus();
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tabla_reporte_TipoUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_TipoUsuarioMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila_seleccionada = tabla_reporte_TipoUsuario.getSelectedRow();
            txtCodigo.setText(tabla_reporte_TipoUsuario.getValueAt(fila_seleccionada, 0).toString());
            txtNombre.setText(tabla_reporte_TipoUsuario.getValueAt(fila_seleccionada, 1).toString());

        }
    }//GEN-LAST:event_tabla_reporte_TipoUsuarioMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:

        if (txtCodigo.getText().length() > 0) {
            if (txtNombre.getText().length() > 0) {
                TipoUsuario oTipoUsuario = new TipoUsuario();
                TipoUsuarioBD oTipoUsuarioBD = new TipoUsuarioBD();

                oTipoUsuario.setIdtipousuario(Integer.parseInt(txtCodigo.getText().trim()));
                oTipoUsuario.setTuNombre(txtNombre.getText().trim().toUpperCase());

                boolean rpta = oTipoUsuarioBD.modificarTipoUsuario(oTipoUsuario);
                if (rpta) {
                    exito("Se modifico con exito");
                    reportar();
                    limpiar();

                } else {
                    error("Tienes problemas al modificar");
                }

            } else {
                error("Ingresa el nombre");
                txtNombre.requestFocus();

            }

        } else {
            error("No existe el codigo al modificar");

        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        if (txtCodigo.getText().length() > 0) {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estar seguro de eliminar");
            if (aviso == 0) {
                int codigo = Integer.parseInt(txtCodigo.getText().trim());
                TipoUsuarioBD oTipoUsuarioBD = new TipoUsuarioBD();
                TipoUsuario oTipoUsuario = new TipoUsuario();

                oTipoUsuario.setIdtipousuario(codigo);

                boolean rpta = oTipoUsuarioBD.eliminarTipoUsuario(oTipoUsuario);
                if (rpta) {
                    exito("Se elimino correctamente");
                    reportar();
                    limpiar();

                } else {
                    error("Error hay problemas...");
                }

            } else {
                error("Falta codigo");

            }

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
        txtNombre.setBackground(Color.yellow);

    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
        txtNombre.setBackground(Color.white);

    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnModificar.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnEliminar.requestFocus();
        }
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLimpiar.requestFocus();
        }
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnLimpiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLimpiarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCerrar.requestFocus();
        }
    }//GEN-LAST:event_btnLimpiarKeyPressed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
          char type = evt.getKeyChar();

        if (!Character.isLetter(type) && type != KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_TipoUsuario;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
