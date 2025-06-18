package programmers.level2;

import java.util.HashMap;
import java.util.Map;

/* 의상 */
public class Outfit {
    private int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> count = new HashMap<>();
        for(String[] cloth : clothes) {
            count.put(cloth[1], count.getOrDefault(cloth[1], 0) + 1);
        }

        for(String key : count.keySet()) {
            answer *= count.get(key) + 1;
        }

        return answer-1;
    }

    public static void main(String[] args) {
        Outfit main = new Outfit();

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        main.solution(clothes);
    }
}
