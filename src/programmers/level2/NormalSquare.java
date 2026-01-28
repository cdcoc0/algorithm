package programmers.level2;

/**
 * 멀쩡한 사각형 (Summer/Winter Coding(2019))
 * comment : 규칙을 찾아야 했던 문제,,
 */
public class NormalSquare {
    private int getGcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return getGcd(b, a % b);
    }

    private long solution(int w, int h) {
        int gcd = getGcd(w, h);
        int tmpW = w/gcd;
        int tmpH = h/gcd;

        // 최대공약수 그룹에서 살아남는 칸 = (최대공약수 그룹 가로-1) * (최대공약수 그룹 세로-1)
        // 답 = 전체 사각형 넓이 - 최대공약수 * 최대공약수 그룹에서 빠지는 칸
        return (long) w * h - gcd * ((long) tmpW * tmpH - ((long) (tmpW - 1) * (tmpH-1)));
    }

    public static void main(String[] args) {
        NormalSquare main = new  NormalSquare();

        int W = 8;
        int H = 12;
        System.out.println(main.solution(W, H));
    }
}
