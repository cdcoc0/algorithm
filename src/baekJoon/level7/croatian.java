package baekJoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class croatian {
    public static void main(String[] args) throws IOException {
        String alphabet = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            alphabet = br.readLine();
        } while(alphabet.length() > 100);

        String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(int i = 0; i < croatian.length; i++) {
            alphabet = alphabet.replace(croatian[i], "a");
        }

        System.out.println(alphabet.length());
    }
}
