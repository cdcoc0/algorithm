package programmers.level1;

import java.util.HashMap;
import java.util.Map;

/* 성격 유형 검사하기 */
public class PersonalityTest {
    private static String solution(String[] survey, int[] choices) {
        String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
        Map<String, Integer> count = new HashMap<>();

        for(String type : types) {
            count.put(type, 0);
        }

        for(int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            if(choice < 4) {   // 비동의
                count.computeIfPresent(survey[i].substring(0, 1), (key, value) -> value + (choice == 1 ? 3 : choice == 3 ? 1 : choice));
            } else if (choice > 4) {    // 동의
                count.computeIfPresent(survey[i].substring(1), (key, value) -> value + (choice - 4));
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < types.length; i += 2) {
            String type1 = types[i];
            String type2 = types[i + 1];
            if(count.get(type1) > count.get(type2)) {
                sb.append(types[i]);
            } else if(count.get(type2) > count.get(type1)) {
                sb.append(types[i + 1]);
            } else {
                sb.append(type1.charAt(0) > type2.charAt(0) ? type2 : type1);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        System.out.println(solution(survey, choices));
    }
}
