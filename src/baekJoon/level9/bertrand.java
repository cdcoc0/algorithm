package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int cnt = 0;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            sb1.append(n + " ");
            cnt++;
        }
        StringTokenizer st = new StringTokenizer(sb1.toString());
        int[] arrayN = new int[cnt];
        for(int i = 0; i < cnt; i++){
            arrayN[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] prime = getPrime();
        for(int i = 0; i < arrayN.length; i++) {
            int cntPrime = 0;
            for(int j = arrayN[i] + 1; j <= arrayN[i] * 2; j++) {
                if(!prime[j]) {
                    cntPrime++;
                }
            }
            sb2.append(cntPrime + "\n");
        }
        System.out.println(sb2);
    }
}
