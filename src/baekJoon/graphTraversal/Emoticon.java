package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/* 이모티콘 */
public class Emoticon {
    private void execute(int S) {
        boolean[][] visited = new boolean[1001][1001];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0, 0});    // screen, clipboard, time

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int screen = tmp[0];
            int clipboard = tmp[1];
            int time = tmp[2];

            if(screen == S) {
                System.out.println(time);
                return;
            }

            // 복사
            if(clipboard != screen && !visited[screen][screen]) {
                visited[screen][screen] = true;
                queue.offer(new int[]{screen, screen, time + 1});
            }

            // 붙여넣기
            if(clipboard > 0 && screen + clipboard <= 1000 && !visited[screen + clipboard][clipboard]) {
                visited[screen + clipboard][screen] = true;
                queue.offer(new int[]{screen + clipboard, clipboard, time + 1});
            }

            // 삭제
            if(screen > 2 && !visited[screen - 1][clipboard]) {
                visited[screen - 1][clipboard] = true;
                queue.offer(new int[]{screen - 1, clipboard, time + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        Emoticon main = new Emoticon();
        main.execute(S);
    }
}
