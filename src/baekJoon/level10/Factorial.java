package baekJoon.level10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    static int factorial(int n) {
        if(n <= 1)
            return 1;
        return n * factorial(n - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.println(factorial(input));
    }
}

//입력값이 13을 넘어가는 경우 long 타입을 사용해야 한다.
