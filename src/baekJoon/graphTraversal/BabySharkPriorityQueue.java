package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/* 아기 상어(PriorityQueue) */
public class BabySharkPriorityQueue {
    private void execute(int N, int[][] aqua, int[] cntBySize, int x, int y) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] == o2[2] ? (o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]): Integer.compare(o1[0], o2[0])) : Integer.compare(o1[2], o2[2]));
        boolean[][] visited = new boolean[N][N];
        int[] coordX = {-1, 0, 0, 1};
        int[] coordY = {0, -1, 1, 0};
        int baby = 2;
        int eaten = 0;
        int remains = cntBySize[1];
        int totTime = 0;

        queue.offer(new int[]{x, y, 0});
        aqua[x][y] = 0;
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];
            int time = tmp[2];

            if(aqua[tmpX][tmpY] > 0 && aqua[tmpX][tmpY] < baby) {
                System.out.println("x : " + tmpX + " y : " + tmpY + " time : " + time);

                totTime = time;
                eaten++;
                remains--;
                if(eaten == baby) {
                    if(baby < 7) {
                        remains += cntBySize[baby];
                    }
                    baby++;
                    eaten = 0;
                }

                if(remains == 0) {
                    System.out.println(time);
                    return;
                }

                aqua[tmpX][tmpY] = 0;
                queue.clear();
                visited = new boolean[N][N];
            }

            for(int i = 0; i < 4; i++) {
                int moveX = tmpX + coordX[i];
                int moveY = tmpY + coordY[i];

                if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= N || visited[moveX][moveY] || aqua[moveX][moveY] > baby) continue;

                queue.offer(new int[]{moveX, moveY, time + 1});
                visited[moveX][moveY] = true;
            }
        }

        System.out.println(totTime);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] aqua = new int[N][N];
        int[] cntBySize = new int[7];
        int x = 0;
        int y = 0;

        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(split[j]);
                aqua[i][j] = tmp;

                if(tmp == 9) {
                    x = i;
                    y = j;
                } else {
                    cntBySize[tmp]++;
                }
            }
        }

        BabySharkPriorityQueue main = new BabySharkPriorityQueue();
        main.execute(N, aqua, cntBySize, x, y);
    }
}
