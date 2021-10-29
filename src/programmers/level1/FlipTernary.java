package programmers.level1;

import java.util.StringTokenizer;

public class FlipTernary {
    static int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        int ptr = 1;

        while(n >= 3) {
            sb.append(n % 3 + " ");
            n /= 3;
        }
        sb.append(n);
        sb.reverse();

        StringTokenizer st = new StringTokenizer(sb.toString());

        answer += Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            answer += Math.pow(3, ptr++) * Integer.parseInt(st.nextToken());
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(229));
    }
}
