/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Motor;

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
public class LerPautaTest {

    public LerPautaTest() {
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
     * Test of getPauta method, of class LerPauta.
     */
    @Test
    public void testGetPauta() throws Exception {
        System.out.println("getPauta");
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        String[][] expResult = instance.getPauta();
        String[][] result = instance.getPauta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCelula method, of class LerPauta.
     */
    @Test
    public void testGetCelula() throws Exception {
        System.out.println("getCelula");
        int i = 0;
        int j = 0;
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        String expResult = instance.getCelula(i, j);
        String result = instance.getCelula(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listaPauta method, of class LerPauta.
     */
    @Test
    public void testListaPauta() throws Exception {
        System.out.println("listaPauta");
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        instance.listaPauta();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getTipo method, of class LerPauta.
     */
    @Test
    public void testGetTipo() throws Exception {
        System.out.println("getTipo");
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        String expResult = instance.getTipo();
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTipo method, of class LerPauta.
     */
    @Test
    public void testSetTipo() throws Exception {
        System.out.println("setTipo");
        String tipo = "RE";
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getnLin method, of class LerPauta.
     */
    @Test
    public void testGetnLin() throws Exception {
        System.out.println("getnLin");
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        int expResult = instance.getnLin();
        int result = instance.getnLin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getnCol method, of class LerPauta.
     */
    @Test
    public void testGetnCol() throws Exception {
        System.out.println("getnCol");
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        int expResult = instance.getnCol();
        int result = instance.getnCol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of getEpoca method, of class LerPauta.
     */
    @Test
    public void testGetEpoca() throws Exception {
        System.out.println("getEpoca");
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        String expResult = instance.getEpoca();
        String result = instance.getEpoca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEpoca method, of class LerPauta.
     */
    @Test
    public void testSetEpoca() throws Exception {
        System.out.println("setEpoca");
        String epoca = "RE";
        LerPauta instance = new LerPauta("src\\ficheiros\\UC01_RE_2009-2010");
        instance.setEpoca(epoca);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}