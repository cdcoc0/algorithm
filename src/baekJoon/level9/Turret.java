package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Turret {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int rep = Integer.parseInt(br.readLine());
        for(int i = 0; i < rep; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int calX = (int)Math.pow(x1 - x2, 2);
            int calY = (int)Math.pow(y1 - y2, 2);
            if(x1 == x2 && y1 == y2 && r1 == r2)
                sb.append("-1\n");
            else if(calX + calY > (int)Math.pow(r1 + r2, 2)) //x, y의 거리가 r보다 길 때
                sb.append("0\n");
            else if(calX + calY < (int)Math.pow(r1 - r2, 2)) //x, y의 거리가 보다 짧을 때(원 안에서 접점 없을 때)
                sb.append("0\n");
            else if(calX + calY == (int)Math.pow(r1 + r2, 2))
                sb.append("1\n");
            else if(calX + calY == (int)Math.pow(r1 - r2, 2))
                sb.append("1\n");
            else
                sb.append("2\n");
        }

        System.out.println(sb);
    }
}
