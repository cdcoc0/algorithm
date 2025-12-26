package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* 가장 큰 수 */
public class TheBiggestNum {
    private String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();
        for(int num : numbers) {
            list.add(String.valueOf(num));
        }

        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        list.forEach(sb::append);

        // descending order pq (heap sorting)
//        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
//
//        for(int n : numbers) {
//            queue.add(String.valueOf(n));
//        }
//
//        while(!queue.isEmpty()) {
//            sb.append(queue.poll());
//        }

        String answer = sb.toString();

        return answer.charAt(0) == '0' ? "0" : answer;
    }

    public static void main(String[] args) {
        TheBiggestNum main = new TheBiggestNum();
        int[] numbers = {0, 0, 0};
        main.solution(numbers);
    }
}
