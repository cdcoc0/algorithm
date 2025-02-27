package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

/* 달리기 */
public class Running {
    private static void execute(int N, int M, int k, int[][] gym, int[] coord) {
        final int[] move = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{coord[0], coord[1], 0});   // row, col, cnt
        gym[coord[0]][coord[1]] = -1;  // 시작지점

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];
            int cnt = tmp[2];

            if(tmpX == coord[2] && tmpY == coord[3]) {  // 도챠꾸
                System.out.println(cnt);
                return;
            }

            cnt++;
            for(int i = 0; i < 4; i++) {
                int moveX = tmpX;
                int moveY = tmpY;
                for(int j = 1; j <= k; j++) {
                    moveX += move[i];
                    moveY += move[3 - i];

                    if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= M || gym[moveX][moveY] == -1) break;
                    if(gym[moveX][moveY] > 0 && gym[moveX][moveY] < cnt) break;

                    if(gym[moveX][moveY] == 0) {
                        gym[moveX][moveY] = cnt;
                        queue.offer(new int[]{moveX, moveY, cnt});
                    }
                }
            }
        }

        System.out.println(-1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        Function<String,Integer> strToInt = Integer::parseInt;

        int N = strToInt.apply(first[0]);
        int M = strToInt.apply(first[1]);
        int K = strToInt.apply(first[2]);

        int[][] gym = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                gym[i][j] = "#".equals(split[j]) ? -1 : 0;
            }
        }

        String[] strCoord = br.readLine().split(" ");
        int[] coord = {strToInt.apply(strCoord[0])-1, strToInt.apply(strCoord[1])-1, strToInt.apply(strCoord[2])-1, strToInt.apply(strCoord[3])-1};

//        Running main = new Running();
//        main.execute(N, M, K, gym, coord);
        execute(N, M, K, gym, coord);
    }
}
