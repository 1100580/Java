    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package descontos;

import rentacarapp_model.ContratoAluguer;

public class D3Adapter implements IDesc {
    private float descontoTotal = 0;
    
    public void valorDesconto(ContratoAluguer ca) {
        D1Adapter d1 = new D1Adapter();
        D2Adapter d2 = new D2Adapter();
        d1.valorDesconto(ca);
        d2.valorDesconto(ca);
        if (d1.getValorDesconto() >= d2.getValorDesconto()) {
            descontoTotal = d1.getValorDesconto();
        }else{
            descontoTotal = d2.getValorDesconto();
        }
    }

    public float getValorDesconto() {
        return descontoTotal;
    }
    
}
