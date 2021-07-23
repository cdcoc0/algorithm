package baekJoon.level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class searchFraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int i;
        for(i = 1; num > i; i++) {
            num -= i;
        }
        if(i % 2 == 0) {
            System.out.println(num + "/" + (i - num + 1));
        } else {
            System.out.println((i - num + 1) + "/" + num);
        }
    }
}
