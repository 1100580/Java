package credito;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SistACCFactory {
    private static SistACCFactory inst = new SistACCFactory();
    
    private SistACCFactory(){
        try{
            FileInputStream prop_file=new FileInputStream("Versao.config");
            Properties prop=new Properties(System.getProperties());
            prop.load(prop_file);
            System.setProperties(prop);
        }catch(Exception e){
            System.setProperty("Versao", "credito.SistVisaoAdapter");
        }
    }
    
    public static SistACCFactory getInstance(){
        return inst;
    }

    public SistACCAAdapter getSistAutorizacaoCartaoCredito() {
        String strClassName=System.getProperty("Versao");
        try{
            return (SistACCAAdapter) Class.forName(strClassName).newInstance();
        }catch(Exception e){
            Logger.getLogger("Rent-a-car").log(Level.SEVERE,null,e);
            return null;
        }
    }
}
