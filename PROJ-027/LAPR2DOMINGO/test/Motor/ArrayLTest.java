/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Motor;

import ClassesEsqueleto.Aluno;
import ClassesEsqueleto.BaseDadosCurso;
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
public class ArrayLTest {

    public ArrayLTest() {
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
     * Test of adiciona method, of class ArrayL.
     */
    @Test
    public void testAdiciona_Object() {
        System.out.println("adiciona");
        Object novo = new Object();
        ArrayL instance = new ArrayL();
        instance.adiciona(novo);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of remove method, of class ArrayL.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 0;
        ArrayL instance = new ArrayL();
        instance.remove(index);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIndex method, of class ArrayL.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        int index = 0;
        ArrayL instance = new ArrayL();
        Object expResult = instance.getIndex(index);
        Object result = instance.getIndex(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getTamanho method, of class ArrayL.
     */
    @Test
    public void testGetTamanho() {
        System.out.println("getTamanho");
        ArrayL instance = new ArrayL();
        int expResult = 0;
        int result = instance.getTamanho();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listar method, of class ArrayL.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        ArrayL instance = new ArrayL();
        String expResult = instance.listar();
        String result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of contains method, of class ArrayL.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object aluno = new Object();
        ArrayL instance = new ArrayL();
        boolean expResult = false;
        boolean result = instance.contains(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of remove method, of class ArrayL.
     */
    @Test
    public void testRemove_Aluno() {
        System.out.println("remove");
        Aluno alunoT = new Aluno(1101513,1);
        ArrayL instance = new ArrayL();
        instance.remove(alunoT);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of remove method, of class ArrayL.
     */
    @Test
    public void testRemove_BaseDadosCurso() throws Exception {
        System.out.println("remove");
        BaseDadosCurso curso =  new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        ArrayL instance = new ArrayL();
        instance.remove(curso);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getArray method, of class ArrayL.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        ArrayL instance = new ArrayL();
        Object[] expResult = instance.getArray();
        Object[] result = instance.getArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of adiciona method, of class ArrayL.
     */
    @Test
    public void testAdiciona_Object_int() {
        System.out.println("adiciona");
        Object novo = new Object();
        int index = 0;
        ArrayL instance = new ArrayL();
        instance.adiciona(novo, index);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}