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
public class ConversorTemperaturaTest {

    public ConversorTemperaturaTest() {
    }

   

    /**
     * Test of converteCelsiusParaFahrenheit method, of class ConversorTemperatura.
     */
    @Test
    public void testConverteCelsiusParaFahrenheit() {
        System.out.println("converteCelsiusParaFahrenheit");
        double celsius = 0.0;
        double expResult = 32.0;
        double result = ConversorTemperatura.converteCelsiusParaFahrenheit(celsius);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of converteFahrenheitParaCelsius method, of class ConversorTemperatura.
     */
    @Test
    public void testConverteFahrenheitParaCelsius() {
        System.out.println("converteFahrenheitParaCelsius");
        double fahrenheit = 50.0;
        double expResult = 10.0;
        double result = ConversorTemperatura.converteFahrenheitParaCelsius(fahrenheit);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
     
    }

}