public class BarkingDog {
    public static void main(String[] args) {
        shouldWakeUp(true,1);
    }
    public static  boolean shouldWakeUp(boolean barking , int hourOfDay){
        if (hourOfDay>23 || barking == false || hourOfDay <0)
            return false;
        else if (hourOfDay<8 || hourOfDay>23){
            return true;
        }
        else
            return false;
    }
}
