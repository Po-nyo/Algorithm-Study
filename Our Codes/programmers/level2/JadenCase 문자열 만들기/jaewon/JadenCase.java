import java.util.Queue;
import java.util.LinkedList;

public class JadenCase {
    public static void main(String[] args){
        String s = " 3people  unFollowed  me ";
        JadenCase result =  new JadenCase();
        System.out.println(result.Convert(s));
    }
    private String Convert(String s){
        s = s.toLowerCase();
        String s2="";
        boolean before = false;

        Queue<Character> a= new LinkedList();
        for(int i=0;i<s.length();i++){

            a.add(s.charAt(i));

            if(before==false)
                s2 += Character.toString(a.peek()).toUpperCase();
            else
                s2  += Character.toString(a.peek());

            if(a.remove()==' ')
                before=false;
            else
                before=true;

        }

        return s2;
    }
}
