package baekJoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스타트 택시_19238
 * comment : 승객-Priority Queue, 목적지- Queue 제네릭 타입으로 분리, 로직은 같은데 메모리나 시간 더 잡아먹음
 */
public class StartTaxi_19238_v2 {
    private final int[][] space;
    private final int[][] passengers;
    private final int[] moveX = {-1, 0, 1, 0};
    private final int[] moveY = {0, -1, 0, 1};
    private int destinationX = -1;
    private int destinationY = -1;

    StartTaxi_19238_v2(int[][] space, int[][] passengers) {
        this.space = space;
        this.passengers = passengers;
    }

    private <T extends Queue<int[]>> int[] go(T queue, int[] current, int N, int M, int fuel, boolean destination) {
        boolean[][] visited = new boolean[N][N];
        queue.clear();
        queue.offer(new int[] {current[0], current[1], 0});
        visited[current[0]][current[1]] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];
            int tmpFuel = tmp[2];

            if(tmpFuel > fuel) return null;

            if(destination && tmpX == destinationX && tmpY == destinationY) {
                return tmp;
            }

            if(!destination) {
                for(int i = 0; i < M; i++) {
                    if(passengers[i][0] == tmpX && passengers[i][1] == tmpY) {
                        passengers[i][0] = -1;
                        passengers[i][1] = -1;
                        destinationX = passengers[i][2];
                        destinationY = passengers[i][3];
                        return tmp;
                    }
                }
            }

            for(int i = 0; i < 4; i++) {
                int X = tmpX + moveX[i];
                int Y = tmpY + moveY[i];

                if(X >= N || X < 0 || Y >= N || Y < 0 || space[X][Y] == 1|| visited[X][Y]) continue;

                queue.offer(new int[]{X, Y, tmpFuel+1});
                visited[X][Y] = true;
            }
        }

        return null;
    }

    private void getFuel(int[] startCoord, int N, int M, int fuel) {
        PriorityQueue<int[]> qPassenger = new PriorityQueue<>(Comparator.comparingInt((int[] p) -> p[2]).thenComparingInt(p -> p[0]).thenComparingInt(p -> p[1]));
        Queue<int[]> qDestination = new LinkedList<>();
        int[] current = new int[]{startCoord[0], startCoord[1], 0};
        boolean destination = false;    // false-heading to the passenger, true-heading to the destination
        int arrived = 0;

        while(arrived < M) {
            current = go(destination ? qDestination : qPassenger, current, N, M, fuel, destination);

            if(current == null) {
                System.out.println(-1);
                return;
            }

            int fuelUsg = current[2];
            fuel += destination ? fuelUsg : -fuelUsg;

            if(destination) arrived++;

            destination = !destination;
        }

        System.out.println(fuel);
    }

    public static void main(String[] args) throws IOException {
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

        StartTaxi_19238_v2 main = new StartTaxi_19238_v2(space, passengers);
        main.getFuel(startCoord, N, M, fuel);
    }
}
