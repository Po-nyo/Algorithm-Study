# 크레인 인형뽑기

```java
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
```

인형뽑기를 진행할 때 뽑은 인형의 자리는 0이 되어야 하고, 새로운 바구니에 뽑은 인형을 넣어야 한다. 
그리고 현재 뽑은 인형과 바로 전에 뽑은 인형이 같다면 그 뽑은 인형들은 사라진다.
이 문제를 봤을 때 들은 생각은 뽑은 인형을 넣은 바구니를 스택(Stack)을 사용하면 편하겠다는 것이였다.
스택은 들어간 순서가 아닌 가장 마지막에 들어간 값을 확인하거나 삭제하기 때문이다.
그리하여 입력된 move값의 인형을 뽑고 basket이란 스택에 push를 한다. 만약 전에 들어온 값과 새로들어온 값이 같을 경우 
pop을 하여 전에 들어온 값을 삭제한다.( 새로 들어온 값은 애초에 저장을 안해서 없는 것과 같다.)
그리고 answer에 +2를 한다. (2개의 인형이 삭제되었기 때문에)
그리고 형을 뽑아온 자리를 0으로 바꾼다.
만약 검색한 자리가 0이라면 건너 뛴다.

