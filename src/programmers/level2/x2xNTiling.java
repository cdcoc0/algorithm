package programmers.level2;

/* 2*n 타일링 */
public class x2xNTiling {
    private static int solution(int n) {
        int answer = 0;

        if(n <= 3) {
            return n;
        }

        int[] tmp = {2, 3};

        for(int i = 4; i <= n; i++) {
            tmp[i % 2] = tmp[0] + tmp[1] % 1000000007;
        }

        return tmp[n % 2];
    }

    public static void main(String[] args) {
        System.out.println(solution(30));
    }
}
