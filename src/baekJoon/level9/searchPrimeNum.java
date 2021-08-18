package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class searchPrimeNum {
    public static boolean[] prime(int n) {
        boolean[] eratos = new boolean[n + 1];
        eratos[0] = true;
        eratos[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(eratos[i] == true) continue;
            for(int j = i * i; j <= n; j += i) {
                eratos[j] = true;
            }
        }
        return eratos;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] primeNum = prime(n);
        StringBuilder sb = new StringBuilder();
        for(int i = m; i <= n; i++) {
            if(!primeNum[i])
                sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}
