public class Draw {
    public static void main(String[] args){
        Draw result= new Draw();

        int n = 32;
        int a = 1;
        int b = 32;

        System.out.println(result.count(a,b,n));

    }
    private int count(int a, int b,int n){
        int count = 1;
        while(count<Math.sqrt(n)){
            a = (a-1)/2+1;
            b = (b-1)/2+1;
            if(Math.abs(a-b)==0)
                break;
            count++;
        }
        return count;
    }
}
