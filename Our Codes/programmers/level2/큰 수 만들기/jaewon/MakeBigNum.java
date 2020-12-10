public class MakeBigNum {
    public static void main(String[] args){
        String number="1924";
        int k=2;
        MakeBigNum a = new MakeBigNum();
        System.out.println(a.Convert(k, number));
    }

    private int maxInRange(int count, String number){
        int max = 0;
        int index =0;
        if(count>number.length())
            return -1;

        for(int i=0;i<count;i++){
            if(max< number.charAt(i)-'0'){
                max =  number.charAt(i)-'0';
                index = i;
            }

        }
        return index;
    }

    private String Convert(int k, String number){
        String answer ="";

        while(k!=0){

            int index = maxInRange(k+1,number);
            if(index == -1){
                number = "";
                break;
            }
            answer += number.charAt(index);
            k -= index;
            number = number.substring(index+1);

        }
        answer += number;

        return answer;
    }
}
