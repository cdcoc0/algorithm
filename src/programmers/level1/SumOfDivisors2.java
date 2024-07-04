package programmers.level1;

/* 약수 */
public class SumOfDivisors2 {
    private static int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                answer += i;

                if(i == Math.sqrt(n)) {
                    break;
                }

                answer += n / i;

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(12));
    }
}
