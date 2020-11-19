public class Palindrome {
    public static void main(String[] args){
        String s = "race a car";
        Palindrome result = new Palindrome();
        System.out.println(result.edge(s));


    }
    private boolean edge(String s){
        String Str="";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='0'&&s.charAt(i)<='9')
                Str += s.charAt(i);
        }

        Str = Str.toUpperCase();

        for(int i=0;i<Str.length();i++){
            if(Str.charAt(i)!=Str.charAt(Str.length()-1-i))
                return false;
        }

        return true;
    }
}
