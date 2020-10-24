import java.util.Stack;

public class Kakao_Doll_Draw {

	public static void main(String[] args) {
		int board[][] = {{0,0,0,0,0},
						 {0,0,1,0,3},
						 {0,2,5,0,1},
						 {4,2,4,4,2},
						 {3,5,1,3,1}};
		int move[] = {1, 5, 3, 5, 1, 2, 1, 4};
		System.out.println(solution(board, move));
	}
	
	public static int solution(int[][] board, int[] moves) {
		int answer =0;
		Stack<Integer> basket = new Stack<>();
		for(int i = 0; i < moves.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[j][moves[i]-1] != 0) {
					if((basket.empty()==false) && basket.peek()==board[j][moves[i]-1]) {  // 만약 새로들어온 값이 전에 들어온 값이랑 같을 경우
						basket.pop();								   // 전에들어온 값을 삭제하고
						answer += 2;							 		   // answer에  2을 더한다.(인형이 2개가 사라지기 때문에)
						board[j][moves[i]-1] = 0; 			 		   // 인형을 뽑아온 자리는 0으로 바꾼다.,	
						break;
					}else {
						basket.push(board[j][moves[i]-1]);	 		   // 전에들어온 값과 다르면 현재값을 push한다.
						board[j][moves[i]-1] = 0;				 		   //	그리고 뽑아온 자리를 0으로 바꾼다.
						break;
					}
				}else {
					continue;										   // 0이면 건너뛴다.
				}
			}
		}
		return answer;
	}
}


