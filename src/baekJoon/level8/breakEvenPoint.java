package baekJoon.level8;

import java.util.Scanner;

public class breakEvenPoint {
    public static void main(String[] args) {
        int a;
        int b;
        int c;

        Scanner stdIn = new Scanner(System.in);
        a = stdIn.nextInt();
        b = stdIn.nextInt();
        c = stdIn.nextInt();

        if(b >= c)
            System.out.println(-1);
        else
            System.out.println(a / (c - b) + 1);
    }
}
