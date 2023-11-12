public class NumberToWords {
    public static void main(String[] args) {
        System.out.println(getDigitCount(11));
        System.out.println(reverse(100));
        numberToWords(100);
    }
    public static int getDigitCount(int num) {
        if (num < 0)
            return -1;
        else {
            int count = 0;
            do {
                count = count + 1;
                num = num / 10;
            } while (num != 0);
            return count;
        }
    }

    public static int reverse(int num){
     int r, d ;
     r=0;
     while(num!=0){
         d=num%10;
         r= r*10 + d;
         num = num/10;
     }
     return r;
    }
    public static void numberToWords(int num){
    if (num < 0)
        System.out.println("Invalid Value");
    else {
        int d;
        int run = getDigitCount(num);
        num = reverse(num);
        d = num % 10;
        for (int i=0; i<run ;i++){
            switch (d) {
                case 1:
                    System.out.println("One");
                    break;

                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("Zero");
                    break;
            }
            num = num / 10;
            d = num % 10;
        }

    }
    }
    }

