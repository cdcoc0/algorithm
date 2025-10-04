package programmers.level2;

/* 주식 가격 */
public class StockPrice {
    private int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        for(int i = 0; i < len - 1; i++) {
            int tmp = prices[i];
            for(int j = i + 1; j < len; j++) {
                if(prices[j] < tmp || j == len - 1) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice main = new StockPrice();

        int[] prices = {1, 2, 3, 2, 3};
        main.solution(prices);
    }
}
