package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class escapeFromSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int horizonal = w - x > x ? x : w - x;
        int vertical = h - y > y ? y : h - y;
        /*int horizonal = Math.min(x, w - x);
        int vertical = Math.min(y, h - y);*/

        int result = horizonal > vertical ? vertical : horizonal;

        System.out.println(result);
    }
}
