package programmers.level2;

/* 피보나치 수 */
public class FibonacciNumbers {
    static int solution(int n) {
        int answer = 0;
        int[] fibonacci = new int[2];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int i = 2; i <= n; i++) {
            if(i % 2 == 0) {
                fibonacci[0] = answer = (fibonacci[0] + fibonacci[1]) % 1234567 ;
            } else {
                fibonacci[1] = answer = (fibonacci[1] + fibonacci[0]) % 1234567 ;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 1500;
        System.out.println(solution(n));
    }
}
