package programmers.level1;

import java.util.HashMap;
import java.util.Map;

/* 대충 만든 자판 */
public class CrudeKeyboard {
    private static final Map<String, Integer> alphabets = new HashMap<>();

    private static void getAlphabets(String[] keymap) {
        for(int i = 'A'; i <= 'Z'; i++) {
            int min = 101;
            String s = String.valueOf((char)i);

            for(String key : keymap) {
                if(key.contains(s)) {
                    min = Math.min(min, key.indexOf(s) + 1);
                }
            }

            alphabets.put(s, min < 101 ? min : -1);
        }
    }

    private static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        getAlphabets(keymap);

        for(int i = 0; i < targets.length; i++) {
            int cnt = 0;
            String target = targets[i];

            for(int j = 0; j < target.length(); j++) {
                int tmp = alphabets.get(String.valueOf(target.charAt(j)));
                if(tmp == -1) {
                    cnt = -1;
                    break;
                } else {
                    cnt +=tmp;
                }
            }

            answer[i] = cnt;
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};

        solution(keymap, targets);
    }
}
