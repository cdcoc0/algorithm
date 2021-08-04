package baekJoon.level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class plus2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        String a = st.nextToken();
        String b = st.nextToken();

        int aLength = a.length();
        int bLength = b.length();
        int cnt = max(aLength, bLength);

        int[] arrayA = new int[cnt + 1];
        int[] arrayB = new int[cnt];

        for(int i = 0; i < aLength; i++) {
            arrayA[i] = a.charAt(aLength - i - 1)-'0';
        }

        for(int i = 0; i < bLength; i++) {
            arrayB[i] = b.charAt(bLength - i - 1)-'0';
        }

        for(int i = 0; i < cnt; i++) {
            int sum = arrayA[i] + arrayB[i];
            arrayA[i] = sum % 10;
            arrayA[i + 1] += sum / 10;
        }

        StringBuilder sb = new StringBuilder();
        if(arrayA[cnt] == 0)
            cnt--;

        for(int i = cnt; i >= 0; i--) {
            sb.append(arrayA[i]);
        }

        System.out.println(sb);
    }
}
