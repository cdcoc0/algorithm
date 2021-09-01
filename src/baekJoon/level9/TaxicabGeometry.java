package baekJoon.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxicabGeometry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        double u = r * r * 3.14159265358979;
        double t = (r * 2) * (r * 2) / 2;

        System.out.printf("%f\n%f", u, t);
    }
}
