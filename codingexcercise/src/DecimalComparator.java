import javax.swing.*;

public class DecimalComparator {
    public static void main(String[] args) {
       boolean a;
        a = areEqualByThreeDecimalPlaces(-3.1756,3.1757);
        System.out.print(a);
    }
    public static  boolean areEqualByThreeDecimalPlaces(double num1, double num2){
        double epsilon = 0.0009;
        if ( (num1<0&&num2>0) || (num1>0 && num2<0) )
            return false;
        if (Math.abs(Math.abs(num1)-Math.abs(num2)) < epsilon) {
            return true;
        }

        return false;
    }
}

