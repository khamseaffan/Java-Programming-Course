public class first_and_last_digit_sum {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(24423));
    }
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int firstDigit = 0;
        int lastDigit = number % 10;

        while (number > 0) {
            firstDigit = number % 10;
            number /= 10;
        }

        return firstDigit + lastDigit;

    }
}
