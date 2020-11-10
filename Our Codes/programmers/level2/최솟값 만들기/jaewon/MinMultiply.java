import java.util.Arrays;
import java.util.Collections;

public class MinMultiply {
    public static void main(String[] args){
        int[] A = {1,2};
        int[] B = {3,4};
        int sum=0;

        Integer[] a = new Integer[A.length];

        for(int i=0;i<A.length;i++){
            a[i]=A[i];
        }

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(B);

        for(int i=0;i<A.length;i++){
            sum+=a[i]*B[i];
        }
        System.out.println(sum);
    }

}
