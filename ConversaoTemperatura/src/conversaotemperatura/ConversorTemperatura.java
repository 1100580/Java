/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conversaotemperatura;

/**
 *
 * @author Lobito
 */
public class ConversorTemperatura {
    public static double converteCelsiusParaFahrenheit(double celsius) {
       double fahrenheit = 1.8*celsius+32;	// f =1,8*c+32
       return fahrenheit;
    }

    public static double converteFahrenheitParaCelsius(double fahrenheit) {
        double celsius = (5.0/9)*(fahrenheit-32);	// c =(5/9)*(f-32)
        return celsius;
    }
}
