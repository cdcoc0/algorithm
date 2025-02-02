package programmers.level2;

import java.util.Arrays;

/* 최솟값 만들기 */
public class MakeMinValue {
    private static int solution(int []A, int []B)
    {
        int answer = 0;
        int n = A.length - 1;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i <= n; i++) {
            answer += A[i] * B[n - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};

        System.out.println(solution(a, b));
    }
}
