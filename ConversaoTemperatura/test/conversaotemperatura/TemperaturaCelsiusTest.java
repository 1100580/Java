/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conversaotemperatura;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lobito
 */
public class TemperaturaCelsiusTest {

    public TemperaturaCelsiusTest() {
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
    }

}