package find_teemo;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    static class Point {
        private int row;
        private int col;

        private Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private String word;
    private Set<Point> targetPoints;

    public Solution() {
        this.word = "teemo";
        this.targetPoints = new HashSet<>();
    }

    public void solve(char[][] grid, char[][] clone) {
        for(int i=0; i<clone.length; i++) {
            for(int j=0; j<clone[i].length; j++) {
                scan(clone, i, j);
            }
        }
        bomb(grid);
        print(grid);
    }

    private void scan(char[][] clone, int startRow, int startCol) {
        Set<Point> points = new HashSet<>();

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for(int i=0; i<dr.length; i++) {
            points.clear();
            boolean camo_flag = false;
            int camo_count = 0;

            int row = startRow - dr[i];
            int col = startCol - dc[i];

            for(int j=0; j<this.word.length(); j++) {
                row += dr[i];
                col += dc[i];

                if(row >= 0 && row < clone.length && col >= 0 && col < clone[0].length) {
                    points.add(new Point(row, col));

                    if(clone[row][col] != this.word.charAt(j)) {
                        if(camo_flag || camo_count > 1)
                            break;
                        camo_flag = true;
                        camo_count++;
                    }
                    else
                        camo_flag = false;

                    if(j == this.word.length()-1)
                        this.targetPoints.addAll(points);
                }
                else
                    break;
            }
        }
    }

    private void bomb(char[][] grid) {
        for(Point p: this.targetPoints) {
            grid[p.row][p.col] = '#';
        }
    }

    private void print(char[][] grid) {
        for(char[] arr: grid) {
            for(char c: arr)
                System.out.print(c);
            System.out.println();
        }
    }
}
