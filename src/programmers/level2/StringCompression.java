package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 압축 (2020 KAKAO BLIND RECRUITMENT)
 * comment : 모든 케이스 전부 순회하는 방법보다 나은 방법 못찾음
 */
public class StringCompression {
    private int solution(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> split = new ArrayList<>();
        String compare = "";
        int count = 1;
        int answer = s.length() == 1 ? 1 : Integer.MAX_VALUE;

        for(int i = 1; i <= s.length()/2; i++){  // 기준 문자수
            for(int j = 0; j < s.length(); j+=i){
                split.add(s.substring(j, Math.min(j+i, s.length())));
            }

            for (String tmp : split) {
                if (tmp.equals(compare)) {
                    count++;
                } else {
                    sb.append(count < 2 ? "" : count).append(compare);
                    count = 1;
                    compare = tmp;
                }
            }

            sb.append(count < 2 ? "" : count).append(compare);
            answer = Math.min(answer, sb.length());

            split.clear();
            sb.setLength(0);
            count = 1;
            compare = "";
        }

        return answer;
    }

    public static void main(String[] args) {
        StringCompression main = new StringCompression();
//        String s = "abcabcabcabcdededededede"; //14
//        String s = "aabbaccc"; //7
//        String s = "ababcdcdababcdcd"; //9
//        String s = "abcabcdede"; //8
        String s = "xababcdcdababcdcd"; //17

        System.out.println(main.solution("a"));
    }
}
