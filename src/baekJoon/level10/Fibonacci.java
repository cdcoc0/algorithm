package baekJoon.level10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    static int fibonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(input));
    }
}
