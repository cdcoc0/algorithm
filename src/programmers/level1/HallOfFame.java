package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 명예의 전당 (1) */
public class HallOfFame {
    private static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> fame = new ArrayList<>();

        int min = 2000;
        for(int i = 0; i < Math.min(k, score.length); i++) {
            int tmp = score[i];
            fame.add(tmp);
            if(tmp < min) {
                min = tmp;
            }

            answer[i] = min;
        }

        Collections.sort(fame);

        for(int i = k; i < score.length; i++) {
            int tmp = score[i];
            int first = fame.get(0);

            if(tmp > first) {
                for(int j = 1; j < k; j++) {
                    if(tmp <= fame.get(j)) {
                        fame.add(j, tmp);
                        break;
                    }
                }

                if(fame.size() == k) {
                    fame.add(tmp);
                }

                fame.remove(0);
                first = fame.get(0);
            }
            answer[i] = first;
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        solution(k, score);
    }
}
