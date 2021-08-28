package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class apex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[3];
        for(int i = 0; i < 3; i++) {
            input[i] = br.readLine();
        }

        int[] x = new int[3];
        int[] y = new int[3];

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(input[i]);
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int fourthX = x[0];
        int fourthY = y[0];

        if(x[0] == x[1])
            fourthX = x[2];
        else if(x[0] == x[2])
            fourthX = x[1];

        if(y[0] == y[1])
            fourthY = y[2];
        else if(y[0] == y[2])
            fourthY = y[1];

        System.out.println(fourthX + " " + fourthY);
    }
}

/*int[] coord_1 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
st = new StringTokenizer(br.readLine()," ");
int[] coord_2 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
st = new StringTokenizer(br.readLine()," ");
int[] coord_3 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
입력값을 변수에 담을 때 훨씬 효율적인 방식*/
