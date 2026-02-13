package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 메뉴 리뉴얼 (2021 KAKAO BLIND RECRUITMENT)
 * comment : Brute Force 사용
 */
public class MenuRenewal {
    private void permutation(HashMap<String, Integer> record, int num, int cur, int start, String order, String permu) {
        if(cur == num) {
            record.put(permu, record.getOrDefault(permu, 0) + 1);
        } else {
            for(int i = start; i < order.length(); i++) {
                permutation(record, num, cur+1, i+1, order, permu+order.charAt(i));
            }
        }
    }

    private String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> record = new HashMap<>();
        List<String> compare = new ArrayList<>();
        List<String> result = new ArrayList<>();

        // 모든 경우의 수를 만든 후 count
        for(int num : course) {
            for(String order : orders) {    // 주문별 조합
                // 주문 정렬
                char[] charArr = order.toCharArray();
                Arrays.sort(charArr);

                // 조합
                this.permutation(record, num, 0, 0, String.valueOf(charArr), "");
            }

            int max = 2;
            for(String keySet : record.keySet()) {
                Integer val = record.get(keySet);
                if(val > max) {
                    compare.clear();
                    max = val;
                }

                if(record.get(keySet) >= max) {
                    compare.add(keySet);
                }
            }

            result.addAll(compare);
            compare.clear();
            record.clear();
        }

        result.sort(String::compareTo);

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        MenuRenewal main = new MenuRenewal();

//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2, 3, 4};

        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};

//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2, 3, 4};

        main.solution(orders, course);
    }
}
