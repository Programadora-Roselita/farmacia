/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.EntradaProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROSELITA
 */
public class EntradaProductoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarEntradaProducto(EntradaProducto d) {

        boolean rpta = false;
        sql = "INSERT INTO entradaProducto(idep,fecha_hora_ingreso,pSerie,lote,presentacion,equivalencia,fechaVcto,stockPresentacion,stockEquivalencia"
                + "precioCompraPresentacion,precioCompraEquivalencia,margenGananciaPresentacion,margenGananciaEquivalencia"
                + "precioVentaPresentacionMayor,precioVentaPresentacionMenor,precioVentaEquivaleniaMayor,precioVentaEquivaleniaMenor,ref,tienda) "
                + "VALUES (NULL, NOW(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, d.getpSerie());
            pst.setString(2, d.getLote());
            pst.setString(3, d.getPresentacion());
            pst.setString(4, d.getEquivalencia());
            pst.setString(5, d.getFechaVcto());
            pst.setDouble(6, d.getStockPresentacion());
            pst.setDouble(7, d.getStockEquivalencia());
            pst.setDouble(8, d.getPrecioCompraPresentacion());
            pst.setDouble(9, d.getPrecioCompraEquivalencia());
            pst.setInt(10, d.getMargenGananciaPresentacion());
            pst.setInt(11, d.getMargenGananciaEquivalencia());
            pst.setDouble(12, d.getPrecioVentaPresentacionMayor());
            pst.setDouble(13, d.getPrecioVentaPresentacionMenor());
            pst.setDouble(14, d.getPrecioVentaEquivalenciaMayor());
            pst.setDouble(15, d.getPrecioVentaEquivalenciaMenor());
            pst.setInt(16, d.getRef());
            pst.setString(17, d.getTienda());

