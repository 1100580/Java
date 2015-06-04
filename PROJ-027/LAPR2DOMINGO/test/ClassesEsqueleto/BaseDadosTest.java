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
public class BaseDadosTest {

    public BaseDadosTest() {
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
     * Test of resetCursos method, of class BaseDados.
     */
    @Test
    public void testResetCursos() {
        System.out.println("resetCursos");
        BaseDados instance = new BaseDados();
        instance.resetCursos();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of gravaBaseDados method, of class BaseDados.
     */
    @Test
    public void testGravaBaseDados() throws Exception {
        System.out.println("gravaBaseDados");
        BaseDados instance = new BaseDados();
        instance.gravaBaseDados();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of carregaBaseDados method, of class BaseDados.
     */
    @Test
    public void testCarregaBaseDados() throws Exception {
        System.out.println("carregaBaseDados");
        BaseDados instance = new BaseDados();
        BaseDados expResult = instance.carregaBaseDados();
        BaseDados result = instance.carregaBaseDados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCursos method, of class BaseDados.
     */
    @Test
    public void testGetCursos() {
        System.out.println("getCursos");
        BaseDados instance = new BaseDados();
        ArrayL expResult = instance.getCursos();
        ArrayL result = instance.getCursos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

}