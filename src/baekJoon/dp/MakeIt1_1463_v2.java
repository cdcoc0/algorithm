package baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기_1463
 * comment : dp (memoization)
 */
public class MakeIt1_1463_v2 {
    private int getMinOperation(int X) {
        int[] memoization = new int[X+1];

        for(int i = 2; i <= X; i++) {
            memoization[i] = memoization[i-1] + 1;  // 마이너스 1 케이스

            if(i % 2 == 0) {
                memoization[i] = Math.min(memoization[i], memoization[i/2]+1);  // 이전 2의 배수에서 1회 카운트 추가
            }

            if(i % 3 == 0) {
                memoization[i] = Math.min(memoization[i], memoization[i/3]+1);
            }
        }

        return memoization[X];
    }

    public static void main(String[] args) throws IOException {
        MakeIt1_1463_v2 main = new MakeIt1_1463_v2();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        System.out.println(main.getMinOperation(X));
    }
}
