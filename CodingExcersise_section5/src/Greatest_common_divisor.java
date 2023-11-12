public class Greatest_common_divisor {
    public static void main(String[] args) {
        int a;
        a=getGreatesCommonDivisor(25,15);
        System.out.println(a);
    }
    public static  int getGreatesCommonDivisor(int first, int second){
        int gcd=-1;

        if (first<10 || second<10)
            return gcd;

        else {
            int min;

            min = (first < second) ? first : second;

            for (int i = 1; i <= min; i++) {
                if (first % i == 0 && (second % i == 0)) {
                    gcd = i;
                }
            }
        }
        return gcd;
    }
}
