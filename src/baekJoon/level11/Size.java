package baekJoon.level11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Size {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];
        int[] height = new int[n];

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            StringTokenizer st = new StringTokenizer(temp);
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                if(j == i)
                    continue;
                if(weight[j] > weight[i] && height[j] > height[i])
                    sum++;
            }
            sb.append((sum + 1) + " ");
        }

        System.out.println(sb.toString());
    }
}
