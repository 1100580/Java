/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Motor;

import ClassesEsqueleto.BaseDadosCurso;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomé
 */
public class TrataEstatisticaTest {

    public TrataEstatisticaTest() {
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
     * Test of trataAmostra method, of class TrataEstatistica.
     */
    @Test
    public void testTrataAmostra() throws Exception {
        System.out.println("trataAmostra");
        BaseDadosCurso b = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        TrataEstatistica instance = new TrataEstatistica();
        instance.trataAmostra(b);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of trataResUcs method, of class TrataEstatistica.
     */
    @Test
    public void testTrataResUcs() throws Exception {
        System.out.println("trataResUcs");
        BaseDadosCurso b = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        TrataEstatistica instance = new TrataEstatistica();
        instance.trataResUcs(b);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of trataResAlunos method, of class TrataEstatistica.
     */
    @Test
    public void testTrataResAlunos() throws Exception {
        System.out.println("trataResAlunos");
        BaseDadosCurso b = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        TrataEstatistica instance = new TrataEstatistica();
        instance.trataResAlunos(b);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of adicionaResCadeiras method, of class TrataEstatistica.
     */
    @Test
    public void testAdicionaResCadeiras() throws Exception {
        System.out.println("adicionaResCadeiras");
        BaseDadosCurso b = new BaseDadosCurso("Engenharia Informática", "LEI", 101, "2009-2010");
        TrataEstatistica instance = new TrataEstatistica();
        instance.adicionaResCadeiras(b);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}