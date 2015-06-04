/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testesjunit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author i090674
 */
public class TemperaturaCelsiusTest {

    public TemperaturaCelsiusTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of converteCelsiusParaFahrenheit method, of class TemperaturaCelsius.
     */
    @Test
    public void testConverteCelsiusParaFahrenheit() {
        System.out.println("converteCelsiusParaFahrenheit");
        TemperaturaCelsius instance = new TemperaturaCelsius(0);
        double expResult = 32.0;
        double result = instance.converteCelsiusParaFahrenheit();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}