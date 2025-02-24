package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 음식물 피하기 */
public class AvoidingFood {
    private int count;

    private void dfs(int row, int col, boolean[][] aisle) {
        int[] move = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++) {
            int moveX = row + move[i];
            int moveY = col + move[3 - i];

            if(moveX < 0 || moveY < 0 || moveX >= aisle.length || moveY >= aisle[0].length) continue;

            if(aisle[moveX][moveY]) {
                count++;
                aisle[moveX][moveY] = false;
                dfs(moveX, moveY, aisle);
            }
        }
    }

    private void execute(int n, int m, int k, boolean[][] aisle) {
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(aisle[i][j]) {
                    aisle[i][j] = false;
                    count = 1;
                    dfs(i, j, aisle);
                    max = Math.max(count, max);
                }
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        boolean[][] aisle = new boolean[n][m];

        for(int i = 0; i < k; i++) {
            String[] line = br.readLine().split(" ");
            aisle[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] = true;
        }

        AvoidingFood main = new AvoidingFood();
        main.execute(n, m, k, aisle);
    }
}
