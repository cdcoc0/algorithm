package programmers.level2;

import java.util.Arrays;

/* 땅따먹기 */
public class GainingTerritory {
    static int solution(int[][] land) {
        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
            land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
            land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();

        /*
        int[][] tmp = new int[land.length][4];
        tmp[0][0] = land[0][0];
        tmp[0][1] = land[0][1];
        tmp[0][2] = land[0][2];
        tmp[0][3] = land[0][3];

        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int tmpMax = 0;
                for(int k = 0; k < 4; k++) {
                    if(k == j) continue;

                    if(tmp[i - 1][k] > tmpMax) {
                        tmpMax = tmp[i - 1][k];
                    }
                }
                tmp[i][j] = tmpMax + land[i][j];
            }
        }

        int max = 0;
        for(int i = 0; i < 4; i++) {
            if(tmp[land.length-1][i] > max) max = tmp[land.length-1][i];
        }

        return max;
        */
    }

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(solution(land));
    }
}
