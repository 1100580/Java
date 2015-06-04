/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassesEsqueleto;

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
public class AlunoTest {

    public AlunoTest() {
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
     * Test of getNumAluno method, of class Aluno.
     */
    @Test
    public void testGetNumAluno() {
        System.out.println("getNumAluno");
        Aluno instance = new Aluno(1101513, 1);
        int expResult = 1101513;
        int result = instance.getNumAluno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setNumAluno method, of class Aluno.
     */
    @Test
    public void testSetNumAluno() {
        System.out.println("setNumAluno");
        int numAluno = 1101513;
        Aluno instance = new Aluno(1101513, 1);
        instance.setNumAluno(numAluno);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getAnoAluno method, of class Aluno.
     */
    @Test
    public void testGetAnoAluno() {
        System.out.println("getAnoAluno");
        Aluno instance = new Aluno(1101513, 1);
        int expResult = 1;
        int result = instance.getAnoAluno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of setAnoAluno method, of class Aluno.
     */
    @Test
    public void testSetAnoAluno() {
        System.out.println("setAnoAluno");
        int anoAluno = 1;
        Aluno instance = new Aluno(1101513, 1);
        instance.setAnoAluno(anoAluno);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Aluno.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Aluno instance = new Aluno(1101513, 1);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getDiscipAR method, of class Aluno.
     */
    @Test
    public void testGetDiscipAR() {
        System.out.println("getDiscipAR");
        Aluno instance = new Aluno(1101513, 1);
        String[] expResult = instance.getDiscipAR();
        String[] result = instance.getDiscipAR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}