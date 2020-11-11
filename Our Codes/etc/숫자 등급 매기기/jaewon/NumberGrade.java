import java.util.Scanner;

public class NumberGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        int[] number = new int[m];

        for(int i=0;i<m;i++){
            number[i]=input.nextInt();
        }

        NumberGrade a = new NumberGrade();
        int[] result= a.Count(n,number);
        int u_rare = 0;
        int s_rare = 0;
        int rare = 0;
        int normal = 0;

        for(int i = 0;i<result.length;i++){
            if(result[i]>=3)
                u_rare++;
            else if(result[i]==2)
                s_rare++;
            else if(result[i]==1)
                rare++;
            else
                normal++;
        }
        System.out.println(u_rare+" "+s_rare+" "+rare+" "+normal);

    }

    private int[] Count(int n,int[] number){
        int[] numbers=new int[n];
        for(int i=1;i<=n;i++){
            numbers[i-1]=0;
            if(Pow_2(i)){
                numbers[i-1]=3;
            }
            else{
                for(int j=0;j<number.length;j++){
                    if(i%number[j]==0)
                        numbers[i-1] +=1;
                }
            }

        }
        return numbers;
    }

    private boolean Pow_2(int i){
       while(i>1){
           if(i%2!=0)
               return false;
           else
               i/=2;
       }
       return true;
    }

}
