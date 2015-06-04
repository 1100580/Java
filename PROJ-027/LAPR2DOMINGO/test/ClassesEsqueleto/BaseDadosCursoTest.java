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
public class BaseDadosCursoTest {

    public BaseDadosCursoTest() {
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
     * Test of carregaAlunos method, of class BaseDadosCurso.
     */
    @Test
    public void testCarregaAlunos() throws Exception {
        System.out.println("carregaAlunos");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        instance.carregaAlunos();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of carregaUCSeEpocas method, of class BaseDadosCurso.
     */
    @Test
    public void testCarregaUCSeEpocas() throws Exception {
        System.out.println("carregaUCSeEpocas");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        instance.carregaUCSeEpocas();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of carregaPautas method, of class BaseDadosCurso.
     */
    @Test
    public void testCarregaPautas() throws Exception {
        System.out.println("carregaPautas");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        instance.carregaPautas();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of carregaPautaManual method, of class BaseDadosCurso.
     */
    @Test
    public void testCarregaPautaManual() throws Exception {
        System.out.println("carregaPautaManual");
        UC uc = new UC("123", 1);
        String epoca = "NFAFER";
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        instance.carregaPautaManual(uc, epoca);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getArrayL method, of class BaseDadosCurso.
     */
    @Test
    public void testGetArrayL() throws Exception {
        System.out.println("getArrayL");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        ArrayL expResult = instance.getArrayL();
        ArrayL result = instance.getArrayL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTituloCurso method, of class BaseDadosCurso.
     */
    @Test
    public void testGetTituloCurso() throws Exception {
        System.out.println("getTituloCurso");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        String expResult = "Engenharia Informática";
        String result = instance.getTituloCurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setTituloCurso method, of class BaseDadosCurso.
     */
    @Test
    public void testSetTituloCurso() throws Exception {
        System.out.println("setTituloCurso");
        String tituloCurso = "Engenharia Informática";
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        instance.setTituloCurso(tituloCurso);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIdCurso method, of class BaseDadosCurso.
     */
    @Test
    public void testGetIdCurso() throws Exception {
        System.out.println("getIdCurso");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        int expResult = 101;
        int result = instance.getIdCurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setIdCurso method, of class BaseDadosCurso.
     */
    @Test
    public void testSetIdCurso() throws Exception {
        System.out.println("setIdCurso");
        int idCurso = 101;
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        instance.setIdCurso(idCurso);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAnoCurso method, of class BaseDadosCurso.
     */
    @Test
    public void testGetAnoCurso() throws Exception {
        System.out.println("getAnoCurso");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        String expResult = "2009-2010";
        String result = instance.getAnoCurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setAnoCurso method, of class BaseDadosCurso.
     */
    @Test
    public void testSetAnoCurso() throws Exception {
        System.out.println("setAnoCurso");
        String anoCurso = "2009-2010";
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        instance.setAnoCurso(anoCurso);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSiglaCurso method, of class BaseDadosCurso.
     */
    @Test
    public void testGetSiglaCurso() throws Exception {
        System.out.println("getSiglaCurso");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        String expResult = "LEI";
        String result = instance.getSiglaCurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSiglaCurso method, of class BaseDadosCurso.
     */
    @Test
    public void testSetSiglaCurso() throws Exception {
        System.out.println("setSiglaCurso");
        String siglaCurso = "LEI";
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        instance.setSiglaCurso(siglaCurso);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class BaseDadosCurso.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        BaseDadosCurso instance = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}