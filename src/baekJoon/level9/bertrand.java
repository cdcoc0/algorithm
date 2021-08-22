package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bertrand {
    static boolean[] getPrime() {
        boolean[] prime = new boolean[123456 * 2 + 1];
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i] == true) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
        return prime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] prime = getPrime();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int cnt = 0;
            for(int i = n + 1; i <= n * 2; i++) {
                if(!prime[i])
                    cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
