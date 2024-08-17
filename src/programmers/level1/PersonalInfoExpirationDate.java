package programmers.level1;

import java.util.*;

/* 개인정보 수집 유효기간 */
public class PersonalInfoExpirationDate {
    private static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> expired = new ArrayList<>();
        Map<String, Integer> mapTerms = new HashMap<>();

        int chkDay = getDate(today);

        for(String t : terms) {
            String[] split = t.split(" ");
            mapTerms.put(split[0], Integer.parseInt(split[1]));
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int expireDate = getDate(privacy[0]) + mapTerms.get(privacy[1]) * 28;

            if(chkDay >= expireDate) {
                expired.add(i + 1);
            }
        }

        Collections.sort(expired);

        return expired.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getDate(String date) {
        String[] split = date.split("\\.");

        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        return year * 12 * 28 + month * 28 + day;
    }

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        solution(today, terms, privacies);
    }
}
