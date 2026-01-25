package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 겹치는 선분_1689
 * comment : loop 돌면서 해당 지점에서의 겹치는 선분 count 값 매번 update 필요
 */
public class OverlappingLineSegment_1689 {
    private int getCountOverlappingLineSegments(int nums, PriorityQueue<int[]> queue) {
        int max = 0;
        int count = 0;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            count += tmp[1];    // start면 더하고, end면 빼기
            max = Math.max(max, count); // 해당 지점에서 겹치는 선분 count 최대값과 비교
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        OverlappingLineSegment_1689 main = new OverlappingLineSegment_1689();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] o1) -> o1[0]).thenComparingInt(o1 -> o1[1]));
        for(int i = 0; i < nums; i++) {
            String[] split = br.readLine().split(" ");
            queue.offer(new int[]{Integer.parseInt(split[0]), 1});  // start
            queue.offer(new int[]{Integer.parseInt(split[1]), -1}); // end
        }

        System.out.println(main.getCountOverlappingLineSegments(nums, queue));
    }
}