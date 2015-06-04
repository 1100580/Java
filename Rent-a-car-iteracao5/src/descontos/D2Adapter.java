
package descontos;

import rentacarapp_model.ContratoAluguer;

public class D2Adapter implements IDesc {
    private float descPorDia, descSA, valTotal;
    private ContratoAluguer m_contratoAluguer;
    private float descontoTotal;
    
    public void valorDesconto(ContratoAluguer m_contratoAluguer){
        valTotal=m_contratoAluguer.getValorAcumulado();
        if (valTotal<=500) {
            descPorDia=0;
            descSA=0;
        }else{
            if (valTotal>500 && valTotal<=1000) {
                descPorDia= (float) 0.10 * m_contratoAluguer.getValDiario() * m_contratoAluguer.getDias();
                descSA= (float) 0.25 * m_contratoAluguer.getValSA();
            }else{
                if (valTotal>1000) {
                    descPorDia= (float) 0.20 * m_contratoAluguer.getValDiario() * m_contratoAluguer.getDias();
                    descSA= (float) 0.50 * m_contratoAluguer.getValSA();
                }
            }
        }
        descontoTotal = descPorDia+descSA;
    }

    public float getValorDesconto() {
        return descontoTotal;
    }
}
