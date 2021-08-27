package programmers.level1;

public class squareRoot {
    static long solution(long n) {
        long root = (long)Math.sqrt(n);
        return Math.sqrt(n) == root ? (root + 1) * (root + 1) : -1;
    }
    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}

//개인적으로 Math.sqrt(n) % 1 == 0 으로 확인하는 방법이 제일 간편해보였음
//가능하면 같은 타입으로 수를 비교하는 게 나을 수도