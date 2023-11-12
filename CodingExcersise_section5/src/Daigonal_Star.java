public class Daigonal_Star {
    public static void main(String[] args) {

        printSquareStar(8);

    }
    public static void printSquareStar(int num){
        int i, j;
        if(num<5)
        System.out.println("invalid Value");
        else{
           for(i=0;i<num;i++){
               for (j=0;j<num;j++){
                    if (i==j || (i+j)==(num-1))
                        System.out.print('*');
                    else if(i==0||i==(num-1)||j==0||j==(num-1))
                         System.out.print('*');
                    else
                        System.out.print(' ');
               }
               System.out.print("\n");
            }
        }
    }
}
