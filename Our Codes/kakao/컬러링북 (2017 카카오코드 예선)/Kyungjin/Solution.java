package kakao_friends_coloring_book;

import java.util.Stack;

public class Solution {
	
	static class Point {
		private int row;
		private int col;
		
		private Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public int[] solution(int m, int n, int[][] picture) {
		boolean[][] visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(picture, visited, i, j));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
	}
	
	private int dfs(int[][] picture, boolean[][] visited, int startRow, int startCol) {
		int color = picture[startRow][startCol];
		int areaSize = 0;
		
		Stack<Point> stack = new Stack<>();
		stack.push(new Point(startRow, startCol));
		
		visited[startRow][startCol] = true;
		
		while(!stack.isEmpty()) {
			Point current = stack.pop();
			areaSize++;
			
			int[] dr = {-1, 0, 0, 1};
			int[] dc = {0, -1, 1, 0};
			
			for(int i=0; i<4; i++) {
				int row = current.row + dr[i];
				int col = current.col + dc[i];
				
				if(row >= 0 && row < picture.length && col >= 0 && col < picture[0].length) {
					if(picture[row][col] == color && !visited[row][col]) {
						stack.push(new Point(row, col));
						visited[row][col] = true;
					}
				}
			}
		}
		return areaSize;
	}
}
