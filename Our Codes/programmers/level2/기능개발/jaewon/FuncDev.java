import java.util.Queue;
import java.util.LinkedList;

public class FuncDev {
    public static void main(String[] args){
        int[] progresses={1,50,10,1,60};
        int[] speeds={3,100,1,10,1};

        FuncDev a = new FuncDev();
        a.RequiredDate(progresses,speeds);
        Queue<Integer> result = a.Distribute(progresses);

        int[] answer = new int [result.size()];
        int index = 0;

        while(!result.isEmpty()){
            answer[index]=result.remove();
            System.out.print(answer[index]+" ");
            index++;
        }

    }
    private int[] RequiredDate(int[] progresses,int[] speeds){
        for(int i=0;i<progresses.length;i++){
            progresses[i] = 100-progresses[i] ;

            if(progresses[i]%speeds[i]!=0)
                progresses[i] = progresses[i] /speeds[i] +1;

            else
                progresses[i] /= speeds[i];

        }
        return progresses;
    }

    private Queue Distribute(int[] progresses){
        Queue result = new LinkedList();

        int count = 0;
        int distribute=progresses[0];

        for(int i:progresses){
            if(i>distribute){
                distribute = i;
                result.add(count);
                count = 1;
            }
            else
                count++;
        }

        result.add(count);

        return result;
    }
}
