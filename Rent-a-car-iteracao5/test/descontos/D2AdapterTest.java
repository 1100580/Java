/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package descontos;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rentacarapp_model.ContratoAluguer;
import rentacarapp_model.*;

/**
 *
 * @author Vilaca
 */
public class D2AdapterTest {
    
    private static ContratoAluguer ca;
    private static Empresa emp;
    
    public D2AdapterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ca = new ContratoAluguer();
        emp = new Empresa();
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date data;
        data = f.parse("2012-05-16");
        ca.setDataDevolucaoPrevista(data);
        Automovel a = emp.getFrota().getFrotaByGrupoAutomovel(emp.getCatalogoGrupoAutomovel().get(0)).get(0);
        ca.setAutomovel(a);
        ca.addServicoAdicional(emp.getCatalogoServicoAdicional().get(1), 1);
        ca.calculaValorTotal();
    }    
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Test
    public void testValorDesconto1() {
        System.out.println("valorDesconto");
        D2Adapter instance = new D2Adapter();
        instance.valorDesconto(ca);
        assertEquals(0, instance.getValorDesconto(), 0.1);
    }
    
    @Test
    public void testValorDesconto2() {
        System.out.println("valorDesconto");
        D2Adapter instance = new D2Adapter();
        ca.setValorAcumulado(600);
        instance.valorDesconto(ca);
        assertEquals(6.0, instance.getValorDesconto(), 0.1);
    }
    
    @Test
    public void testValorDesconto3() {
        System.out.println("valorDesconto");
        D2Adapter instance = new D2Adapter();
        ca.setValorAcumulado(1600);
        instance.valorDesconto(ca);
        assertEquals(12.0, instance.getValorDesconto(), 0.1);
    }
}
