import java.util.Stack;

class Solution {
  static int[] answer = null;
  static boolean[][] visited = null;
  static int[][] picture = null;
  static Stack<Integer> stackx = new Stack<>();
  static Stack<Integer> stacky = new Stack<>();
  static int m, n, area = 0;

  public int[] solution(int m, int n, int[][] picture) {
    visited = new boolean[m][n];
    answer = new int[2];
    this.picture = picture;
    this.m = m;
    this.n = n;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        area = 0;

        if(picture[i][j] > 0 && visited[i][j] == false) {
          push(i, j);
          area++;
          answer[0]++;

          while(!stackx.isEmpty()) 
            push_candidates(stackx.pop(), stacky.pop());
          answer[1] = Math.max(answer[1], area);
        }
      }
    }
    return answer;
  }

  private static void push_candidates(int x, int y) {
    int[][] candidates = {{x + 1, y}, {x - 1, y}, {x, y - 1}, {x, y + 1}};
    int color = picture[x][y];

    for(int i = 0; i < candidates.length; ++i) {
      int _x = candidates[i][0];
      int _y = candidates[i][1];

      if (
        _x >= 0 && _x < m && _y >= 0 && _y < n 
        && picture[_x][_y] == color 
        && visited[_x][_y] == false
      ) { 
        push(_x, _y);
        area++; 
      }
    }
  }
    
  private static void push(int i, int j) 
  {
    stackx.add(i);
    stacky.add(j);
    visited[i][j] = true;
  }
}
