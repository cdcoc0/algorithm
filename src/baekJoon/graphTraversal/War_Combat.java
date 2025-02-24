package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 전쟁-전투 */
public class War_Combat {
    private String[][] battleField;
    private boolean[][] visited;
    private int count;

    War_Combat(int n, int m, String[][] battleField) {
        this.battleField = battleField;
        this.visited = new boolean[n][m];
        this.count = 0;
    }

    private void dfs(int row, int col) {
        int[] move = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++) {
            int moveX = row + move[i];
            int moveY = col + move[3 - i];

            if(moveX < 0 || moveY < 0 || moveX >= battleField.length || moveY >= battleField[0].length) continue;

            if(!visited[moveX][moveY] && battleField[row][col].equals(battleField[moveX][moveY])) {
                count++;
                visited[moveX][moveY] = true;
                dfs(moveX, moveY);
            }
        }
    }

    private void execute(int n, int m) {
        int sumW = 0;
        int sumB = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    count++;

                    dfs(i, j);

                    if("W".equals(battleField[i][j])) {
                        sumW += count * count;
                    } else {
                        sumB += count * count;
                    }

                    count = 0;
                }
            }
        }

        System.out.println(sumW + " " + sumB);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int m = Integer.parseInt(size[0]);
        int n = Integer.parseInt(size[1]);
        String[][] battleField = new String[n][m];

        for(int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                battleField[i][j] = line[j];
            }
        }

        War_Combat main = new War_Combat(n, m, battleField);
        main.execute(n, m);
    }
}
