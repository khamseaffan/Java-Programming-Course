public class Largest_Prime {
    public static void main(String[] args) {
        System.out.println(getLargestPrime(217));
    } //it is program to find largets Prime Factor of number
    public static int getLargestPrime(int num){
        int prime = -1, count = 0;

        if (num<0)
            return -1;
        else
            {
                for(int i=2;i<=num;i++) {
                if (num % i==0)
                {
                    for (int j = 1; j <= i; j++)
                    {
                        if (i%j==0)
                            count=count+1;
                    }

                    if (count==2)
                    {
                        prime=i;
                        count=0;
                    }

                }
            }
        }
        return prime;
        }
    }

