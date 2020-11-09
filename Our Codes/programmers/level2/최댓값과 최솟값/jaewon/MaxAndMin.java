
public class MaxAndMin {
    public static void main(String[] args){
        String s ="-1 -1";
        MaxAndMin result = new MaxAndMin();
        System.out.println(result.account(s));
    }

    private String account(String s){
        String result="";

        int max=-1000000000;
        int min=1000000000;

        String[] numbers = s.split(" ");
        for(int i=0;i<numbers.length;i++){
            int number = Integer.parseInt(numbers[i]);

            if(max<=number)
                max=number;
            if(min>=number)
                min=number;
        }

        result += min+" "+max;

        return result;
    }
}
