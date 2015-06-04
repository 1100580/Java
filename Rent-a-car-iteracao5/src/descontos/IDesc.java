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
public interface IDesc {
    public void valorDesconto(ContratoAluguer ca);
    public float getValorDesconto();
}
