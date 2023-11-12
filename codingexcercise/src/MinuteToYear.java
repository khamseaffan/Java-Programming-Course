import java.rmi.activation.ActivationSystem;

public class MinuteToYear {
    public static void main(String[] args) {
        printYearsAndDays(561600);
    }
    public static void printYearsAndDays(long minutes){
        if (minutes<0)
            System.out.println("Invalid Value");

        else {
            int days = (int)((minutes/(60*24)%365));
            int year = (int)((minutes/(60*24)/365));
            System.out.println(minutes + " min = " + year +" y and " + days +" d"  );
        }
    }
}
