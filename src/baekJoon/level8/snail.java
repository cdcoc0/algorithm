package baekJoon.level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class snail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        int days = (int)Math.ceil((double)(v - a) / (a - b)) + 1;

//        if(v == a)
//            days = 0;
//        else if(v - a < a)
//            days = 1;
//        else {
//            v -= a;
//            days = v / (a - b);
//        }

        //v -= a;

//        while(v > a) {
//            v -= (a - b);
//            days++;
//        }

        System.out.println(days);
    }
}
