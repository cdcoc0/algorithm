package baekJoon.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixAddition2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String nm = br.readLine();
            String[] arrNm = nm.split(" ");
            int n = Integer.parseInt(arrNm[0]);    // 행
            int m = Integer.parseInt(arrNm[1]);    // 열

            int[][] input1 = new int[n][m];
            int[][] input2 = new int[n][m];

            for(int i = 0; i < n; i++) {
                String[] arrN = br.readLine().split(" ");
                for(int j = 0; j < m; j++) {
                    input1[i][j] = Integer.parseInt(arrN[j]);
                }
            }

            for(int i = 0; i < n; i++) {
                String[] arrN = br.readLine().split(" ");
                for(int j = 0; j < m; j++) {
                    input2[i][j] = Integer.parseInt(arrN[j]);
                }
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < n; i++) {
                sb.append(input1[i][0] + input2[i][0]);
                for(int j = 1; j < m; j++) {
                    sb.append(" ");
                    sb.append(input1[i][j] + input2[i][j]);
                }
                System.out.println(sb.toString());
                sb.setLength(0);
            }
        }
}
