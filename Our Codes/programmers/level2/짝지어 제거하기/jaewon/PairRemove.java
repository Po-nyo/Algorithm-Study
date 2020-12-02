import java.util.Stack;

public class PairRemove {
    public static void main(String[] args){
        String s = "cdcd";
        PairRemove a = new PairRemove();

        if(a.Convert(s).equals(""))
            System.out.println(1);

        else
            System.out.println(0);


    }
    private Stack<Character> remove(String s){
        Stack<Character> a = new Stack();
        for(int i=0;i<s.length();i++){
            if(a.isEmpty())
                a.add(s.charAt(i));
            else{
                if(a.peek()==s.charAt(i)){
                    a.pop();
                }
                else
                    a.add(s.charAt(i));
            }
        }
        return a;
    }
    private String Convert(String s){
        String s2 = "";
        Stack a = remove(s);
        while(!a.isEmpty()){
            s2+=a.pop();
        }
        return s2;
    }
}
