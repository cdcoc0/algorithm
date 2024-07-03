package baekJoon.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixAddition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        String[] arrNm = nm.split(" ");
        int n = Integer.parseInt(arrNm[0]);
        int m = Integer.parseInt(arrNm[1]);

        String[] a = new String[n];
        String[] b = new String[n];
        String[] result = new String[n];

        for(int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }

        for(int i = 0; i < n; i++) {
            b[i] = br.readLine();
        }

        for(int i = 0; i < n; i++) {
            String[] split1 = a[i].split(" ");
            String[] split2 = b[i].split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.parseInt(split1[0]) + Integer.parseInt(split2[0]));
            for(int j = 1; j < m; j++) {
                sb.append(" ");
                sb.append(Integer.parseInt(split1[j]) + Integer.parseInt(split2[j]));
            }
            result[i] = sb.toString();
        }

        for(int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
