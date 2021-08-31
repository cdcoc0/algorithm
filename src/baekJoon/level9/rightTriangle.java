package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rightTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while(true) {
            input = br.readLine();
            if(input.charAt(0) == '0' && input.charAt(2) == '0' && input.charAt(4) == '0') break;

            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int max = a * a;
            int num1 = b * b;
            int num2 = c * c;
            if(b > a && b > c) {
                max = b * b;
                num1 = a * a;
            } else if(c > a && c > b) {
                max = c * c;
                num2 = a * a;
            }

            if(max == num1 + num2)
                sb.append("right\n");
            else
                sb.append("wrong\n");
        }

        System.out.println(sb);
    }
}

//피타고라스의 정리