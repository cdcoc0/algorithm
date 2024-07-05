package programmers.level1;

import java.util.Scanner;
import java.util.stream.IntStream;

/* 직사각형 별찍기 */
public class SquareStars2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb =  new StringBuilder();

        sb.append("*".repeat(Math.max(0, a)));    // String.repeat 함수는 속도가 느리다..!

        for(int i = 0; i < b; i++) {
            System.out.println(sb);
        }

//        String row = "\n" + sb.toString();
//        sb.append(row.repeat(b - 1));
//
//        System.out.println(sb);

//        StringBuilder sb = new StringBuilder();
//        IntStream.range(0, a).forEach(s -> sb.append("*"));
//        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
    }
}
