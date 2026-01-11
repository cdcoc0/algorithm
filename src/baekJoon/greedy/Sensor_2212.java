package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 센서_2212
 */
public class Sensor_2212 {
    private int getDistance(int N, int K, int[] coord) {
        Queue<Integer> queue = new PriorityQueue<>();
        int sum = 0;

        // 정렬
        Arrays.sort(coord);

        // 센서 사이의 거리
        for(int i = coord.length-1; i > 0; i--){
            queue.add(coord[i] - coord[i-1]);
        }

        // 먼 거리부터 제거
        while(!queue.isEmpty() && queue.size() > K-1){
            sum += queue.poll();
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        Sensor_2212 main = new Sensor_2212();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(main.getDistance(N, K, split));
    }
}
