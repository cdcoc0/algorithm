package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 타겟 넘버 (BFS)
 */
public class TargetNumberBfs {
    private int solution(int[] numbers, int target) {
        int answer = 0;
        int len = numbers.length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{numbers[0], 1});
        queue.offer(new int[]{-numbers[0], 1});

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int sum = tmp[0];
            int idx = tmp[1];

            if(idx < len) {
                queue.offer(new int[] {sum + numbers[idx], idx+1});
                queue.offer(new int[] {sum - numbers[idx], idx+1});
            }

            if(idx >= len && sum == target) {
                answer++;
            }
        }

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        TargetNumberBfs main = new TargetNumberBfs();
        int[] numbers = {};
        int target = 4;

        main.solution(numbers, target);
    }
}

