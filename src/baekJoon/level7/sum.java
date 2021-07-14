package baekJoon.level7;

import java.util.Scanner;

//N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
public class sum {
    public static void main(String[] args) {
        int sum = 0;
        int n;
        String x = "";

        Scanner stdIn = new Scanner(System.in);
        do {
            n = stdIn.nextInt();
        } while(n < 1 || n > 100);

        do {
            x = stdIn.next();
        } while(x.length() != n);

        for(int i = 0; i < n; i++) {
            sum += Character.getNumericValue(x.charAt(i));
        }
        System.out.println(sum);
    }
}
