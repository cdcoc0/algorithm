package baekJoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class studyVoc {
    public static void main(String[] args) throws IOException {
    //알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
        String vocabulary = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            vocabulary = br.readLine();
        } while(vocabulary.length() > 1000000);
        vocabulary = vocabulary.toUpperCase();

        int[] cnt = new int[26];

        for(int i = 0; i < vocabulary.length(); i++) {
            int n = vocabulary.charAt(i)-'A';
            cnt[n] += 1;
        }

        int max = -1;
        char index = '?';
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] > max) {
                max = cnt[i];
                index = (char)(i+'A');
            } else if(max == cnt[i])
                index = '?';
        }

        System.out.println(index);
    }
}
