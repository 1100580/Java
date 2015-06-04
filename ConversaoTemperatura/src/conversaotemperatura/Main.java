
package conversaotemperatura;

public class Main {
    public static void main(String[] args){
    
        TemperaturaCelsius t1 = new TemperaturaCelsius(0);

        System.out.println(ConversorTemperatura.converteCelsiusParaFahrenheit(0));
        System.out.println(ConversorTemperatura.converteFahrenheitParaCelsius(32));
        
        System.out.println(ConversorTemperatura.converteCelsiusParaFahrenheit(10));
        System.out.println(ConversorTemperatura.converteFahrenheitParaCelsius(50));
    }
}
