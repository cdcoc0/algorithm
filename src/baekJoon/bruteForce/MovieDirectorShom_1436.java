package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 영화감독 숌_1436
 * comment : 가장 간단한 방법
 */
public class MovieDirectorShom_1436 {
    private int getTheEndNumber(int N) {
        int num = 666;

        while(N > 1) {
            num++;

            if(String.valueOf(num).contains("666")) {
                N--;
            }
        }

        return num;
    }

    public static void main(String[] args) throws IOException {
        MovieDirectorShom_1436 main = new MovieDirectorShom_1436();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(main.getTheEndNumber(N));
    }
}
