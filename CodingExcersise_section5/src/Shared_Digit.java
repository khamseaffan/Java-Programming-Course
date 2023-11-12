public class Shared_Digit {
    public static void main(String[] args) {
        System.out.println(hasSharedIgit(-35,20));
    }
    public static boolean hasSharedIgit(int num1 , int num2){
        if(num1<10||num2<10||num1>99||num2>99){
            return false;
        }
        else{
            int d1,d2, numc;
            numc=num2;
            while (num1!=0){
                d1 =num1%10;
                while(num2!=0){
                    d2=num2%10;
                    if (d1==d2)
                        return true;
                    num2=num2/10;
                }
                num1 = num1/10;
                num2=numc;
            }
        }
        return false;

    }
}
