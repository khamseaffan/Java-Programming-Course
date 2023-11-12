public class pALINDROME {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
    }
    public static boolean isPalindrome(int number){

            int numc = number;
            int reverse = 0;
            int digit;
            while (numc != 0) {
                digit = numc % 10;
                reverse = reverse * 10 + digit;
                numc = numc / 10;
            }
            if (number==reverse){
                return true;

            }
            else
                return false;

    }

}
