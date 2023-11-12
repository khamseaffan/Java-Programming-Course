public class SumOdd {
    public static void main(String[] args) {
        System.out.println(sumOdd(10,10));
    }

        public static boolean isOdd(int number){
            if (number<0){
                return false;
            }
            else if(number%2==0){
                return false;

            }
            return true;

        }
        public static int sumOdd(int start, int stop){
            int sum = 0;
            if ( (start <0 || stop<0) || stop<start ){
                return -1;
            }
            else {
                for (int i = start; i <= stop; i++) {
                    if (isOdd(i)) {
                        sum = sum + i;

                    }
                }
                return sum;
            }
        }



}
