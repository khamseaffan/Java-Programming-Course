public class Flour_packer {
    public static void main(String[] args) {
        System.out.println(canPack(5, 3, 24));
    }

    public static boolean canPack( int bigcount, int smallcount , int goal){
       if (bigcount<0 || smallcount<0 || goal<0)
           return false;
       else{
           int sum= (bigcount*5)+ smallcount;
           if (sum<goal)
               return false;
           else if (sum==goal)
               return true;
           else if (sum>goal && bigcount%2==0)
               return true;

           return false;
       }
    }
}
