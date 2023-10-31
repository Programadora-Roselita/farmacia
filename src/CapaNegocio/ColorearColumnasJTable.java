/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ROSELITA
 */
public class ColorearColumnasJTable extends DefaultTableCellRenderer {

    private int columna;
    private Color color_fondo;

    public ColorearColumnasJTable(int columna, Color color_fondo) {
        this.columna = columna;
        this.color_fondo = color_fondo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == column) {
            c.setBackground(color_fondo);

        } else {

            c.setBackground(table.getBackground());

        }
        return c;
    }

}
