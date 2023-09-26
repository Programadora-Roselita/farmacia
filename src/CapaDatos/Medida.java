/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

/**
 *
 * @author ROSELITA
 */
public class Medida {

    private int idmedida;
    private String PrePresentacion;
    private String PreEquivalencia;

    public Medida() {
    }

    public Medida(int idmedida, String PrePresentacion, String PreEquivalencia) {
        this.idmedida = idmedida;
        this.PrePresentacion = PrePresentacion;
        this.PreEquivalencia = PreEquivalencia;
    }

    public int getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(int idmedida) {
        this.idmedida = idmedida;
    }

    public String getPrePresentacion() {
        return PrePresentacion;
    }

    public void setPrePresentacion(String PrePresentacion) {
        this.PrePresentacion = PrePresentacion;
    }

    public String getPreEquivalencia() {
        return PreEquivalencia;
    }

    public void setPreEquivalencia(String PreEquivalencia) {
        this.PreEquivalencia = PreEquivalencia;
    }
    
    

}
