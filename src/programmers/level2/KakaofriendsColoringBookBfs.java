package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class KakaofriendsColoringBookBfs {
    private int count;
    private boolean[][] visited;
    private int[] move = {0, 0, 1, -1};

    private void bfs(int row, int col, int[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];

            for(int i = 0; i < 4; i++) {
                int moveX = tmpX + move[i];
                int moveY = tmpY + move[3 - i];

                if(moveX < 0 || moveY < 0 || moveX >= picture.length || moveY >= picture[0].length) continue;

                if(!visited[moveX][moveY] && picture[tmpX][tmpY] == picture[moveX][moveY]) {
                    count++;
                    queue.offer(new int[]{moveX, moveY});
                    visited[moveX][moveY] = true;
                }
            }
        }
    }

    private int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 0) {
                    visited[i][j] = true;
                }

                if(!visited[i][j]) {
                    count = 1;  // count 초기화 하구
                    numberOfArea++; // visited 안했으니까 area 추가
                    visited[i][j] = true;
                    this.bfs(i, j, picture);

                    maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }

    public static void main(String[] args) {
        KakaofriendsColoringBookBfs coloringBookDfs = new KakaofriendsColoringBookBfs();

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        coloringBookDfs.solution(m, n, picture);
    }
}
