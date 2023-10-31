/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package CapaPresentacion;

import CapaDatos.Asistencia;
import CapaDatos.Caja;
import CapaDatos.Turno;
import CapaNegocio.AsistenciaBD;
import CapaNegocio.CajaBD;
import CapaNegocio.DetalleCajaBD;
import CapaNegocio.TurnoBD;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROSELITA
 */
public class Caja_IU extends javax.swing.JInternalFrame {

    double total_ingresos = 0.0;
    double total_engresos = 0.0;
    double saldo_hoy = 0.0;
    double saldo_anterior = 0.0;
    String tienda;
    String dni_usuario;
    String am_pm;
    int nueva_hora;
    String hh_mm_ss;
    double total_caja_hoy;

    public Caja_IU() {
        initComponents();
        sacarFecha();
        sacarHora();

        sacarTotalIngresos();
        sacarTotalEgresos();

        mostrarSaldoHoy();

        saldoAnterior();

    }

    private void sacarTotalIngresos() {

        DefaultTableModel tabla_temporal;
        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
        tienda = Login_IU.tienda;
        dni_usuario = Login_IU.dni_publico;
        tabla_temporal = oDetalleCajaBD.mostrarTotalDineroXtipo("INGRESO", "ABIERTO", tienda, dni_usuario, "CAJA NRO 1");
        if (tabla_temporal.getValueAt(0, 0) != null) {
            txtTotalIngresos.setText("S/." + tabla_temporal.getValueAt(0, 0));
            total_ingresos = Double.parseDouble(tabla_temporal.getValueAt(0, 0).toString());

        } else {
            total_ingresos = 0.00;
            txtTotalIngresos.setText("S/." + total_ingresos);
        }

    }

    private void sacarTotalEgresos() {

        DefaultTableModel tabla_temporal;
        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
        tienda = Login_IU.tienda;
        dni_usuario = Login_IU.dni_publico;
        tabla_temporal = oDetalleCajaBD.mostrarTotalDineroXtipo("EGRESO", "ABIERTO", tienda, dni_usuario, "CAJA NRO 1");
        if (tabla_temporal.getValueAt(0, 0) != null) {
            txtTotalEgresos.setText("S/." + tabla_temporal.getValueAt(0, 0));
            total_engresos = Double.parseDouble(tabla_temporal.getValueAt(0, 0).toString());

        } else {
            total_engresos = 0.00;
            txtTotalEgresos.setText("S/." + total_engresos);
        }

    }

    private void mostrarSaldoHoy() {

        saldo_hoy = total_ingresos - total_engresos;
        txtSaldoHoy.setText("S/." + saldo_hoy);

    }

    private void saldoAnterior() {

        CajaBD oCajaBD = new CajaBD();
        List<Caja> lista_saldo_anterior = oCajaBD.obtenerSaldoAnterior();

        if (lista_saldo_anterior.size() > 0) {
            lblSaldoAnterior.setText("SALDO ANTERIOR S/." + lista_saldo_anterior.get(0).getSaldo_final());
            saldo_anterior = lista_saldo_anterior.get(0).getSaldo_final();

            total_caja_hoy = saldo_anterior + saldo_hoy;
            lblTotalCaja.setText("S/." + total_caja_hoy);

        } else {
            saldo_anterior = 0.00;
            lblSaldoAnterior.setText("SALDO ANTERIOR S/." + saldo_anterior);
            total_caja_hoy = saldo_anterior + saldo_hoy;
            lblTotalCaja.setText("S/." + total_caja_hoy);

        }

    }

    public void cerrar_caja() {

        Caja oCaja = new Caja();
        CajaBD oCajaBD = new CajaBD();
        dni_usuario = Login_IU.dni_publico;
        oCaja.setCaFecha(txtFecha.getText());
        oCaja.setHora(txtHora.getText());
        oCaja.setTotal_ingreso(total_ingresos);
        oCaja.setTotal_egreso(total_engresos);
        oCaja.setSaldo_final(total_caja_hoy);
        oCaja.setNroCaja("CAJA NRO 1");
        oCaja.setCaEstado("CERRADO");
        oCaja.setuDni(dni_usuario);
        oCaja.setTienda(tienda);

        boolean rpta = oCajaBD.registrarCaja(oCaja);
        if (rpta) {
            exito("Se  cerro la caja con exito...");

        } else {
            error("Tienes problemas para cerrar la caja");
        }

    }

