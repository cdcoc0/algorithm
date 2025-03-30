package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

/* 짝지어 제거하기 */
public class EliminatePairs {
    private static int solution(String s)
    {
        //stack,,
        Deque<String> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek().equals(s.charAt(i) + "")) {
                stack.pop();
            } else {
                stack.push(s.charAt(i) + "");
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }
}
