package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 일곱 난장이_2309
 */
public class SevenDwarfs_2309 {
    private void getSevenDwarfs(int[] heights) {
        int[] result = new int[7];
        int ptr = 0;

        for(int i = 0; i < heights.length; i++) {
            for(int j = i+1; j < heights.length; j++) {
                int tmp = 0;
                for(int k = 0; k < heights.length; k++) {
                    if(k == i || k == j) continue;
                    result[ptr++] = heights[k];
                    tmp += heights[k];
                }

                if(tmp == 100) {
                    Arrays.sort(result);
                    for(int r : result) {
                        System.out.println(r);
                    }

                    return;
                }

                result = new int[7];
                ptr = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SevenDwarfs_2309 main = new SevenDwarfs_2309();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        for(int i = 0; i < heights.length; i++){
            heights[i] = Integer.parseInt(br.readLine());
        }

        main.getSevenDwarfs(heights);
    }
}
