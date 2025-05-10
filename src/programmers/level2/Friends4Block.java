package programmers.level2;

import java.util.Arrays;

/* 프렌즈4블록 */
public class Friends4Block {
    int solution(int m, int n, String[] board) {
        int answer = 0;
        String[] copy = Arrays.copyOf(board, board.length);
        boolean flag = false;

        while (true) {
            // mark 4 blocks
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    char s = board[i].charAt(j);
                    if(s == '@') continue;
                    if(board[i].charAt(j+1) == s && board[i+1].charAt(j) == s && board[i+1].charAt(j+1) == s) {
                        copy[i] = copy[i].substring(0, j) + "!!" + copy[i].substring(j+2);
                        copy[i+1] = copy[i+1].substring(0, j) + "!!" + copy[i+1].substring(j+2);
                        flag = true;
                    }
                }
            }

            if(!flag) break;

            //remove 4 blocks
            int ptr = m - 1;
            int xPtr = 0;
            for(int i = 0; i < n; i++) {
                for(int j = m - 1; j >= 0; j--) {
                    if(copy[j].charAt(i)=='!') {
                        answer++;
                        board[xPtr] = board[xPtr].substring(0, i) + "@" + board[xPtr].substring(i+1);
                        xPtr++;
                    } else {
                        board[ptr] = board[ptr].substring(0, i) + copy[j].charAt(i) + board[ptr].substring(i+1);
                        ptr--;
                    }
                }
                ptr = m - 1;
                xPtr = 0;
            }

            flag = false;
            copy = Arrays.copyOf(board, board.length);
        }

        return answer;
    }

    public static void main(String[] args) {
        Friends4Block main = new Friends4Block();

        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(main.solution(m, n, board));
    }
}
