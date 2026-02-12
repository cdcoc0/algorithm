package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사탕 게임_3085
 * comment : brute force... 문제 그대로 구현
 */
public class CandyGame_3085 {
    private void swap(String[][] arr, int[] idx1, int[] idx2) {
        String tmp = arr[idx1[0]][idx1[1]];
        arr[idx1[0]][idx1[1]] = arr[idx2[0]][idx2[1]];
        arr[idx2[0]][idx2[1]] = tmp;
    }

    private int getMax(String[][] board, int max) {
        for(int i = 0; i < board.length; i++) {
            int hCount = 1;
            int vCount = 1;
            for(int j = 1; j < board.length; j++) {
                if(board[i][j].equals(board[i][j-1])) {
                    hCount++;
                } else {
                    max = Math.max(max, hCount);
                    hCount = 1;
                }

                if(board[j][i].equals(board[j-1][i])) {
                    vCount++;
                } else {
                    max = Math.max(max, vCount);
                    vCount = 1;
                }
            }
            max = Math.max(max, Math.max(hCount, vCount));
        }

        return max;
    }

    private void countCandies(int N, String[][] board) {
        int max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 1; j < N; j++) {
                // horizontal
                swap(board, new int[]{i, j-1}, new int[]{i, j});

                // get max
                max = getMax(board, max);

                // restore array
                swap(board, new int[]{i, j-1}, new int[]{i, j});

                // vertical
                swap(board, new int[]{j-1, i}, new int[]{j, i});

                // get max
                max = getMax(board, max);

                // restore array
                swap(board, new int[]{j-1, i}, new int[]{j, i});
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        CandyGame_3085 main = new CandyGame_3085();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] board = new  String[N][N];
        for(int i = 0; i < N; i++) board[i] = br.readLine().split("");

        main.countCandies(N, board);
    }
}
