/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Kardex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author ROSELITA
 */
public class KardexBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarKardex(Kardex k) {

        boolean rpta = false;
        sql = "INSERT INTO kardex(idkardex,fecha,hora,tipoOperacion,kDescripcion,pSerie,lote,presentacion,kCantidad,kPrecio,kImporte,tienda,idventa) "
                + "VALUES (0,?,?,?,?,?,?,?,?,?,?,?,?";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, k.getFecha());
            pst.setString(2, k.getHora());
            pst.setString(3, k.getTipoOperacion());
            pst.setString(4, k.getkDescripcion());
            pst.setString(5, k.getpSerie());
            pst.setString(6, k.getLote());
            pst.setString(7, k.getPresentacion());
            pst.setDouble(8, k.getkCantidad());
            pst.setDouble(9, k.getkPrecio());
            pst.setDouble(10, k.getkImporte());
            pst.setString(11, k.getTienda());
            pst.setInt(12, k.getIdventa());

            rpta = pst.executeUpdate() == 1 ? true : false;
            pst.close();
            cn.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas al registrar Idkardex BD", JOptionPane.ERROR_MESSAGE);
            return rpta;

        }
        return rpta;
    }
    

}
