package baekJoon.level8;

import java.util.Scanner;

public class hive {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int num = stdIn.nextInt();
        int sum = 1;
        int i;
        for(i = 0; sum < num; i++) {
            sum += i * 6;
        }

        if(num == 1)
            System.out.println(1);
        else
            System.out.println(i);
    }
}
