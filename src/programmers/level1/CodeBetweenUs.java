package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/* 둘만의 암호 */
public class CodeBetweenUs {
    private static String solution(String s, String skip, int index) {
        List<Character> alphabets = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 'a'; i <= 'z'; i++) {
            alphabets.add((char)i);
        }

        for(int i = 0; i < skip.length(); i++) {
            alphabets.remove(Character.valueOf(skip.charAt(i)));
        }

        for(int i = 0; i < s.length(); i++) {
            int idx = alphabets.indexOf(s.charAt(i));
            sb.append(alphabets.get((idx + index) % alphabets.size()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        System.out.println(solution(s, skip, index));
    }
}
