package programmers.level2;

/* 멀리뛰기 */
public class LongJump {
    static long solution(int n) {
        long[] tmp = new long[n + 2];
        tmp[1] = 1;
        tmp[2] = 2;

        for(int i = 3; i <= n; i++) {
            tmp[i] = (tmp[i - 2] + tmp[i - 1]) % 1234567;
            System.out.println(tmp[i]);
        }

        return tmp[n];
    }

    public static void main(String[] args) {
        int n = 2000;
        System.out.println(solution(n));
    }
}
