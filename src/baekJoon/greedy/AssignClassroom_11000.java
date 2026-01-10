package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 강의실 배정_11000
 */
public class AssignClassroom_11000 {
    private void greedy(Queue<Integer[]> timeTable) {
        Queue<Integer> queue = new PriorityQueue<>();

        while(!timeTable.isEmpty()) {
            Integer[] time = timeTable.poll();
            Integer end = queue.peek();
            if(end != null && end <= time[0]) {
                queue.poll();
            }

            queue.offer(time[1]);
        }

        System.out.println(queue.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AssignClassroom_11000 main = new AssignClassroom_11000();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer[]> timeTable = new PriorityQueue<>(Comparator.comparingInt((Integer[] o1) -> o1[0]).thenComparingInt((Integer[] o1) -> o1[1]));
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            timeTable.offer(new Integer[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])});
        }

        main.greedy(timeTable);
    }
}
