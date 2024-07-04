package programmers.level1;

/* 유클리드 호제법으로 최대공약수 구하기 */
public class Euclidean {
    private static int gcd(int x, int y) {
        if(y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(3, 12));
    }
}
