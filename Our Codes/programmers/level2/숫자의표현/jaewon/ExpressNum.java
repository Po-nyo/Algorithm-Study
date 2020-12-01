public class ExpressNum {
    public static void main(String[] args){
        int n = 15;

        ExpressNum a = new ExpressNum();
        System.out.println(a.count(n));

    }
    private boolean judgment(int index,int n){
        int sum =0 ;
        for(int i=index;i<=n;i++){
            sum += i;
            if(sum>n)
                return false;

            if(sum==n)
                return true;
        }
        return false;
    }

    private int count(int n){
        int count = 0;

        for(int i=1;i<=n;i++){
            if(judgment(i,n))
                count++;
        }

        return count;
    }
}
