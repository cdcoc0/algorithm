package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 미로 탐색 */
public class ExploreAMaze {
    private void execute(int n, int m, int[][] maze) {
        int[] move = {0, 0, 1, -1};
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int row = tmp[0];
            int col = tmp[1];
            if(row == n - 1 && col == m - 1) {
                System.out.println(tmp[2]);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int moveX = row + move[i];
                int moveY = col + move[3 - i];

                if(moveX < 0 || moveY < 0 || moveX >= n || moveY >= m) continue;

                if(!visited[moveX][moveY]) {
                    visited[moveX][moveY] = true;
                    if(maze[moveX][moveY] != 0) {
                        queue.offer(new int[]{moveX, moveY, tmp[2] + 1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] maze = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(line[j]);
            }
        }

        ExploreAMaze main = new ExploreAMaze();
        main.execute(n, m, maze);
    }
}
