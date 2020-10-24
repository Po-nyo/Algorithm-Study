package boj_2636;

import java.util.Stack;

public class Cheese {

    private static class Point {
        private int row;
        private int col;

        private Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int[][] cheese_arr;
    private int prev_cheese_area;
    private int cheese_area;

    public Cheese(int[][] cheese_arr) {
        this.cheese_arr = cheese_arr;
    }

    public void run() {
        int count = 0;

        do {
            rot();
            count++;
        } while(cheese_area != 0);

        System.out.println(--count);
        System.out.println(this.prev_cheese_area);
    }

    private void rot() {
        this.prev_cheese_area = this.cheese_area;
        this.cheese_area = 0;
        boolean[][] visited = new boolean[cheese_arr.length][cheese_arr[0].length];

        Stack<Point> stack = new Stack<>();
        stack.push(new Point(0, 0));
        visited[0][0] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!stack.isEmpty()) {
            Point current = stack.pop();

            for(int[] direction : directions) {
                int row = current.row + direction[0];
                int col = current.col + direction[1];

                if (row >= 0 && row < cheese_arr.length && col >= 0 && col < cheese_arr[0].length) {
                    if(!visited[row][col] && cheese_arr[row][col] == 0) {
                        stack.push(new Point(row, col));
                        visited[row][col] = true;
                    }
                    else if(cheese_arr[row][col] == 1) {
                        this.cheese_area++;
                        cheese_arr[row][col] = 0;
                        visited[row][col] = true;
                    }
                }
            }
        }
    }
}
