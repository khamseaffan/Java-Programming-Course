public class Last_Digit_Checker {
    public static void main(String[] args) {

    }
    public static boolean hasSameLastDigit(int n1, int n2 , int n3){
        if (isVAlid(n1) || isVAlid(n2) || isVAlid(n3))
            return false;
        else{
            int d1,  d2, d3;
            d1=n1%10;
            d2=n2%10;
            d3=n3%10;
            if ((d1==d2) || (d2==d3) || (d3==d1))
                return true;
            return false;
        }
    }
    public static boolean isVAlid(int num){
        if (num<10 || num>1000)
            return false;
        else
            return true;
    }
}
