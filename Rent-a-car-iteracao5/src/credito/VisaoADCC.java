/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package credito;

import java.util.Date;

/**
 *
 * @author i100642
 */
public class VisaoADCC implements InterfaceADCC{
    String status;
    Date data;
    AutorizacaoDebitoCartaoCredito adcc;
    
    public VisaoADCC(String strNumCC, Date dataValidade, float fValorADCC){
        adcc = new AutorizacaoDebitoCartaoCredito(strNumCC, dataValidade.toString(), fValorADCC);
        data = new Date();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        status = newStatus;
    }

    public Date getDate() {
        return data;
    }

    public void setDate(Date newDate) {
        data = newDate;
    }

    public AutorizacaoDebitoCartaoCredito getAdcc() {
        return adcc;
    }

    public void setAdcc(AutorizacaoDebitoCartaoCredito newAdcc) {
        adcc = newAdcc;
    }
    
    public String toString(){
        return adcc.toString();
    }
}
