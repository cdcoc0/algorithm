package programmers.level1;

/* 콜라 문제 */
public class Coke {
    private static int solution(int a, int b, int n) {
        int answer = 0;
        int bottle = n;

        while(bottle >= a) {
            answer += bottle / a * b;
            bottle = (bottle / a) * b + (bottle % a);
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int n = 20;
        System.out.println(solution(a, b, n));
    }
}
