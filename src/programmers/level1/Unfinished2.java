package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

/* 완주하지 못한 선수 */
public class Unfinished2 {
    private static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participated = new HashMap<>();
        Map<String, Integer> completed = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            participated.put(participant[i], participated.getOrDefault(participant[i], 0) + 1);
            if(i < completion.length) {
                completed.put(completion[i], completed.getOrDefault(completion[i], 0) + 1);
            }
        }

        for (String key : participated.keySet()) {
            if (Objects.equals(participated.get(key), completed.get(key))) {
                completed.remove(key);
            } else {
                answer = key;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa", "vinko", "marina1"};
        String[] completion = {"josipa", "filipa", "marina", "nikola", "vinko", "marina1"};

        System.out.println(solution(participant, completion));
    }
}