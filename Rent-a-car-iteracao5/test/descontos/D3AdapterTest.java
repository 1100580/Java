/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package descontos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rentacarapp_model.*;

public class D3AdapterTest {
    
    private static ContratoAluguer ca=new ContratoAluguer();
    private static Empresa emp=new Empresa();
    
    public D3AdapterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
     
        Automovel a=emp.getFrota().getFrotaByGrupoAutomovel(emp.getCatalogoGrupoAutomovel().get(0)).get(0);
        ca.setAutomovel(a);
        ca.addServicoAdicional(emp.getCatalogoServicoAdicional().get(1), 1);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValorDescontoPD2() throws ParseException {
        System.out.println("valorDescontoPD2");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date data;
        data = f.parse("2012-05-17");
        ca.setDataDevolucaoPrevista(data);
        ca.calculaValorTotal();
        D3Adapter instance = new D3Adapter();
        instance.valorDesconto(ca);
        assertEquals(2.75, instance.getValorDesconto(), 0.1);
    }
    @Test
    public void testValorDescontoPD1() {
        System.out.println("valorDescontoPD1");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date a2;
        try {
            a2 = f.parse("2012-06-07");
            ca.setDataDevolucaoPrevista(a2);
        } catch (Exception ex) {
            Logger.getLogger(D1AdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ca.calculaValorTotal();
        D3Adapter instance = new D3Adapter();
        instance.valorDesconto(ca);
        assertEquals(42.0, instance.getValorDesconto(), 0.1);
    }

}
