package programmers.level2;

import java.util.Stack;

/* 올바른 괄호 */
public class TheRightBracket {
    private static boolean solution(String s) {
        Stack<Character> open = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                open.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if(open.isEmpty()) {
                    return false;
                } else {
                    open.pop();
                }
            }
        }

        return open.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));
    }
}
