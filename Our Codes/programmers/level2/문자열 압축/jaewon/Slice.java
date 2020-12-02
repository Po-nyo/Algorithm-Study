import java.util.Queue;
import java.util.LinkedList;

public class Slice {
    public static void main(String[] args){
        String s = "xababcdcdababcdcd";
        Slice a = new Slice();
        System.out.println(a.countLength(s));
    }
    private int countLength(String s){
        int min = s.length();
        int MaxCut = s.length()/2;

        for(int i=1;i<=MaxCut;i++){
            if(min>=cutting(s,i).length())
                min=cutting(s,i).length();
        }
        return min;
    }

    private String cutting(String s,int n){
        String S ="";
       Queue<String> a = makeQue(s,n);

        int count = 1;
        String x = a.remove();
        while(!a.isEmpty()){
            if(x.equals(a.peek())){
                a.remove();
                count++;
            }
            else{
                if(count==1)
                    S+=x;
                else
                    S+=count+""+x;
                count =1;
                x = a.remove();
            }
        }
        if(count==1)
            S+=x;
        else
            S+=count+""+x;

        return S;
    }

    private Queue makeQue(String s, int n){
        Queue<String> a =new LinkedList();
        int length = s.length()/n;

        for(int i=0;i<length;i++){
            String x = s.substring(n*i,n*(i+1));
            a.add(x);
        }
        if(s.length()%n!=0)
            a.add(s.substring(s.length()-(s.length()%n)));

        return a;
    }
}
