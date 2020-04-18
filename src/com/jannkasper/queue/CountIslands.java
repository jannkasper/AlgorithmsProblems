package com.jannkasper.queue;

import java.util.ArrayDeque;
import java.util.Queue;
class Pair {
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CountIslands {

    private static final int[] row = { -1, -1, -1, 0, 1, 0, 1, 1 };
    private static final int[] col = { -1, 1, 0, -1, -1, 1, 0, 1 };

    public static boolean isSafe(int[][] matrix, boolean[][] processed, int y, int x) {
        if (y >= 0 && y < processed.length &&
            x >= 0 && x < processed[0].length &&
            matrix[y][x] == 1 && processed[y][x] == false) {
            return true;
        }
        return false;
    }

    public static void BFS(int[][] matrix, boolean[][] processed, int startY, int startX) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(startX,startY));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < row.length; i++) {
                if (isSafe(matrix,processed, pair.y + col[i], pair.x + row[i])) {
                    queue.add(new Pair(pair.x + row[i], pair.y + col[i]));
                    processed[pair.y + col[i]][pair.x + row[i]] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 0, 1, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                        {0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
                        {1, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1}
                };

        int height = matrix.length;
        int width = matrix[0].length;

        boolean processed[][] = new boolean[height][width];
        int island = 0;
        for (int y = 0; y<height; y++) {
            for (int x = 0; x<width; x++){
                if(matrix[y][x] == 1 && processed[y][x] == false) {
                    BFS(matrix, processed, y, x);
                    island++;
                }
            }
        }
        System.out.print("Number of islands are " + island);


    }


}
