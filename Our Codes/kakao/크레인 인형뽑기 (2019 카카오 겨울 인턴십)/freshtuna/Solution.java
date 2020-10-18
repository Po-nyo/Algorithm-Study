import java.util.Stack;

class Solution {
    private int[][] dolls;
    private int[] pointers;
    private int[] moves;
    private Stack<Integer> collects;
    private int answer;
    
    private void init(int[][] board, int[] moves) {
        this.dolls = board;
        this.collects = new Stack<>();
        this.answer = 0;
        
        init_moves(moves);
        init_pointers();
    }
    
    private void init_moves(int[] moves) {
        this.moves = moves;
        for(int i = 0; i < this.moves.length; ++i)
            --this.moves[i];
    }
    
    private void init_pointers() {
        int line_count = this.dolls[0].length;
        this.pointers = new int[line_count];
        
        for(int j = 0; j < line_count; ++j) {
            for(int i = this.dolls.length - 1; i >= 0; --i) {
                if(this.dolls[i][j] == 0) {
                    this.pointers[j] = i + 1;
                    break;
                }
            }
        }
    }
    
    private void collect(int col) {
        int pointer = this.pointers[col];
        
        if(pointer < this.dolls.length) {
            int doll = this.dolls[pointer][col];
            
            if(this.collects.isEmpty() 
               || this.collects.peek() != doll)
                this.collects.push(doll);
            else {
                while(!this.collects.isEmpty()) {
                    if(this.collects.peek() == doll) {
                        this.collects.pop();
                        ++this.answer;
                    }
                    else
                        break;
                }
                ++this.answer;
            }
            
            ++this.pointers[col];
        }
    }
    
    public int solution(int[][] board, int[] moves) {
        init(board, moves);
        
        for (int col : moves) 
            collect(col);
            
        return answer;
    }

    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.solution(
            new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}
          , new int[]{1,5,3,5,1,2,1,4}));
    }
}
