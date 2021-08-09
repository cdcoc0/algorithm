package baekJoon.level9;

import java.util.Scanner;

public class primeNumber {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] arrayN = new int[n];
        for(int i = 0; i < n; i++) {
            arrayN[i] = stdIn.nextInt();
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arrayN[i] == 2 || arrayN[i] == 3)
                cnt++;
            else if(arrayN[i] == 1 || arrayN[i] % 2 == 0)
                continue;
            else {
                int a = 0;
                for(int j = 3; j <= Math.sqrt(arrayN[i]); j += 2) {
                    if(arrayN[i] % j == 0) {
                        a++;
                        break;
                    }
                }
                if(a == 0)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
