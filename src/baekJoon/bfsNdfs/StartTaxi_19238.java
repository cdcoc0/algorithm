package baekJoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스타트 택시_19238
 * comment : 손님, 목적지 로직 분리하면 좋을 듯
 */
public class StartTaxi_19238 {
    private void getFuel(int[][] space, int[][] passengers, int[] startCoord, int N, int M, int fuel) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] p) -> p[2]).thenComparingInt(p -> p[0]).thenComparingInt(p -> p[1]));
        boolean[][] visited = new boolean[N][N];
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, -1, 0, 1};
        int arrived = 0;
        int destinationX = -1;
        int destinationY = -1;
        boolean destination = false;    // false-heading to the passenger, true-heading to the destination

        queue.offer(new int[]{startCoord[0], startCoord[1], 0});
        visited[startCoord[0]][startCoord[1]] = true;

        while(!queue.isEmpty() && arrived < M) {
            int[] tmp = queue.poll();
            int X = tmp[0];
            int Y = tmp[1];
            int fuelUsg = tmp[2];
//            System.out.println("X : " + X + " Y : " + Y + " fuelUsg : " + fuelUsg + " destination : " + destinationX + " , " + destinationY + " fuel : " + fuel);

            if(fuelUsg > fuel) {
                System.out.println(-1);
                return;
            }

            if(!destination) {
                for(int i = 0; i < M; i++) {
                    if(X == passengers[i][0] && Y == passengers[i][1]) {
                        destinationX = passengers[i][2];
                        destinationY = passengers[i][3];
                        passengers[i][0] = -1;
                        passengers[i][1] = -1;

                        queue.clear();
                        queue.offer(new int[]{X, Y, 0});
                        visited = new boolean[N][N];
                        fuel -= fuelUsg;
                        destination = true;

                        break;
                    }
                }

                if(destination) continue;
            } else {
                if(X == destinationX && Y == destinationY) {
                    queue.clear();
                    queue.offer(new int[]{X, Y, 0});
                    visited = new boolean[N][N];
                    fuel += fuelUsg;
                    arrived++;
                    destination = false;

                    continue;
                }
            }

            for(int i = 0 ; i < 4; i++) {
                int tmpX = X + moveX[i];
                int tmpY = Y + moveY[i];
                if(tmpX >= N || tmpX < 0 || tmpY >= N || tmpY < 0 || space[tmpX][tmpY] == 1 || visited[tmpX][tmpY]) continue;

                queue.offer(new int[]{tmpX, tmpY, fuelUsg+1});
                visited[tmpX][tmpY] = true;
            }
        }

        System.out.println(arrived < M ? -1 : fuel);
    }

    public static void main(String[] args) throws IOException {
        StartTaxi_19238 main = new StartTaxi_19238();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] basicInfo = br.readLine().split(" ");
        int N = Integer.parseInt(basicInfo[0]);
        int M = Integer.parseInt(basicInfo[1]);
        int fuel = Integer.parseInt(basicInfo[2]);

        int[][] space = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            space[i] = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        }

        int[] startCoord = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value) - 1).toArray();
        int[][] passengers = new int[M][4];
        for(int i = 0; i < M; i++) {
            passengers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value) - 1).toArray();
        }

        main.getFuel(space, passengers, startCoord, N, M, fuel);
    }
}
