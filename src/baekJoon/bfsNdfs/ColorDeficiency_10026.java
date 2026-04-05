package baekJoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 적록색약_10026 (DFS)
 */
public class ColorDeficiency_10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        Solution.solution(N, grid);
    }

    static class Solution {
        static boolean[][] visited;
        static int[] move = {0, 0, -1, 1};

        static void solution(int N, char[][] grid) {
            visited = new boolean[N][N];
            int rgb = 0;
            for(int i = 0; i < N;  i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        rgb++;
                        visited[i][j] = true;
                        dfs(i, j, N, grid);
                    }
                }
            }

            visited = new boolean[N][N];
            int nonRgb = 0;
            for(int i = 0; i < N;  i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        nonRgb++;
                        visited[i][j] = true;
                        nonRgbdfs(i, j, N, grid);
                    }
                }
            }

            System.out.println(rgb + " " + nonRgb);
        }

        static void dfs(int x, int y, int N, char[][] grid) {
            char current = grid[x][y];
            for(int i = 0; i < 4; i++) {
                int mx = x+move[i];
                int my = y+move[3-i];

                if(mx < 0 || my < 0 || mx >= N || my >= N || visited[mx][my]) continue;

                if(current == grid[mx][my]) {
                    visited[mx][my] = true;
                    dfs(mx, my, N, grid);
                }
            }
        }

        static void nonRgbdfs(int x, int y, int N, char[][] grid) {
            char current = grid[x][y];
            for(int i = 0; i < 4; i++) {
                int mx = x+move[i];
                int my = y+move[3-i];

                if(mx < 0 || my < 0 || mx >= N || my >= N || visited[mx][my]) continue;

                if(current == 'B') {
                    if(current == grid[mx][my]) {
                        visited[mx][my] = true;
                        nonRgbdfs(mx, my, N, grid);
                    }
                } else {
                    if(grid[mx][my] == 'G' || grid[mx][my] == 'R') {
                        visited[mx][my] = true;
                        nonRgbdfs(mx, my, N, grid);
                    }
                }
            }
        }
    }
}
