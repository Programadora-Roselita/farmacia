/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package CapaPresentacion;

import CapaDatos.Compra;
import CapaDatos.DetalleCompra;
import CapaDatos.Medida;
import CapaNegocio.CompraBD;
import CapaNegocio.DetalleCompraBD;
import CapaNegocio.MedidaBD;
import CapaNegocio.ProductoBD;
import CapaNegocio.ProveedorBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROSELITA
 */
public class Compra_IU extends javax.swing.JInternalFrame {
    
    List<Medida> lista_medida;

    /**
     * Creates new form Compra_IU
     */
    public Compra_IU() {
        initComponents();
        cargarMedida();
    }
    
    public void registrarDetalleCompra(int idcompra) {
        
        DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        int cantCompras = tabla_temporal_compras.getRowCount();
        DetalleCompra oDetalleCompra = new DetalleCompra();
        DetalleCompraBD odetalleCompra = new DetalleCompraBD();
        
        for (int i = 0; i < cantCompras; i++) {
            oDetalleCompra.setIdcompra(idcompra);
            oDetalleCompra.setpSerie(tabla_temporal_compras.getValueAt(i, 0).toString());
            oDetalleCompra.setDcCantidad((Double) tabla_temporal_compras.getValueAt(i, 4));
            oDetalleCompra.setDcPrecio((Double) tabla_temporal_compras.getValueAt(i, 5));
            oDetalleCompra.setDcImporte((Double) tabla_temporal_compras.getValueAt(i, 6));
            oDetalleCompra.setDcLote(tabla_temporal_compras.getValueAt(i, 2).toString());
            oDetalleCompra.setDcPresentacion(tabla_temporal_compras.getValueAt(i, 3).toString());
            
            odetalleCompra.registrarDetalleCompra(oDetalleCompra);
            
        }
        
    }
    
    private void limpiar_tabla_formulario() {
        
        DefaultTableModel tabla_temporal_detalle_producto = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        tabla_temporal_detalle_producto.setRowCount(0);
        
    }
    
