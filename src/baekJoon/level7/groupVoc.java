package baekJoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class groupVoc {
    static int check(String word) {
        int[] all = new int[26];
        for(int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i)-'a';
            if(all[ch] == 0) {
                all[ch] = 1;
            } else if(all[ch] == 1 && word.charAt(i) != word.charAt(i - 1))
                return -1;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] group = new String[num];
        for(int i = 0; i < num; i++) {
            group[i] = br.readLine();
        }

        int[] cnt = new int[num];
        for(int i = 0; i < num; i++) {
            cnt[i] = check(group[i]);
        }

        int answer = 0;
        for(int val : cnt) {
            if(val == 1)  answer += 1;
        }

        System.out.println(answer);
    }
    //배열을 안쓰고 readLine() 메서드를 아예 따로 분리시킨 함수에서 처리하면 코드 길이가 짧아짐
    //prev, now 변수를 만들어 간단하게 할 수 있음
}
