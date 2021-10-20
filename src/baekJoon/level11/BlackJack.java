package baekJoon.level11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int[] num = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;

        for(int i = 0; i < n - 2; i++) {
            if(num[i] > m)
                continue;
            for(int j = i + 1; j < n - 1; j++) {
                if(num[i] + num[j] > m)
                    continue;
                for(int k = j + 1; k < n; k++) {
                    int current = num[i] + num[j] + num[k];
                    if(current <= m && current > sum) {
                        sum = current;
                    }
                    if(current == m) {
                        System.out.println(current);
                        return;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

//크기 순으로 정렬 먼저 하는 게 효율적일지..?