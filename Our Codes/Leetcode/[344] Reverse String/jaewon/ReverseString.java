import java.util.Stack;

public class ReverseString {
    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        ReverseString result = new ReverseString();
        result.reverse(s);
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]);
        }

    }

    private Stack Insert(char[] s){
        Stack<Character> a = new Stack();
        for(int i=0;i<s.length;i++){
            a.add(s[i]);
        }
        return a;
    }

    private char[] reverse(char[] s){
        Stack<Character> a = Insert(s);
        for(int i=0;i<s.length;i++){
            s[i]=a.pop();
        }

        return s;
    }
}
