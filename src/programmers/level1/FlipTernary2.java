package programmers.level1;

public class FlipTernary2 {
    static int solution(int n) {
        String sum = "";

        while(n >= 3) {
            sum = sum + (n % 3);
            n /= 3;
        }
        sum += n;

        int answer = Integer.parseInt(sum, 3);

        return answer;
    }
}
