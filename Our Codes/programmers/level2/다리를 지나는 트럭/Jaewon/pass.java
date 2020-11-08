import java.util.Queue;
import java.util.LinkedList;

public class pass{

    public static void main(String[] args){
        //받아오는 변수
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights={7,4,5,6};

        Queue<Integer> truck=new LinkedList<>();

        int sum=0;
        int time=0;
        int index=0;

        while(index < truck_weights.length){
            if(time>=bridge_length)
            {
                sum-=truck.poll();
            }
            if(sum+truck_weights[index]>weight){
                truck.add(0);
            }
            else{
                truck.add(truck_weights[index]);
                sum+=truck_weights[index];
                index++;
            }
            time++;

        }
        time+=bridge_length;
    }
}
