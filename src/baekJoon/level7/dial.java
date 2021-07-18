package baekJoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dial {
    public static void main(String[] args) throws IOException {
        String word = "";
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            word = br.readLine().toUpperCase();
        } while(word.length() < 2 || word.length() > 15);

        for(int i = 0; i < word.length(); i++) {
            int a = (word.charAt(i)-'A');
            if(a < 15) {
                sum += a / 3 + 3;
            } else if(a < 19) {
                sum += 8;
            } else if(a < 22) {
                sum += 9;
            } else {
                sum += 10;
            }
        }
        //switch-case문 사용하면 보다 효율적일 수 있음
        System.out.println(sum);
    }
}
