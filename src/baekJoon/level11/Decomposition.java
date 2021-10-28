package baekJoon.level11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decomposition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String sm = String.valueOf(m);
        int max = (sm.length() - 1) * 9 + (sm.charAt(0) - '0');

        while(max >= sm.length()) {
            int sub = m - max;
            int copyS = sub;
            int sum = 0;

            while(copyS > 0) {
                sum += copyS % 10;
                copyS /= 10;
            }

            if(sub + sum == m) {
                System.out.println(sub);
                break;
            }
            max -= 1;
        }

        if(max < sm.length())
            System.out.println(0);
    }
}
