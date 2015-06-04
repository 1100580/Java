/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package credito;

import java.util.Date;
import pt.ipp.isep.dei.eapli.canadaexpress.CanadaExpress;
import pt.ipp.isep.dei.eapli.canadaexpress.Pedido;

/**
 *
 * @author Bessa
 */
public class SistCanadaAdapter implements SistACCAAdapter {
    public SistCanadaAdapter(){
        
    }

    public InterfaceADCC autorizacaoDebito(Date dataValidade, String strNumCC, float fValorADCC, Date dataLimite) {
        Pedido p = new Pedido(dataValidade, strNumCC, fValorADCC, dataLimite);
        CanadaExpress ce = new CanadaExpress();
        ce.Init("#CANADA#EXPRESS#EAPLI#");
        String ac = ce.ValidaPedido(p);
        ce.Finish();
        
        InterfaceADCC iadcc = new CanadaADCC(strNumCC, dataValidade, fValorADCC);
        
        if(!("**inválida**".equals(ac))){
            iadcc.setStatus("NOT OK");
        }else{
            iadcc.setStatus("OK");
        }
        
        return iadcc;
    }
}
