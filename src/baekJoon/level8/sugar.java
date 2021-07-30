package baekJoon.level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sugar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        if(n % 5 == 0) {
            result = n / 5;
        } else {
            while (n >= 3) {
                if (n == 3 || n == 6 || n == 9 || n == 12)
                    break;
                n -= 5;
                result++;
            }

            if (n % 3 == 0) {
                result += n / 3;
            } else
                result = -1;
        }

        System.out.println(result);
    }
}