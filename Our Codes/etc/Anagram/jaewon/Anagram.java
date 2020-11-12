import java.util.ArrayList;

public class Anagram {
    public static void main(String[] args){
        String s1 = "aabbcc";
        String s2 = "bbrree";

        Anagram result = new Anagram();
        int same  = result.smae_num(s1,s2);

        System.out.println(s1.length()-same+s2.length()-same);

    }
    private int smae_num(String s1, String s2){
        String[] S1 = s1.split("");
        String[] S2 = s2.split("");
        int count=0;

        for(int i=0;i<S1.length;i++){
            for(int j=0;j<S2.length;j++){
                if(S1[i].equals(S2[j])) {
                    S1[i]="*";
                    S2[j]="*";
                    count++;
                }
            }
        }

        return count;
    }
}
