package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class goldBach {
    static boolean[] prime = new boolean[10000];

    static boolean[] getPrime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= 100; i++) {
            if(prime[i] == true) continue;
            for(int j = i * i; j < 10000; j += i) {
                prime[j] = true;
            }
        }

        return prime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            getPrime();
//            for(int j = n / 2; j >= 1; j--) {
//                if(prime[j] == true) continue;
//                if(prime[n - j] == false) {
//                    sb.append(j + " " + (n - j) + "\n");
//                    break;
//                }
//            }
            int decrease = n / 2;
            int increase = n / 2;
            while(decrease > 0) {
                if(prime[decrease] == false && prime[increase] == false) {
                    sb.append(decrease + " " + increase + "\n");
                    break;
                }
                decrease -= 1;
                increase += 1;
            }
        }
        System.out.println(sb);
    }
}
