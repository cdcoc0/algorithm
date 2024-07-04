package programmers.level1;

/* 최대공약수와 최소공배수 */
public class CommonDivisorNMultiple {
    private static int[] solution(int n, int m) {
        int divisor = 1;

        for(int i = 2; i <= Math.min(n, m); i++) {
            if(n % i == 0 && m % i == 0) {
                divisor *= i;
                n /= i;
                m /= i;
                i = 1;
            }
        }

        return new int[]{divisor, divisor * n * m};
    }

    public static void main(String[] args) {
//        System.out.println(solution(3, 12)[0] + " - " + solution(3, 12)[1]);
        solution(1273, 31);
    }
}
