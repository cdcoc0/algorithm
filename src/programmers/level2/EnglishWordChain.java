package programmers.level2;

import java.util.HashSet;
import java.util.Set;

/* 영어 끝말잇기 */
public class EnglishWordChain {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        set.add(words[0]);
        int num = 0;

        for(int i = 1; i < words.length; i++) {
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)
                || !set.add(words[i])) {
                num = i;
                break;
            }
        }

        if(num > 0) {
            answer[0] = num % n + 1;
            answer[1] = num / n + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        EnglishWordChain main = new EnglishWordChain();
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        main.solution(n, words);
    }
}
