import java.util.Stack;
public class Crane {
    public static void main(String[] args){
        int[][] board={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] move={1,5,3,5,1,2,1,4};

        Crane result = new Crane();

        Stack[] crane;

        crane = result.createCrane(board);

        System.out.println(result.basket(crane,move));
    }

    private Stack[] createCrane(int[][] board){
        Stack[] crane = new Stack[board.length];
            for(int i=0;i<board.length;i++){
                crane[i]=new Stack();
                for(int j=0;j<board[i].length;j++){
                    if(board[board.length-1-j][i]!=0)
                       crane[i].add(board[board.length-1-j][i]);
                }
            }

            return crane;
    }

    private int basket(Stack[] crane, int[] move){
        Stack basket = new Stack();
        int count=0;

        for(int i=0;i<move.length;i++){
            if(crane[move[i]-1].isEmpty()){
                continue;
            }
            if(basket.isEmpty()){
                basket.add(crane[move[i]-1].pop());
            }
            else{
                if(basket.peek()==crane[move[i]-1].peek()){
                    basket.pop();
                    crane[move[i]-1].pop();
                    count +=2;
                }
                else
                    basket.add(crane[move[i]-1].pop());
            }
        }

        return count;
    }
}
