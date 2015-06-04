/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package descontos;

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
import rentacarapp_controller.ElaborarContratoController;
import rentacarapp_model.ContratoAluguer;
import rentacarapp_model.*;

/**
 *
 * @author Vilaca
 */
public class D1AdapterTest {

    private static ContratoAluguer ca = new ContratoAluguer();
    private static Empresa emp = new Empresa();

    public D1AdapterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Automovel a = emp.getFrota().getFrotaByGrupoAutomovel(emp.getCatalogoGrupoAutomovel().get(0)).get(0);
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
    public void testValorDescontoIF1() {
        System.out.println("valorDescontoIF1");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date a2;
        try {
            a2 = f.parse("2012-05-17");
            ca.setDataDevolucaoPrevista(a2);
        } catch (Exception ex) {
            Logger.getLogger(D1AdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ca.calculaValorTotal();
        D1Adapter instance = new D1Adapter();
        instance.valorDesconto(ca);
        assertEquals(2.7, instance.getValorDesconto(), 0.1);
    }

    @Test
    public void testValorDescontoIF2() {
        System.out.println("valorDescontoIF2");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date a2;
        try {
            a2 = f.parse("2012-05-23");
            ca.setDataDevolucaoPrevista(a2);
        } catch (Exception ex) {
            Logger.getLogger(D1AdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ca.calculaValorTotal();
        D1Adapter instance = new D1Adapter();
        instance.valorDesconto(ca);
        assertEquals(5.25, instance.getValorDesconto(), 0.1);
    }

    @Test
    public void testValorDescontoIF3() {
        System.out.println("valorDescontoIF3");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date a2;
        try {
            a2 = f.parse("2012-06-07");
            ca.setDataDevolucaoPrevista(a2);
        } catch (Exception ex) {
            Logger.getLogger(D1AdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ca.calculaValorTotal();
        D1Adapter instance = new D1Adapter();
        instance.valorDesconto(ca);
        assertEquals(42, instance.getValorDesconto(), 0.1);
    }

    @Test
    public void DataInvalida() {
        System.out.println("DataInvalida");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date a2;
        try {
            a2 = f.parse("2011-06-07");
            ca.setDataDevolucaoPrevista(a2);
        } catch (Exception ex) {
            Logger.getLogger(D1AdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        ca.calculaValorTotal();
        D1Adapter instance = new D1Adapter();

        instance.valorDesconto(ca);

        assertEquals(0, instance.getValorDesconto(), 0.1);
    }
}
