package baekJoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 영역 구하기_2583 (DFS/실버)
 */
public class GetArea_2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        int K = Integer.parseInt(split[2]);

        boolean[][] paper = new boolean[M][N];
        for(int i = 0; i < K; i++) {
            String[] coord = br.readLine().split(" ");
            int x1 = Integer.parseInt(coord[0]);
            int y1 = Integer.parseInt(coord[1]);
            int x2 = Integer.parseInt(coord[2]);
            int y2 = Integer.parseInt(coord[3]);

            for(int j = y1; j < y2; j++) {
                for(int k = x1; k < x2; k++) {
                    paper[j][k] = true;
                }
            }
        }

        Solution.solution(paper, M, N);
    }

    static class Solution {
        static int[] direction = {0, 0, 1, -1};
        static int width = 1;

        static void solution(boolean[][] paper, int M, int N) {
            StringBuilder sb = new StringBuilder();
            List<Integer> list = new ArrayList<>();
            int count = 0;

            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(!paper[i][j]) {
                        count++;
                        paper[i][j] = true;
                        dfs(paper, i, j);
                        list.add(width);
                        width = 1;
                    }
                }
            }

            list.sort(Comparator.comparingInt(Integer::intValue));

            sb.append(count).append("\n");
            for(Integer i : list) sb.append(i).append(" ");

            System.out.println(sb);
        }

        static void dfs(boolean[][] paper, int x, int y) {
            for(int i = 0; i < 4; i++) {
                int moveX = x + direction[i];
                int moveY = y + direction[3 - i];

                if(moveX < 0 || moveY < 0 || moveX >= paper.length || moveY >= paper[0].length) continue;
                if(paper[moveX][moveY]) continue;
                paper[moveX][moveY] = true;
                width++;

                dfs(paper, moveX, moveY);
            }
        }
    }
}
