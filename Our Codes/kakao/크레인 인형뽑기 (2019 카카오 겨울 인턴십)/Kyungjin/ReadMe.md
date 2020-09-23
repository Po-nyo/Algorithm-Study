# [[2019 카카오 겨울 인턴십] 크레인 인형뽑기 게임](https://programmers.co.kr/learn/courses/30/lessons/64061)

## 풀이

더 복잡하게 만들 수 있었겠지만, 난이도를 낮추어 간단하게 만든 것 같은 문제였다.

별 다른 특별한 전략이 필요하지는 않고 문제만 잘 읽으면 누구나 쉽게 풀 것 같다.

나는 Stack을 사용하여 풀었고, 뽑는 부분은 다른 메소드로 분리하였다.

```java
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
```

뽑는 부분은 pull() 메소드에 구현했다.

```java
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
```
