package programmers.level1;

public class InadequateCost {
    static long solution(int price, int money, int count) {
        long sum = 0;
        for(int i = 1; i <= count; i++) {
            sum += price * i;
        }

        return sum > money ? sum - money : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
}

//long totalPrice = (price * count * ((long)count + 1)) / 2;