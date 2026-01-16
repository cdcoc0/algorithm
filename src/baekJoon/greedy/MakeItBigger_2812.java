package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 크게 만들기_2812
 */
public class MakeItBigger_2812 {
    private String getNumber(int N, int K, String number) {
        Stack<Integer> stack = new Stack<>();
        int ptr = 0;
        while(K > 0 || ptr < N) {   // K만큼 삭제되고, 모든 문자열 순회되어야 끝남
            if(K <= 0) {
                stack.push(number.charAt(ptr++)-'0');
                continue;
            }

            if(stack.isEmpty()) {
                stack.push(number.charAt(ptr++)-'0');
            }

            if(ptr >= N || stack.peek() < number.charAt(ptr)-'0') {
                stack.pop();
                K--;
            } else {
                stack.push(number.charAt(ptr++)-'0');
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        MakeItBigger_2812 main = new MakeItBigger_2812();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        String number = br.readLine();

        System.out.println(main.getNumber(Integer.parseInt(split[0]), Integer.parseInt(split[1]), number));
    }
}
