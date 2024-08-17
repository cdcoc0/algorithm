package programmers.level1;

import java.util.Arrays;

/* 가장 가까운 같은 글자 */
public class NearestSameString {
    private static int[] solution(String s) {
        int len = s.length();
        int[] location = new int[26];
        int[] answer = new int[len];

        Arrays.fill(location, -1);

        for(int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            answer[i] = location[idx] > -1 ?  i - location[idx] : -1;
            location[idx] = i;
        }

        return answer;
    }
    public static void main(String[] args) {
        String s = "banana";
        solution(s);
    }
}
