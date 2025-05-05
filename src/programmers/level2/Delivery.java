package programmers.level2;

import java.util.*;

/* 배달 */
public class Delivery {
    private static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] route = new int[N+1][N+1];
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int len = r[2];

            if(route[a][b] == 0 || route[a][b] > len) {
                route[a][b] = len;
                route[b][a] = len;
            }
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{1, 0});   // start, dist

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curIdx = cur[0];
            int curDist = cur[1];

            visited[curIdx] = true;

            for(int i = 1; i <= N; i++) {
                if(route[curIdx][i] > 0) {
                    if(!visited[i] && dist[i] > curDist + route[curIdx][i]) {
                        dist[i] = curDist + route[curIdx][i];
                        queue.offer(new int[]{i, dist[i]});
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
//        int N = 5;
//        int K = 3;
//        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int N = 6;
        int K = 4;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};

//        int N = 10;
//        int[][] road = {{1, 9, 77}, {2, 5, 49}, {3, 9, 17}, {4, 7, 48}, {5, 8, 31}, {6, 10, 81}, {7, 9, 12}, {8, 9, 64}, {9, 10, 70}};
//        int K = 100;

        System.out.println(solution(N, road, K));
    }
}
