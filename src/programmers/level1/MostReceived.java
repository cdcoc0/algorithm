package programmers.level1;

import java.util.HashMap;
import java.util.Map;

/* 가장 많이 받은 선물 */
public class MostReceived {
    private static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> present = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for(String g : gifts) {
            String[] split = g.split(" ");
            present.compute(g, (k, v) -> v == null ? 1 : v + 1);
            score.compute(split[0], (k, v) -> v == null? 1 : v + 1);
            score.compute(split[1], (k, v) -> v == null ? -1 : v - 1);
        }

        for(int i = 0; i < friends.length - 1; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                String a = friends[i];
                String b = friends[j];

                int aScore = present.getOrDefault(a + " " + b, 0);
                int bScore = present.getOrDefault(b + " " + a, 0);

                if(aScore == bScore) {
                    aScore = score.getOrDefault(a, 0);
                    bScore = score.getOrDefault(b, 0);
                }

                if(aScore > bScore) {
                    result.compute(a, (k, v) -> v == null ? 1 : v + 1);
                } else if (bScore > aScore) {
                    result.compute(b, (k, v) -> v == null ? 1 : v + 1);
                }
            }
        }

        for(String key : result.keySet()) {
            int tmp = result.get(key);
            if(tmp > answer) {
                answer = tmp;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        solution(friends, gifts);
    }
}
