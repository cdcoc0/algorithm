package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 괄호 회전하기 (월간 코드 챌린지 시즌2)
 * comment : 역행하며 체크하는 문제 (stack)
 */
public class RotateBrackets {
    public static void main(String[] args) {
        String s = "{";
        System.out.println(main.solution(s));
    }

    static class main {
        static int isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if(tmp == '(' || tmp == '{' || tmp == '[') {
                    stack.push(tmp);
                    continue;
                }

                if(stack.isEmpty()) return 0;

                char open = stack.pop();
                if(open >= tmp || tmp - open > 2) return 0;
            }

            return stack.isEmpty() ? 1 : 0;

//            char[] open = new char[s.length()/2];
//            int ptr = 0;
//
//            for(int i = 0; i < s.length(); i++) {
//                char tmp = s.charAt(i);
//                if(tmp == '(' || tmp == '{' || tmp == '[') {
//                    if(ptr >= open.length) return 0;
//
//                    open[ptr++] = tmp;
//                    continue;
//                }
//
//                if(ptr <= 0 || tmp < open[ptr-1] || tmp - open[ptr-1] > 2) return 0;
//                ptr--;
//            }
//
//            return ptr > 0 ? 0 : 1;
        }

        static int solution(String s) {
            StringBuilder sb = new StringBuilder(s);
            int answer = 0;

            for(int i = 0; i < s.length(); i++) {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                answer += isValid(sb.toString());
            }

            return answer;
        }
    }
}
