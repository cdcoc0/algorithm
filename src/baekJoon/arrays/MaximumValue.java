package baekJoon.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumValue {
    public static void main(String[] args) throws IOException {
        int[][] number = new int[9][9];

        int max = -1;
        int row = -1;
        int col = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            String rows = br.readLine();
            String[] arrRows = rows.split(" ");

            for(int j = 0; j < 9; j++) {
                int n = Integer.parseInt(arrRows[j]);
                if(n > max) {
                    max = n;
                    row = i + 1;
                    col = j + 1;
                }
                number[i][j] = n;
            }
        }

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}
