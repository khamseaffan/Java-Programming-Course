public class Paint_job {
    public static void main(String[] args) {
        System.out.println(getBucketCount(2.75,3.25,2.5);
    }
    public static int getBucketCount(double width  , double height, double arePerBucket, int extraBucket){
        if(width<=0 || height<0|| arePerBucket <=0 || extraBucket<0 )
            return -1;
        else{
            return (int) Math.round(((width*height)-(arePerBucket*extraBucket))/arePerBucket);
        }
    }
    public static int getBucketCount(double width  , double height, double arePerBucket){
        if(width<=0 || height<0|| arePerBucket <=0)
            return -1;
        else{
            return (int) Math.round(((width*height))/arePerBucket);
        }
    }
}
