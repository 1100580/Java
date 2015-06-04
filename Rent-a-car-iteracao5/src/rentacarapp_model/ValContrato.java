/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacarapp_model;

import descontos.IDesc;

/**
 *
 * @author Bessa
 */
public class ValContrato {
    private float valTotal;
    private float valDiario;
    private float valSA;
    private long dias;
    private IDesc desconto;
    
    public ValContrato(){
        setValTotal(0);
        setValDiario(0);
        setValSA(0);
        setDias(0);
    }

    /**
     * @return the valTotal
     */
    public float getValTotal() {
        return valTotal;
    }

    /**
     * @param valTotal the valTotal to set
     */
    public void setValTotal(float valTotal) {
        this.valTotal = valTotal;
    }

    /**
     * @return the valDiario
     */
    public float getValDiario() {
        return valDiario;
    }

    /**
     * @param valDiario the valDiario to set
     */
    public void setValDiario(float valDiario) {
        this.valDiario = valDiario;
    }

    /**
     * @return the valSA
     */
    public float getValSA() {
        return valSA;
    }

    /**
     * @param valSA the valSA to set
     */
    public void setValSA(float valSA) {
        this.valSA = valSA;
    }

    /**
     * @return the dias
     */
    public long getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(long dias) {
        this.dias = dias;
    }

    public void calculateValTotal() {
        valTotal = valDiario*dias + valSA;
    }

    public void desconta(float valorDesconto) {
        valTotal-= valorDesconto;
    }

    public void setDesconto(IDesc id) {
        desconto = id;
    }

    public IDesc getIDesc() {
        return desconto;
    }
    
}
