package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/* 게임 맵 최단거리 */
public class GameMapMinimumDistance {
    private static int solution(int[][] maps) {
        int answer = -1;

        int yLen = maps.length;
        int xLen = maps[0].length;
        boolean[][] visited = new boolean[yLen][xLen];
        int coordY = 0;
        int coordX = 0;
        int[] move = {0, 0, 1, -1};

        Queue<int[]> search = new LinkedList<>();
        search.add(new int[]{coordX, coordY, 1});
        visited[coordY][coordX] = true;

        while(!search.isEmpty()) {
            int[] tmp = search.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];
            int cnt = tmp[2];
            System.out.println("x : " + tmpX + " y : " + tmpY + " cnt : " + cnt);

            if(tmpX == xLen - 1 && tmpY == yLen - 1) {
                return cnt;
            }

            for(int i = 0; i < move.length; i++) {
                int movX = tmpX + move[i];
                int movY = tmpY + move[3 - i];

                if(movX < 0 || movY < 0 || movX >= xLen || movY >= yLen ) {
                    continue;
                }

                if(maps[movY][movX] == 0 || visited[movY][movX]) {
                    continue;
                }

                visited[movY][movX] = true;
                search.add(new int[]{movX, movY, cnt+1});
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}
