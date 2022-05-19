package utils;

// Utility class for Weight objects
public class WeightUtil {
    // Method to convert kilograms to pounds
    public static double kgTolb(long kg) { return kg * 2.2046;}

    // Method to convert pounds to kilograms
    public static double lbTokg(long lb) {
        return lb / 2.205;
    }
}
