package kakao_crane_game;

import java.util.Stack;

public class Solution {

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for(int move: moves) {
            int pulled = pull(board, move);

            if(pulled != 0) {
                if(basket.isEmpty())
                    basket.push(pulled);
                else if(pulled == basket.peek()) {
                    basket.pop();
                    answer += 2;
                }
                else
                    basket.push(pulled);
            }
        }
        return answer;
    }

    private int pull(int[][] board, int move) {
        for(int i=0; i<board.length; i++) {
            if(board[i][move-1] != 0) {
                int pulled = board[i][move-1];
                board[i][move-1] = 0;
                return pulled;
            }
        }
        return 0;
    }
}
