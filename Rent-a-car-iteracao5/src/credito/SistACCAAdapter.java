/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package credito;

import java.util.Date;

/**
 *
 * @author Bessa
 */
public interface SistACCAAdapter {

    public InterfaceADCC autorizacaoDebito(Date dataValidade, String strNumCC, float fValorADCC, Date dataLimite);
}
