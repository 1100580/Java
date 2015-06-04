/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package credito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.eapli.visaolight.VisaoLight;

/**
 *
 * @author Bessa
 */
public class SistVisaoAdapter implements SistACCAAdapter {
    public SistVisaoAdapter(){
        
    }

    public InterfaceADCC autorizacaoDebito(Date dataValidade, String strNumCC, float fValorADCC, Date dataLimite) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd"); 
        try {
            dataValidade = formatador.parse(dataValidade.toString());
            dataLimite = formatador.parse(dataLimite.toString());
        } catch (ParseException ex) {
            Logger.getLogger(SistVisaoAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dat = VisaoLight.getAutorizacaoDCC(strNumCC, dataValidade.toString(), fValorADCC, dataLimite.toString());
        InterfaceADCC iadcc = new VisaoADCC(strNumCC, dataValidade, fValorADCC);
        
        if (dat != null) {
            iadcc.setStatus("OK");
        }else{
            iadcc.setStatus("NOT OK");
        }
        return iadcc;
    }
}
