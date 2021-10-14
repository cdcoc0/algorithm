package programmers.level1;

public class MidLetter {
    static String solution(String s) {
        String answer = "";

        if(s.length() % 2 == 0)
            answer += s.charAt(s.length() / 2 - 1);

        answer += s.charAt(s.length() / 2);

        return answer;
    }

    //substring

    public static void main(String[] args) {
        System.out.print(solution("abcde"));
    }
}
