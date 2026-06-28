package programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 거리두기 확인하기 (2021 카카오 채용연계형 인턴십)
 */
public class ValidateSocialDistances_V2 {
    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        Solution.solution(places);
//        "POOOP",
//        "OXXOX",
//        "OPXPX",
//        "OOXOX",
//        "POXXP"
    }

    static class Solution {
        final static int SIZE = 5;
        final static char PERSON = 'P';
        final static char EMPTY = 'O';
        final static char PARTITION = 'X';

        static boolean bfs(String[] place, int rowIdx, int colIdx) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[SIZE][SIZE];

            queue.offer(new int[]{rowIdx, colIdx, 0});
            visited[rowIdx][colIdx] = true;

            // 상하좌우
            int[] move = {0, 0, 1, -1};
            while(!queue.isEmpty()) {
                int[] tmp = queue.poll();
                if(tmp[2] >= 2) continue;

                for(int i = 0; i < 4; i++) {
                    int moveX = tmp[0] + move[i];
                    int moveY = tmp[1] + move[3-i];

                    if(moveX < 0 || moveX >= SIZE || moveY < 0 || moveY >= SIZE) continue;
                    if(visited[moveX][moveY]) continue;

                    char c = place[moveX].charAt(moveY);
                    if(c == PARTITION) continue;

                    if(c == PERSON) return false;

                    if(c == EMPTY) {
                        visited[moveX][moveY] = true;
                        queue.offer(new int[]{moveX, moveY, tmp[2] + 1});
                    }
                }
            }

            return true;
        }

        static int[] solution(String[][] places) {
            int[] answer = new int[SIZE];

            for(int i = 0; i < places.length; i++) {
                String[] place = places[i];
                answer[i] = 1;

                for(int j = 0; j < SIZE; j++) {
                    String row = place[j];
                    for(int k = 0; k < SIZE; k++) {
                        if(row.charAt(k) == PERSON && !bfs(place, j, k)) {
                            answer[i] = 0;
                            break;
                        }
                    }
                    if(answer[i] == 0) break;
                }
            }

            return answer;
        }
    }
}
