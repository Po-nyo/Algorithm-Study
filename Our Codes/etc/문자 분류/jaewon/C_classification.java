import java.util.Scanner;
import java.util.regex.Pattern;

public class C_classification {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.next();

        C_classification result = new C_classification();

        String S=result.Convert(s);
        System.out.println(S);
        System.out.println(result.Count(S)+" "+(S.length()-result.Count(S))+" "+S.length());

    }
    private String Convert(String s){
        String S = "";
        for(int i=0;i<s.length();i++){
            if(Pattern.matches("[a-zA-Z]", Character.toString(s.charAt(i)))){
                S += s.charAt(i);
            }
        }
        for(int i=0;i<s.length();i++){
            if(!Pattern.matches("[a-zA-Z]", Character.toString(s.charAt(i)))){
                S += s.charAt(i);
            }
        }
        return S;
    }

    private int Count(String S){
        int count = 0;
        for(int i=0;i<S.length();i++){
            if(Pattern.matches("[a-zA-Z]", Character.toString(S.charAt(i)))){
                count++;
            }
        }

        return count;
    }
}
