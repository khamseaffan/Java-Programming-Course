public class SpeedConverter {
    public static void main(String[] args) {

        double kmph = 95.75;
        printConversion(kmph);
        long r = Math.round(0.76);
        System.out.println(r);
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        long rounded;
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            rounded = Math.round((kilometersPerHour * 0.62148));
            return rounded;

        }

    }

    public static void printConversion(double kilometersPerHour) {

        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
                long milehour = toMilesPerHour(kilometersPerHour);
                System.out.println( kilometersPerHour + " km/h = " +milehour + " mi/h");
        }
    }
}