    public void cerrar_detalle_caja() {

        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
        oDetalleCajaBD.actualizarEstado("CERRADO", Login_IU.dni_publico, Login_IU.tienda, "CAJA NRO1");

    }
    public void  control_asistencia_salida(){
        
        Asistencia oAsistencia = new Asistencia();
        AsistenciaBD oAsistenciaBD = new AsistenciaBD();
        oAsistencia.setaHoraS(txtHora.getText());
        oAsistencia.setaEstado("CERRADO");
        oAsistencia.setIdasistencia(Login_IU.idasistencia);
        oAsistenciaBD.actualizarAsistencia(oAsistencia);
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

    private void sacarHora() {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        hh_mm_ss = hora + ":" + minutos + ":" + segundos;

        txtHora.setText(hh_mm_ss);

    }

    private void sacarFecha() {

        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);
        String fecha = anio + "-" + mes + "-" + dia;

        txtFecha.setText(fecha);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaldoAnterior = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTotalIngresos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotalEgresos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSaldoHoy = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCerrarCaja = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblTotalCaja = new javax.swing.JLabel();
        chkCerrarAntes = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CAJA");

        lblSaldoAnterior.setBackground(new java.awt.Color(0, 153, 255));
        lblSaldoAnterior.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblSaldoAnterior.setText("    SALDO ANTERIOR S/. 0,00");
        lblSaldoAnterior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("TOTAL DE INGRESOS");

        txtTotalIngresos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalIngresos.setForeground(new java.awt.Color(0, 51, 204));
        txtTotalIngresos.setText("                    0,00");
        txtTotalIngresos.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("TOTAL DE EGRESOS");

        txtTotalEgresos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalEgresos.setForeground(new java.awt.Color(255, 0, 51));
        txtTotalEgresos.setText("                    0,00");
        txtTotalEgresos.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("SALDO DE HOY");

        txtSaldoHoy.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtSaldoHoy.setText("  S/.0,00");
        txtSaldoHoy.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("FECHA");

        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFecha.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("HORA");

        txtHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHora.setEnabled(false);

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCerrarCaja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCerrarCaja.setText("CERRAR CAJA");
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 153));
        jLabel6.setText("                                SALDO DE HOY + SALDO ANTERIOR");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        lblTotalCaja.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTotalCaja.setForeground(new java.awt.Color(0, 51, 255));
        lblTotalCaja.setText("             S/.0,00");
        lblTotalCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        chkCerrarAntes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkCerrarAntes.setText("CERRAR ANTES DE LA HORA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSaldoAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSaldoHoy, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTotalEgresos, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTotalIngresos, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCerrarCaja, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chkCerrarAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(btnCerrarCaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotalEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaldoHoy))
                    .addComponent(lblTotalCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkCerrarAntes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        sacarTotalIngresos();
        sacarTotalEgresos();

        mostrarSaldoHoy();


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        // TODO add your handling code here:

        try {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro(a) de cerrar la caja");
            if (aviso == 0) {
                if (chkCerrarAntes.isSelected()) {
                    cerrar_caja();
                    cerrar_detalle_caja();

                    control_asistencia_salida();
                    System.exit(0);
                } else {
                    TurnoBD oTurnoBD = new TurnoBD();
                    List<Turno> lista_turno = oTurnoBD.verificarHorario(txtHora.getText(), Login_IU.dni_publico);
                    if (lista_turno.size() == 0) {
                        cerrar_caja();
                        cerrar_detalle_caja();

                        control_asistencia_salida();
                        System.exit(0);

                    } else {
                        advertencia("Todavia no puedes cerrar caja, no se cumple tu horario de salida");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnCerrarCajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JCheckBox chkCerrarAntes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblSaldoAnterior;
    private javax.swing.JLabel lblTotalCaja;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtSaldoHoy;
    private javax.swing.JTextField txtTotalEgresos;
    private javax.swing.JTextField txtTotalIngresos;
    // End of variables declaration//GEN-END:variables
}
