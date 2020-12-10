public class fibonacci {
    public static void main(String[] args){
        int n =100000;
        fibonacci a = new fibonacci();
        System.out.println(a.count(n));

    }
    private int count(int n){
        int F0 = 0;
        int F1 = 1;
        int Fn = 0;

        for(int i=2;i<=n;i++){
            Fn =  F0+F1;
            F0 = F1%1234567;
            F1 = Fn%1234567;
        }

        return Fn%1234567;
    }
}
