package programmers.level1;

import java.util.PriorityQueue;

/* 명예의 전당 (1) - Priority Queue 사용 */
public class HallOfFame2 {
    private static int[] solution(int k, int[] score) {
        int len = score.length;
        int[] answer = new int[len];

        PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();
        for(int i = 0; i < len; i++) {
            int tmp = score[i];
            hallOfFame.offer(tmp);

            if(i >= k) {
                hallOfFame.remove();
            }

            answer[i] = hallOfFame.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        solution(k, score);
    }
}
