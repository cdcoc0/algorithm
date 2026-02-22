package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 체스판 다시 칠하기_1018
 */
public class RepaintChessBoard_1018 {
    private int getCount(String[] board, int min, int startN, int startM) {
        final char WHITE = 'W';
        final char BLACK = 'B';

        for(int h = 1; h <= 2; h++) {    // W/B 두 번
            int count = 0;
            boolean compare = h % 2 == 0;   //true-W, false-B

            for(int i = startN; i < startN+8; i++) {
                for(int j = startM; j < startM+8; j++) {
                    if((compare && board[i].charAt(j) != WHITE) || (!compare && board[i].charAt(j) != BLACK)) count++;

                    compare = !compare;
                }

                if(count >= min) break;

                compare = !compare;
            }
            min = Math.min(min, count);
        }


        return min;
    }

    private void execute(String[] board, int n, int m) {
        int min = Integer.MAX_VALUE;

        // 8*8을 고름
        // 시작 칸이 W/B
        for(int i = 0; i < m-7; i++) {
            for(int j = 0; j < n-7; j++) {  // start point
                min = getCount(board, min, j, i);

                if(min == 0) {
                    System.out.println(min);
                    return;
                }
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) throws IOException {
        RepaintChessBoard_1018 main = new RepaintChessBoard_1018();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 세로
        int m = Integer.parseInt(split[1]); // 가로

        String[] board = new String[n];
        for(int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        main.execute(board, n, m);
    }
}
