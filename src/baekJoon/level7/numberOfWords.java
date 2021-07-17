package baekJoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numberOfWords {

    public static void main(String[] args) throws IOException {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            s = br.readLine();
        } while(s.length() > 1000000);

        StringTokenizer stk = new StringTokenizer(s);
        System.out.println(stk.countTokens());
    }
}
