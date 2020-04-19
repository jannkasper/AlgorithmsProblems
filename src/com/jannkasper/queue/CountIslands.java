package com.jannkasper.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 10. Given a binary matrix where 0 represents water and 1 represents land, count the number of islands in it.
 * A island is formed by connected one's
 */

class Pair {
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CountIslands {

    // Below arrays details all 8 possible movements from a cell
    private static final int[] row = { -1, -1, -1, 0, 1, 0, 1, 1 };
    private static final int[] col = { -1, 1, 0, -1, -1, 1, 0, 1 };

    // Function to check if it is safe to go to position (x, y)
    // from current position. The function returns false if (x, y)
    // is not valid matrix coordinates or (x, y) represents water or
    // position (x, y) is already processed
    public static boolean isSafe(int[][] matrix, boolean[][] processed, int y, int x) {
        if (y >= 0 && y < processed.length &&
            x >= 0 && x < processed[0].length &&
            matrix[y][x] == 1 && processed[y][x] == false) {
            return true;
        }
        return false;
    }

    public static void BFS(int[][] matrix, boolean[][] processed, int startY, int startX) {
        // Collected cells of current island
        // SPACE COMPLEXITY O(n^2)
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(startX,startY));

        // TIME COMPLEXITY O(n^2)
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            // check for all 8 possible movements from current cell
            // TIME COMPLEXITY O(1)
            for (int i = 0; i < row.length; i++) {
                // Skip if location is invalid or already processed or has water
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

        // TIME COMPLEXITY O(n^2)
        for (int y = 0; y<height; y++) {
            for (int x = 0; x<width; x++){
                // start BFS from each unprocessed node and increment island count
                if(matrix[y][x] == 1 && processed[y][x] == false) {
                    BFS(matrix, processed, y, x);
                    island++;
                }
            }
        }
        System.out.print("Number of islands are " + island);


    }


}
