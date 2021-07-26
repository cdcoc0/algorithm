package baekJoon.level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class president {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[] sum = new int[n];
            for(int j = 0; j < n; j++) {
                sum[j] = j + 1;
            }

            for(int j = 0; j < k; j++) {
                for(int l = 1; l < n; l++) {
                    sum[l] = sum[l - 1] + sum[l];
                }
            }
            sb.append(sum[n - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
