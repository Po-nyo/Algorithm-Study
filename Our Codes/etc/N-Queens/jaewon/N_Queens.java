import java.util.Scanner;
class N_Queens{
    private int N;
    private int Q[];

    public N_Queens(int N){
        this.N=N;
        this.Q=new int[N];
    }

    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.print("N을 입력하세요. : ");

        N_Queens result = new N_Queens(input.nextInt());
        result.b_tracking(0);
    }
    private void PrintTable(int[] Q){
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j==Q[i])
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
    private void b_tracking(int layer) {
        if(layer == N){
            PrintTable(Q);
            System.out.println();
        }
        else{
            for(int i=0;i<N;i++){
                Q[layer]=i;
                if(edge(layer)){
                    b_tracking(layer+1);
                }
            }
        }

    }
    private boolean edge(int layer){
        for(int i=0;i<layer;i++){
            if(Q[i]==Q[layer] || Math.abs(layer-i)== Math.abs(Q[layer]-Q[i])){
                return false;
            }
        }
        return true;
    }

}

