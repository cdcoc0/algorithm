package baekJoon.level7;

import java.util.Scanner;

public class findAlphabet {
    public static void main(String[] args) {
        //알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를,
        // 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
        String s = "";
        int[] sum = new int[26];

        Scanner stdIn = new Scanner(System.in);
        do {
            s = stdIn.next();
            //소문자 확인 관련 로직
        } while(s.length() > 100);

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for(int i = 0; i < alphabet.length; i++) {
            sum[i] = s.indexOf(alphabet[i]);
        }
//        for(int i = 0; i < sum.length; i++) {
//            System.out.print(sum[i]);
//            System.out.print(" ");
//        }
        for(int val : sum) {
            System.out.print(val + " ");
        }
    }
}
