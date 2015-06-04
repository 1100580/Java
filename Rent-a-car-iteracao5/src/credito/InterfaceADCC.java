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
public interface InterfaceADCC {
    public AutorizacaoDebitoCartaoCredito getAdcc();
    public void setAdcc(AutorizacaoDebitoCartaoCredito adcc);
    public String getStatus();
    public void setStatus(String newStatus);
    public Date getDate();
    public void setDate(Date newDate);
    public String toString();
}
