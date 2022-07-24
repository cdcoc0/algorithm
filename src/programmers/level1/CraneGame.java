package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class CraneGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        //크레인으로 뽑은 인형을 담을 배열
        List<Integer> dolls = new ArrayList<>();

        for(int m : moves) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][m - 1] > 0) {
                    if(!dolls.isEmpty() && dolls.get(dolls.size() - 1) == board[j][m - 1]) {
                        dolls.remove(dolls.size() - 1);
                        answer += 2;
                    } else {
                        dolls.add(board[j][m - 1]);
                    }
                    board[j][m - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CraneGame g = new CraneGame();

        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

//        System.out.println(board[3][0]); //[행][열]

        g.solution(board, moves);
    }
}
