package baekJoon.level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class flyMe {
    static int distance(int x, int y) {
        int dist = y - x;
        int result = 0;

        int square = (int)Math.sqrt(dist);

        if(Math.sqrt(dist) == square) {
            result = square * 2 - 1;
        } else if(dist <= square * (square + 1)) {
            result = square * 2;
        } else {
            result = square * 2 + 1;
        }


//        while(true) {
//            for(int i = 1; i <= 2; i++) {
//                for (int j = 0; j < cnt; j++) {
//                    total -= 1;
//                    if (total == 0)
//                        return dist;
//                }
//                dist++;
//            }
//            cnt++;
//        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeat; i++) {
            String testCase = br.readLine();
            StringTokenizer st = new StringTokenizer(testCase);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(distance(x, y) + "\n");
        }
        System.out.println(sb);
    }
}
