/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package descontos;

import rentacarapp_model.ContratoAluguer;

/**
 *
 * @author Bessa
 */
public class D1Adapter implements IDesc {
    private float descontoTotal = 0;
    
    public void valorDesconto(ContratoAluguer ca) {
        long dias = ca.getDias();
        if (dias >= 6 && dias <= 15) {
            descontoTotal = ca.getValorTotal() * (float) 0.05;
        } else if (dias >= 16 && dias <= 29) {
            descontoTotal = (ca.getValDiario() * dias) * (float) 0.05;
            descontoTotal += (ca.getValSA() * (float) 0.25);
        } else if (dias >= 30) {
            descontoTotal = ca.getValorTotal() * (float) 0.25;
            descontoTotal += ca.getValSA() * (float) 0.50;
        }
    }

    public float getValorDesconto() {
        return descontoTotal;
    }
    
}
