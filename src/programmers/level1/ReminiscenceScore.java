package programmers.level1;

import java.util.HashMap;
import java.util.Map;

/* 추억 점수 */
public class ReminiscenceScore {
    private static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> score = new HashMap<>();

        for(int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++) {
            int tmp = 0;
            for(String s : photo[i]) {
                tmp += score.getOrDefault(s, 0);
            }

            answer[i] = tmp;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        solution(name, yearning, photo);
    }
}
