interface UnitConverter {

    // Convert kilometers to miles
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // Convert miles to kilometers
    static double milesToKm(double miles) {
        return miles / 0.621371;
    }

    // Convert kilograms to pounds
    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }

    // Convert pounds to kilograms
    static double lbsToKg(double lbs) {
        return lbs / 2.20462;
    }
}

// Main class to test
public class UnitConverter {
    public static void main(String[] args) {
        double km = 10;
        double miles = 6.2;
        double kg = 50;
        double lbs = 110;

        System.out.println(km + " km = " + UnitConverter.kmToMiles(km) + " miles");
        System.out.println(miles + " miles = " + UnitConverter.milesToKm(miles) + " km");
        System.out.println(kg + " kg = " + UnitConverter.kgToLbs(kg) + " lbs");
        System.out.println(lbs + " lbs = " + UnitConverter.lbsToKg(lbs) + " kg");
    }
}
