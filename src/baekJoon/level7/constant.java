package baekJoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class constant {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        String reversed = "";
        for(int i = nums.length() - 1; i >= 0; i--) {
            reversed += nums.charAt(i);
        }
        //StringBuilder().reverse() 메서드 사용하면 빠름

        String[] splitted = reversed.split(" ");
        int a = Integer.parseInt(splitted[0]);
        int b = Integer.parseInt(splitted[1]);
        System.out.println(a > b ? a : b);
    }
}
