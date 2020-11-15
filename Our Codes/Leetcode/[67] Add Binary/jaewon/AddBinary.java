import java.util.Stack;
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        AddBinary result = new AddBinary();
        System.out.println(result.Binary(a,b));
    }
    private String Binary(String a,String b){
        String s = "";
        Stack<Integer> A = insert(a);
        Stack<Integer> B = insert(b);
        int OverFlow =0;

        while(!A.isEmpty()&&!B.isEmpty()) {
            s = (A.peek()+B.peek()+OverFlow)%2+s;
                OverFlow=(A.pop()+B.pop()+OverFlow)/2;
        }
        while(!A.isEmpty()){
            s = (A.peek()+OverFlow)%2+s;
            OverFlow=(A.pop()+OverFlow)/2;
        }
        while(!B.isEmpty()){
            s = (B.peek()+OverFlow)%2+s;
            OverFlow=(B.pop()+OverFlow)/2;
        }
        if(OverFlow==1)
            s = 1+s;

            return s;
    }
    private Stack insert(String binary){
        Stack<Integer> x = new Stack();
        for(int i=0;i<binary.length();i++){
            x.add((int)(binary.charAt(i)-'0'));
        }

        return x;
    }

}