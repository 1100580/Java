/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassesEsqueleto;

import Motor.ArrayL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grupo 27
 */
public class UCTest {

    public UCTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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

    /**
     * Test of getAnoUC method, of class UC.
     */
    @Test
    public void testGetAnoUC() {
        System.out.println("getAnoUC");
        UC instance = new UC("123", 1);
        int expResult = 1;
        int result = instance.getAnoUC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAnoUC method, of class UC.
     */
    @Test
    public void testSetAnoUC() {
        System.out.println("setAnoUC");
        int anoUC = 1;
        UC instance = new UC("123", 1);
        instance.setAnoUC(anoUC);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIdUC method, of class UC.
     */
    @Test
    public void testGetIdUC() {
        System.out.println("getIdUC");
        UC instance = new UC("123", 1);
        String expResult = "123";
        String result = instance.getIdUC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setIdUC method, of class UC.
     */
    @Test
    public void testSetIdUC() {
        System.out.println("setIdUC");
        String idUC = "123";
        UC instance = new UC("123", 1);
        instance.setIdUC(idUC);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEpocas method, of class UC.
     */
    @Test
    public void testGetEpocas() {
        System.out.println("getEpocas");
        UC instance = new UC("123", 1);
        ArrayL expResult = instance.getEpocas();
        ArrayL result = instance.getEpocas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of retornaTipoEpoca method, of class UC.
     */
    @Test
    public void testRetornaTipoEpoca() {
        System.out.println("retornaTipoEpoca");
        int indexEpocas = 0;
        UC instance = new UC("123", 1);
        String expResult = instance.retornaTipoEpoca(indexEpocas);
        String result = instance.retornaTipoEpoca(indexEpocas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class UC.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UC instance = new UC("123", 1);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPautas method, of class UC.
     */
    @Test
    public void testGetPautas() {
        System.out.println("getPautas");
        UC instance = new UC("123", 1);
        ArrayL expResult = instance.getPautas();
        ArrayL result = instance.getPautas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}