            rpta = pst.executeUpdate() == 1 ? true : false;
            pst.close();
            cn.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas al registrar Entrada Producto BD", JOptionPane.ERROR_MESSAGE);
            return rpta;

        }
        return rpta;
    }

    public DefaultTableModel inventario() {

        DefaultTableModel modelo;
        String[] titulos = {"idep", "fecha_hora_ingreso", "pSerie", "pDescripcion", "presentacion", "equivalencia", "maNombre", "catNombre", "lote", "fechaVcto", "stockPresentacion",
            "stockEquivalencia", "precioCompraPresentacion", "precioCompraEquivalencia", "precioVentaPresentacionMayor", "precioVentaEquivalenciaMayor", "tienda"};
        String[] registros = new String[17];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idep,fecha_hora_ingreso,ep.pSerie,pDescripcion,presentacion,equivalencia,maNombre,catNombre,lote,fechaVcto,stockPresentacion,stockEquivalencia,precioCompraPresentacion "
                + "precioCompraEquivalencia,precioVentaPresentacionMayor,precioVentaEquivalenciaMayor,tienda FROM entradaproducto AS ep "
                + "INNER JOIN producto AS p ON  ep.pSerie=p.pSerie "
                + "INNER JOIN marca AS m ON  p.idmarca=m.idmarca "
                + "INNER JOIN categoria AS c ON  p.idcategoria=c.idcategoria "
                + "INNER JOIN medida AS me ON  p.idmedida=me.idmedida "
                + "WHERE stockEquivalencia>0 ORDER BY fechaVcto DESC ";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                registros[0] = rs.getString("idep");
                registros[1] = rs.getString("fecha_hora_ingreso");
                registros[2] = rs.getString("pSerie");
                registros[3] = rs.getString("pDescripcion");
                registros[4] = rs.getString("presentacion");
                registros[5] = rs.getString("equivalencia");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("catNombre");
                registros[8] = rs.getString("lote");
                registros[9] = rs.getString("fechaVcto");
                registros[10] = rs.getString("stockPresentacion");
                registros[11] = rs.getString("stockEquivalencia");
                registros[12] = rs.getString("precioCompraPresentacion");
                registros[13] = rs.getString("precioCompraEquivalencia");
                registros[14] = rs.getString("precioVentaPresentacionMayor");
                registros[15] = rs.getString("precioVentaEquivalenciaMayor");
                registros[16] = rs.getString("tienda");

                modelo.addRow(registros);

            }

            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Entrada Producto Venta BD...", JOptionPane.ERROR_MESSAGE);

            return null;

        }
        return modelo;
    }

    public DefaultTableModel buscarProductoXdescripcion(String descripcion) {

        DefaultTableModel modelo;

        String[] titulos = {"IDEP", "FECHA_HORA", "LOTE", "SERIE", "DESCRIPCION", "CONDICION", "CATEGORIA", "MARCA", "MEDIDA", "PRESENTACION", "EQUIVALENCIA", "FECHA_VCTO",
            "STOCK_PRESENTACION", "STOCK_EQUIVALENCIA", "PRECIO_COMPRA_PRESENTACION", "PRECIO_COMPRA_EQUIVALENCIA", "MARGEN_GANANCIA_PRESENTACION", "MARGEN_GANANCIA_EQUIVALENCIA",
            "PRECIO_VENTA_PRESENTACION_MAYOR", "PRECIO_VENTA_PRESENTACION_MENOR", "PRECIO_VENTA_EQUIVALENCIA_MAYOR", "PRECIO_VENTA_EQUIVALENCIA_MENOR", "REF", "TIENDA"};
        String[] registros = new String[24];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idep,fecha_hora_ingreso,lote,p.pSerie,pDescripcion,pCondicion,catNombre,maNombre,mPresentacion,presentacion,equivalencia,fechaVcto "
                + "stockPresentacion,stockEquivalencia,precioCompraPresentacion,precioCompraEquivalencia,margenGananciaPresentacion,margenGananciaEquivalencia "
                + "precioVentaPresentacionMayor,precioVentaPresentacionMenor,precioVentaEquivaleniaMayor,precioVentaEquivaleniaMenor,ref,tienda FROM entradaproducto AS ep "
                + "INNER JOIN producto AS p ON  ep.pSerie=p.pSerie "
                + "INNER JOIN categoria AS c ON  p.idcategoria=c.idcategoria "
                + "INNER JOIN marca AS m ON  p.idmarca=m.idmarca "
                + "INNER JOIN medida AS me ON  p.idmedida=me.idmedida "
                + "WHERE pDescripcion LIKE ? OR p.pSerie LIKE ? ORDER BY fechaVcto ASC LIMIT 0,20";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + descripcion + "%");
            pst.setString(2, "%" + descripcion + "%");
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                registros[0] = rs.getString("idep");
                registros[1] = rs.getString("fecha_hora_ingreso");
                registros[2] = rs.getString("lote");
                registros[3] = rs.getString("pSerie");
                registros[4] = rs.getString("pDescripcion");
                registros[5] = rs.getString("pCondicion");
                registros[6] = rs.getString("catNombre");
                registros[7] = rs.getString("maNombre");
                registros[8] = rs.getString("mPresentacion");
                registros[9] = rs.getString("presentacion");
                registros[10] = rs.getString("equivalencia");
                registros[11] = rs.getString("fechaVcto");
                registros[12] = rs.getString("stockPresentacion");
                registros[13] = rs.getString("stockEquivalencia");
                registros[14] = rs.getString("precioCompraPresentacion");
                registros[15] = rs.getString("precioCompraEquivalencia");
                registros[16] = rs.getString("margenGananciaPresentacion");
                registros[17] = rs.getString("margenGananciaEquivalencia");
                registros[18] = rs.getString("precioVentaPresentacionMayor");
                registros[19] = rs.getString("precioVentaPresentacionMenor");
                registros[20] = rs.getString("precioVentaEquivaleniaMayor");
                registros[21] = rs.getString("precioVentaEquivaleniaMenor");
                registros[22] = rs.getString("ref");
                registros[23] = rs.getString("tienda");

                modelo.addRow(registros);

            }

            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Entrada Producto Venta BD...", JOptionPane.ERROR_MESSAGE);

            return null;

        }
        return modelo;

    }

    public boolean modificarPrecioProducto(EntradaProducto ep) {

        boolean rpta = false;
        sql = "UPDATE entradaProducto SET margenGananciaPresentacion=?,margenGananciaEquivalencia=?,precioVentaPresentacionMayor=?,precioVentaEquivaleniaMayor=? WHERE idep=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, ep.getMargenGananciaPresentacion());
            pst.setInt(2, ep.getMargenGananciaEquivalencia());
            pst.setDouble(3, ep.getPrecioVentaPresentacionMayor());
            pst.setDouble(4, ep.getPrecioVentaEquivalenciaMayor());
            pst.setInt(5, ep.getIdep());

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return rpta;
        }
        return rpta;
    }

}
