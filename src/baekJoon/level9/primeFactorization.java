package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class primeFactorization {

    static boolean[] primeFactorization(int n) {
        boolean[] prime = new boolean[(int)(Math.sqrt(n)) + 1];

        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i < prime.length; i++) {
            if(prime[i] == true) continue;
            for(int j = i + 1; j < prime.length; j++) {
                if(j % i == 0) {
                    prime[j] = true;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) throws IOException {
        //너무 어렵게 풀었다...
        //그냥 2부터 sqrt N까지 나누기 하면 훨씬 간단하게 해결 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        int index = 2;
        int copyN = n;
        boolean[] prime = primeFactorization(n);
        while(copyN > 1) {
            if(index >= prime.length) {
                sb.append(copyN);
                break;
            }
            if(prime[index] == true) {
                index++;
                continue;
            }

            if(copyN % index == 0) {
                sb.append(index + "\n");
                copyN /= index;
                prime = primeFactorization(copyN);
            } else {
                index++;
            }
        }
        System.out.println(sb);
    }
}
