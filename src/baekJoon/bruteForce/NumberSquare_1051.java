package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자 정사각형_1051
 */
public class NumberSquare_1051 {
    private void getSize(String[] rectangle, int N, int M) {
        int side = Math.min(N, M);

        for(; side > 1; side--) {
            for(int i = 0; i <= N-side; i++){
                for(int j = 0; j <= M-side; j++){
                    char compare = rectangle[i].charAt(j);
//                    System.out.println("i : " + i + " j : " + j + " compare : " + compare + " side : " + side);
                    if(rectangle[i+side-1].charAt(j) == compare && rectangle[i].charAt(j+side-1) == compare && rectangle[i+side-1].charAt(j+side-1) == compare){
                        System.out.println(side * side);
                        return;
                    }
                }
            }
        }

        System.out.println(1);
    }

    public static void main(String[] args) throws IOException {
        NumberSquare_1051 main = new NumberSquare_1051();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]); // 세로
        int M = Integer.parseInt(split[1]);   // 가로

        String[] rectangle = new String[N];
        for(int i = 0; i < N; i++) {
            rectangle[i] = br.readLine();
        }

        main.getSize(rectangle, N, M);
    }
}
