package baekJoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 플로이드(11404) */
public class Floyd {
    static void main(int n, int[][] city) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(j == k) continue;
                    if(city[j][k] > city[j][i] + city[i][k]) {
                        city[j][k] = city[j][i] + city[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(city[i][j] == 10000001) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(city[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] city = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                city[i][j] = 10000001;
            }
        }

        for(int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);

            city[a][b] = Math.min(c, city[a][b]);
        }

        main(n, city);
    }
}
