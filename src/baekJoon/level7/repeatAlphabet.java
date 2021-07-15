package baekJoon.level7;

import java.util.Scanner;

public class repeatAlphabet {
    public static void main(String[] args) {

        //문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
        //즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
        int t;

        Scanner stdIn = new Scanner(System.in);
        do {
            t =  stdIn.nextInt();
            stdIn.nextLine();
        } while(t < 1 || t > 1000);

        String[] s = new String[t];

        for(int i = 0; i < t; i++) {
            s[i] = stdIn.nextLine();
        }

        for(int i = 0; i < s.length; i++) {
            int n = Character.getNumericValue(s[i].charAt(0));
            for(int j = 2; j < s[i].length(); j++) {
                for(int k = 0; k < n; k++) {
                    System.out.print(s[i].charAt(j));
                }
            }
            System.out.println();
        }
    }
}
