package programmers.level1;

import java.util.*;

/* 크레인 인형뽑기 게임 */
public class CraneGame2 {
    private static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();
        int len = board.length;

        for(int move : moves) {
            for(int i = 0; i < len; i++) {
                int value = board[i][move-1];
                if(value != 0) {
                    if(basket.isEmpty()) {
                        basket.push(value);
                    } else {
                        if(basket.peek() == value) {
                            basket.pop();
                            answer += 2;
                        } else {
                            basket.push(value);
                        }
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }


//        Map<Integer, Integer> location = new HashMap<>();
//
//        for(int i = 0; i < len; i++) {
//            for(int j = 0; j < len; j++) {
//                if(board[j][i] > 0) {
//                    location.put(i, j);
//                    break;
//                }
//            }
//        }
//
//        List<Integer> basket = new ArrayList<>();
//        basket.add(-1);
//        for (int move : moves) {
//            int n = move - 1;
//            int idx = location.get(n);
//
//            if(idx >= len) { continue; }
//
//            int value = board[idx][n];
//            basket.add(value);
//            location.replace(n, idx + 1);
//
//            int lastIdx = basket.size() - 1;
//            if (value == basket.get(lastIdx - 1)) {
//                answer += 2;
//                basket.remove(lastIdx);
//                basket.remove(lastIdx - 1);
//            }
//        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }
}
