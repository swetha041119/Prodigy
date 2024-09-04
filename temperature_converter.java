import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return fahrenheitToCelsius(fahrenheit) + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }

    public static void convertTemperature(double value, String unit) {
        switch (unit.toUpperCase()) {
            case "C":
                double fahrenheitFromCelsius = celsiusToFahrenheit(value);
                double kelvinFromCelsius = celsiusToKelvin(value);
                System.out.println(value + "°C is " + fahrenheitFromCelsius + "°F and " + kelvinFromCelsius + "K");
                break;
            case "F":
                double celsiusFromFahrenheit = fahrenheitToCelsius(value);
                double kelvinFromFahrenheit = fahrenheitToKelvin(value);
                System.out.println(value + "°F is " + celsiusFromFahrenheit + "°C and " + kelvinFromFahrenheit + "K");
                break;
            case "K":
                double celsiusFromKelvin = kelvinToCelsius(value);
                double fahrenheitFromKelvin = kelvinToFahrenheit(value);
                System.out.println(value + "K is " + celsiusFromKelvin + "°C and " + fahrenheitFromKelvin + "°F");
                break;
            default:
                System.out.println("Invalid unit. Please enter 'C' for Celsius, 'F' for Fahrenheit, or 'K' for Kelvin.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature value: ");
        double temp = scanner.nextDouble();

        System.out.print("Enter the unit of the temperature (C, F, K): ");
        String unit = scanner.next();

        convertTemperature(temp, unit);
        
        scanner.close();
    }
}