package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 일곱 난장이_2309_v2
 * comment : 정렬 후 sum값과 100 비교
 */
public class SevenDwarfs_2309_v2 {
    private void getSevenDwarfs(int[] heights, int sum) {
        int l = 0;
        int r = heights.length - 1;

        Arrays.sort(heights);

        while (sum - heights[l] - heights[r] != 100) {
            if (sum - heights[l] - heights[r] > 100) l++;    // 더 큰 값을 뺌
            if (sum - heights[l] - heights[r] < 100) r--;    // 더 작은 값을 뺌
        }

        for(int i = 0; i < heights.length; i++) {
            if(i == l || i == r) continue;

            System.out.println(heights[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        SevenDwarfs_2309_v2 main = new SevenDwarfs_2309_v2();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int sum = 0;
        for(int i = 0; i < heights.length; i++){
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        main.getSevenDwarfs(heights, sum);
    }
}