    public void limpiarAgregar() {
        
        txtBarras.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtLote.setText("");
        txtPrecio.setText("");
        txtImporte.setText("");
        cmbMedida.setSelectedIndex(0);
        
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
    
    private void calculaTotal() {
        
        DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        int maxCompras = tabla_temporal_compras.getRowCount();
        double total = 0;
        for (int i = 0; i < maxCompras; i++) {
            total = total + (Double) tabla_temporal_compras.getValueAt(i, 6);
            
        }
        BigDecimal numero = new BigDecimal(total);
        BigDecimal decimal_total = numero.setScale(2, RoundingMode.DOWN);
        txtSubTotal.setText("" + decimal_total);
        txtTotalPagar.setText("" + decimal_total);
        
    }
    
    private void cargarMedida() {
        
        try {
            cmbMedida.removeAllItems();
            
            MedidaBD objeto_medidaBD = new MedidaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = objeto_medidaBD.reportarMedida();
            
            lista_medida = new ArrayList<>();
            cmbMedida.addItem("Seleccionar");
            
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                
                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1));
                
                lista_medida.add(new Medida(codigo, nombre, ""));
                cmbMedida.addItem(nombre);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e, "Error al cargar medida ", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoComprobante = new javax.swing.JComboBox<>();
        cmbFormaPago = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNroComprobante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbMoneda = new javax.swing.JComboBox<>();
        cmbTienda = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        dcFechaCompra = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtBarras = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        cmbMedida = new javax.swing.JComboBox<>();
        txtLote = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_detalle_productos = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtSubTotalDscto = new javax.swing.JTextField();
        txtFlete = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("COMPRAS");
        setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA COMPRA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setText("TIPO COMPROBANTE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("FORMA DE PAGO");

        cmbTipoComprobante.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        cmbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACTURA", "BOLETA" }));

        cmbFormaPago.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        cmbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setText("NRO COMPROBANTE");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setText("FECHA DE COMPRA");

        txtNroComprobante.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNroComprobante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNroComprobanteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroComprobanteFocusLost(evt);
            }
        });
        txtNroComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNroComprobanteKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("MONEDA");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setText("TIENDA");

        cmbMoneda.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLES" }));

        cmbTienda.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        cmbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRINCIPAL" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setText("TIPO DE PAGO");

        cmbTipoPago.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO" }));

        dcFechaCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N
        dcFechaCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dcFechaCompraKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbTipoComprobante, 0, 112, Short.MAX_VALUE)
                    .addComponent(cmbFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNroComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbMoneda, 0, 116, Short.MAX_VALUE)
                    .addComponent(cmbTienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cmbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA COMPRA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setText("RUC");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel9.setText("RAZON SOCIAL");

        txtRuc.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtRuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRucFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRucFocusLost(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        txtRazonSocial.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtRazonSocial.setEnabled(false);
        txtRazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSocialActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/buscar_proveedor.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtRazonSocial))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(204, 204, 204))); // NOI18N

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/disk.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/cross.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(18, 18, 18))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel10.setText("BARRAS");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel12.setText("PRESENTACION");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setText("LOTE");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel14.setText("CANT");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel15.setText("PRECIO");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel16.setText("IMPORTE");

        txtBarras.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBarrasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBarrasFocusLost(evt);
            }
        });
        txtBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarrasActionPerformed(evt);
            }
        });
        txtBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarrasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarrasKeyTyped(evt);
            }
        });

        txtProducto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtProducto.setEnabled(false);

        cmbMedida.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cmbMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMedidaKeyPressed(evt);
            }
        });

        txtLote.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoteFocusLost(evt);
            }
        });
        txtLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoteActionPerformed(evt);
            }
        });
        txtLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoteKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel17.setText("PRODUCTO");

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioFocusLost(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        txtImporte.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtImporte.setEnabled(false);
        txtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteActionPerformed(evt);
            }
        });

        btnQuitar.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/eliminar2.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        btnQuitar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnQuitarKeyPressed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Images/venta2.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtBarras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel15)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tabla_reporte_detalle_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BARRAS", "PRODUCTO", "LOTE", "PRESENTACION", "CANT", "PRECIO", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_detalle_productos);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel18.setText("SUBTOTAL");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel19.setText("DESCUENTO");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel20.setText("SUBTOTAL CON DSCTO");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel21.setText("FLETE");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel22.setText("IGV");

        txtSubTotal.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtSubTotal.setEnabled(false);
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });

        txtDescuento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescuentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescuentoFocusLost(evt);
            }
        });
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        txtSubTotalDscto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtSubTotalDscto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSubTotalDsctoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSubTotalDsctoFocusLost(evt);
            }
        });
        txtSubTotalDscto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalDsctoActionPerformed(evt);
            }
        });
        txtSubTotalDscto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSubTotalDsctoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubTotalDsctoKeyTyped(evt);
            }
        });

        txtFlete.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtFlete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFleteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFleteFocusLost(evt);
            }
        });
        txtFlete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFleteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFleteKeyTyped(evt);
            }
        });

        txtIgv.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtIgv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIgvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIgvFocusLost(evt);
            }
        });
        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });
        txtIgv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIgvKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIgvKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel23.setText("TOTAL A PAGAR");

        txtTotalPagar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTotalPagar.setEnabled(false);
        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtSubTotalDscto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23))
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotalDscto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocialActionPerformed

    private void txtLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoteActionPerformed

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvActionPerformed

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
            
        }
        

    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        // TODO add your handling code here:

        try {
            
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            double cant = Double.parseDouble(txtCantidad.getText().trim());
            
            double resultado = precio * cant;
            
            BigDecimal numero = new BigDecimal(resultado);
            BigDecimal decimales = numero.setScale(2, RoundingMode.DOWN);
            
            txtImporte.setText("" + decimales);
            
        } catch (Exception e) {
        }
        

    }//GEN-LAST:event_txtPrecioKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        if (txtRuc.getText().length() > 0) {
            
            DefaultTableModel tabla_temporal;
            ProveedorBD oProveedorBD = new ProveedorBD();
            tabla_temporal = oProveedorBD.buscarProveedor(txtRuc.getText().trim());
            if (tabla_temporal.getRowCount() > 0) {
                txtRazonSocial.setText(tabla_temporal.getValueAt(0, 1).toString());
                
            } else {
                advertencia("No se encontro, tienes que registrar primero al proveedor...");
                txtRuc.requestFocus();
                txtRazonSocial.setText("");
                
            }
            
        } else {
            advertencia("Ingrese el ruc para buscar al proveedor");
            txtRuc.requestFocus();
        }
        

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarrasActionPerformed
        // TODO add your handling code here:

        if (txtBarras.getText().length() > 0) {
            
            DefaultTableModel tabla_temporal;
            ProductoBD oProductoBD = new ProductoBD();
            tabla_temporal = oProductoBD.buscarProducto(txtBarras.getText().trim());
            if (tabla_temporal.getRowCount() > 0) {
                txtProducto.setText(tabla_temporal.getValueAt(0, 1).toString());
                
            } else {
                advertencia("No se encontro el producto con ese codig de barras...");
                txtBarras.requestFocus();
                txtProducto.setText("");
                
            }
            
        } else {
            advertencia("Ingrese codigo de barras");
            txtBarras.requestFocus();
        }
        

    }//GEN-LAST:event_txtBarrasActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code hegetTextre:

        if (txtProducto.getText().length() > 0) {
            if (txtImporte.getText().length() > 0) {
                if (txtPrecio.getText().length() > 0) {
                    if (txtLote.getText().length() > 0) {
                        if (!cmbMedida.getSelectedItem().equals("Seleccionar")) {
                            
                            String barras = txtBarras.getText().trim();
                            String producto = txtProducto.getText().trim();
                            String lote = txtLote.getText().trim().toUpperCase();
                            String presentacion = cmbMedida.getSelectedItem().toString();
                            double cant = Double.parseDouble(txtCantidad.getText().trim());
                            double precio = Double.parseDouble(txtPrecio.getText().trim());
                            double importe = Double.parseDouble(txtImporte.getText().trim());
                            
                            DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
                            Object[] data = {barras, producto, lote, presentacion, cant, precio, importe};
                            tabla_temporal_compras.addRow(data);
                            
                            limpiarAgregar();
                            calculaTotal();
                            
                        } else {
                            
                            advertencia("Seleccione una medida");
                            
                        }
                        
                    } else {
                        advertencia("Ingrese lote de la compra");
                        txtLote.requestFocus();
                    }
                    
                } else {
                    advertencia("Ingrese precio del producto");
                    txtPrecio.requestFocus();
                }
                
            } else {
                advertencia("Calcular el importe");
                txtCantidad.requestFocus();
            }
            
        } else {
            advertencia("Ingrese un producto");
            txtBarras.requestFocus();
        }
        

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:

        int filaseleccionada = tabla_reporte_detalle_productos.getSelectedRow();
        try {
            DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
            tabla_temporal_compras.removeRow(filaseleccionada);
            
            tabla_reporte_detalle_productos.setModel(tabla_temporal_compras);
            
            calculaTotal();
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "Error al quitar", "Error", JOptionPane.WARNING_MESSAGE);
            
        }
        

    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        int cant_producto = tabla_reporte_detalle_productos.getRowCount();
        
        if (cant_producto > 0) {
            if (txtNroComprobante.getText().length() > 0) {
                if (txtRuc.getText().length() > 0) {
                    if (txtRazonSocial.getText().length() > 0) {
                        if (txtSubTotal.getText().length() > 0) {
                            if (txtDescuento.getText().length() > 0) {
                                if (txtSubTotalDscto.getText().length() > 0) {
                                    if (txtFlete.getText().length() > 0) {
                                        if (txtIgv.getText().length() > 0) {
                                            if (dcFechaCompra.getDate() != null) {
                                                
                                                Compra oCompra = new Compra();
                                                CompraBD oCompraBD = new CompraBD();
                                                
                                                SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                                                String fecha = dcn.format(dcFechaCompra.getDate());
                                                oCompra.setCoFecha(fecha);
                                                oCompra.setCoTipoDoc(cmbTipoComprobante.getSelectedItem().toString());
                                                oCompra.setCoNroDoc(txtNroComprobante.getText().toUpperCase());
                                                oCompra.setCoTipoPago(cmbTipoPago.getSelectedItem().toString());
                                                oCompra.setCoFormaPago(cmbFormaPago.getSelectedItem().toString());
                                                oCompra.setCoMoneda(cmbMoneda.getSelectedItem().toString());
                                                oCompra.setCoSubTotal(Double.parseDouble(txtSubTotal.getText().trim()));
                                                oCompra.setCoFlete(Double.parseDouble(txtFlete.getText().trim()));
                                                oCompra.setCoIgv(Double.parseDouble(txtIgv.getText().trim()));
                                                oCompra.setCoTotal(Double.parseDouble(txtTotalPagar.getText().trim()));
                                                oCompra.setProvRuc(txtRuc.getText().trim());
                                                oCompra.setuDni(Login_IU.dni_publico);
                                                oCompra.setTienda(cmbTienda.getSelectedItem().toString());
                                                
                                                int idcompra = oCompraBD.registrarCompra(oCompra);
                                                if (idcompra > -1) {
                                                    
                                                    registrarDetalleCompra(idcompra);
                                                    
                                                    exito("Todo ok...");
                                                    limpiarAgregar();
                                                    limpiar_tabla_formulario();
                                                    
                                                } else {
                                                    error("No se pudo realizae la compra");
                                                }
                                                
                                            } else {
                                                advertencia("Seleccione una fecha...");
                                                dcFechaCompra.requestFocus();
                                            }
                                            
                                        } else {
                                            advertencia("Ingrese el igv de la compra. Sino no hubiera coloque 0...");
                                            txtIgv.requestFocus();
                                        }
                                        
                                    } else {
                                        advertencia("Ingrese el flete de la compra, Sino hubiera ccoloque 0...");
                                        txtFlete.requestFocus();
                                    }
                                    
                                } else {
                                    advertencia("Ingrese el Subtotal con descuento de la compra, Sino hubiera ccoloque 0...");
                                    txtSubTotalDscto.requestFocus();
                                }
                                
                            } else {
                                advertencia("Ingrese el descuento de la compra, Sino hubiera ccoloque 0...");
                                txtDescuento.requestFocus();
                                
                            }
                            
                        } else {
                            advertencia("Ingrese el Subtotal  de la compra...");
                            txtSubTotal.requestFocus();
                        }
                        
                    } else {
                        advertencia("Coloque un RUC valido...");
                        txtRuc.requestFocus();
                    }
                    
                } else {
                    advertencia("Coloque un RUC del proveedor...");
                    txtRuc.requestFocus();
                }
                
            } else {
                advertencia("Ingrese el nro de comprobante de la compra...");
                txtNroComprobante.requestFocus();
            }
            
        } else {
            advertencia("No hay productos en la lista...");
            txtBarras.requestFocus();
        }
        

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImporteActionPerformed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.requestFocus();
        }
    }//GEN-LAST:event_txtRucKeyPressed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtBarras.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void txtBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrasKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbMedida.requestFocus();
        }
    }//GEN-LAST:event_txtBarrasKeyPressed

    private void cmbMedidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMedidaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtLote.requestFocus();
        }
    }//GEN-LAST:event_cmbMedidaKeyPressed

    private void txtLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCantidad.requestFocus();
        }
    }//GEN-LAST:event_txtLoteKeyPressed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPrecio.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAgregar.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnQuitar.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarKeyPressed

    private void btnQuitarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnQuitarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNroComprobante.requestFocus();
        }
    }//GEN-LAST:event_btnQuitarKeyPressed

    private void txtNroComprobanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroComprobanteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dcFechaCompra.requestFocus();
        }
    }//GEN-LAST:event_txtNroComprobanteKeyPressed

    private void dcFechaCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaCompraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDescuento.requestFocus();
        }
    }//GEN-LAST:event_dcFechaCompraKeyPressed

    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSubTotalDscto.requestFocus();
        }
    }//GEN-LAST:event_txtDescuentoKeyPressed

    private void txtFleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFleteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtIgv.requestFocus();
        }
    }//GEN-LAST:event_txtFleteKeyPressed

    private void txtIgvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgvKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_txtIgvKeyPressed

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCerrar.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void txtRucFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRucFocusGained
        // TODO add your handling code here:
        txtRuc.setBackground(Color.yellow);

    }//GEN-LAST:event_txtRucFocusGained

    private void txtRucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRucFocusLost
        // TODO add your handling code here:
        txtRuc.setBackground(Color.white);

    }//GEN-LAST:event_txtRucFocusLost

    private void txtBarrasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBarrasFocusGained
        // TODO add your handling code here:
        txtBarras.setBackground(Color.yellow);

    }//GEN-LAST:event_txtBarrasFocusGained

    private void txtBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBarrasFocusLost
        // TODO add your handling code here:
        txtBarras.setBackground(Color.white);

    }//GEN-LAST:event_txtBarrasFocusLost

    private void txtLoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoteFocusGained
        // TODO add your handling code here:
        txtLote.setBackground(Color.yellow);

    }//GEN-LAST:event_txtLoteFocusGained

    private void txtLoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoteFocusLost
        // TODO add your handling code here:
        txtLote.setBackground(Color.white);

    }//GEN-LAST:event_txtLoteFocusLost

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        // TODO add your handling code here:
        txtCantidad.setBackground(Color.yellow);

    }//GEN-LAST:event_txtCantidadFocusGained

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        // TODO add your handling code here:
        txtCantidad.setBackground(Color.white);

    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusGained
        // TODO add your handling code here:
        txtPrecio.setBackground(Color.yellow);

    }//GEN-LAST:event_txtPrecioFocusGained

    private void txtPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusLost
        // TODO add your handling code here:
        txtPrecio.setBackground(Color.white);

    }//GEN-LAST:event_txtPrecioFocusLost

    private void txtNroComprobanteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroComprobanteFocusGained
        // TODO add your handling code here:
        txtNroComprobante.setBackground(Color.yellow);

    }//GEN-LAST:event_txtNroComprobanteFocusGained

    private void txtNroComprobanteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroComprobanteFocusLost
        // TODO add your handling code here:
        txtNroComprobante.setBackground(Color.white);

    }//GEN-LAST:event_txtNroComprobanteFocusLost

    private void txtDescuentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescuentoFocusGained
        // TODO add your handling code here:
        txtDescuento.setBackground(Color.yellow);

    }//GEN-LAST:event_txtDescuentoFocusGained

    private void txtDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescuentoFocusLost
        // TODO add your handling code here:
        txtDescuento.setBackground(Color.white);

    }//GEN-LAST:event_txtDescuentoFocusLost

    private void txtFleteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFleteFocusGained
        // TODO add your handling code here:
        txtFlete.setBackground(Color.yellow);

    }//GEN-LAST:event_txtFleteFocusGained

    private void txtFleteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFleteFocusLost
        // TODO add your handling code here:
        txtFlete.setBackground(Color.white);

    }//GEN-LAST:event_txtFleteFocusLost

    private void txtIgvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIgvFocusGained
        // TODO add your handling code here:
        txtIgv.setBackground(Color.yellow);

    }//GEN-LAST:event_txtIgvFocusGained

    private void txtIgvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIgvFocusLost
        // TODO add your handling code here:
        txtIgv.setBackground(Color.white);

    }//GEN-LAST:event_txtIgvFocusLost

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtCantidad.getText().length() >= 10) {
            
            evt.consume();
            
        }
        

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrasKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtBarras.getText().length() >= 13) {
            
            evt.consume();
            
        }
    }//GEN-LAST:event_txtBarrasKeyTyped

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtDescuento.getText().length() >= 2) {
            
            evt.consume();
            
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtFleteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFleteKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtFlete.getText().length() >= 2) {
            
            evt.consume();
            
        }
    }//GEN-LAST:event_txtFleteKeyTyped

    private void txtIgvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgvKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtIgv.getText().length() >= 2) {
            
            evt.consume();
            
        }

    }//GEN-LAST:event_txtIgvKeyTyped

    private void txtSubTotalDsctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalDsctoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalDsctoActionPerformed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtRuc.getText().length() >= 11) {
            
            evt.consume();
            
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtSubTotalDsctoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubTotalDsctoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtFlete.getText().length() >= 2) {
            
            evt.consume();
            
        }
    }//GEN-LAST:event_txtSubTotalDsctoKeyTyped

    private void txtSubTotalDsctoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubTotalDsctoKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtFlete.requestFocus();
        }
    }//GEN-LAST:event_txtSubTotalDsctoKeyPressed

    private void txtSubTotalDsctoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotalDsctoFocusGained
        // TODO add your handling code here:
        txtSubTotalDscto.setBackground(Color.yellow);

    }//GEN-LAST:event_txtSubTotalDsctoFocusGained

    private void txtSubTotalDsctoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotalDsctoFocusLost
        // TODO add your handling code here:
        txtSubTotalDscto.setBackground(Color.white);

    }//GEN-LAST:event_txtSubTotalDsctoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbFormaPago;
    private javax.swing.JComboBox<String> cmbMedida;
    private javax.swing.JComboBox<String> cmbMoneda;
    private javax.swing.JComboBox<String> cmbTienda;
    private javax.swing.JComboBox<String> cmbTipoComprobante;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private com.toedter.calendar.JDateChooser dcFechaCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_detalle_productos;
    private javax.swing.JTextField txtBarras;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNroComprobante;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSubTotalDscto;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
