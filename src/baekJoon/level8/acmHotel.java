package baekJoon.level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmHotel {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int calculate() throws IOException {
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int h = Integer.parseInt(st.nextToken());
        st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int room = n / h + 1;
        int floor = n % h;
        if(floor == 0) {
            floor = h;
            room = n / h;
        }

        return floor * 100 + room;
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        int[] result = new int[t];
        for(int i = 0; i < t; i++) {
            result[i] = calculate();
        }

        for(int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
        //배열 대신 StringBuilder을 사용해봐도 될 것 같다.
    }
}
