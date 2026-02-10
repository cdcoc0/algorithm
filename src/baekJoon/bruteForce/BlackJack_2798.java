package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 블랙잭_2798
 */
public class BlackJack_2798 {
    private void getResult(int[] cards, int N, int M) {
        int max = 0;

        Arrays.sort(cards);

        for(int i = cards.length - 1; i > 1; i--) {
            int cardI = cards[i];
            for(int j = i-1; j > 0; j--) {
                int cardJ = cards[j];
                if(cardI + cardJ > M) continue;

                for(int k = j-1; k >= 0; k--) {
                    if(cardI+cardJ+cards[k] == M) {
                        System.out.println(cardI+cardJ+cards[k]);
                        return;
                    }

                    if(cardI+cardJ+cards[k] < M) {
                        max = Math.max(max, cardI+cardJ+cards[k]);
                        break;
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BlackJack_2798 main = new BlackJack_2798();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        main.getResult(cards, N, M);
    }
}
