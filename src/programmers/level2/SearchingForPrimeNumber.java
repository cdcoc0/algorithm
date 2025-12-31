package programmers.level2;

import java.util.HashSet;

/**
 * 소수 찾기 (완전탐색)
 */
public class SearchingForPrimeNumber {
    private boolean[] prime;

    SearchingForPrimeNumber() {
        this.createPrimeArray();
    }

    private void createPrimeArray() {
        double maxLength = 9999999;
        this.prime = new boolean[9999999];

        prime[0] = prime[1] = true;

        for(int i = 3; i <= Math.sqrt(maxLength); i+= 2){   // 홀수만
            if(this.prime[i]) continue;
            for(int j = i + i; j < maxLength; j += i) {
                this.prime[j] = true;
            }
        }
    }

    private boolean isPrime(int number) {
        return !this.prime[number] && !(number > 2 && number % 2 == 0);
    }

    // 모든 경우의 수 탐색,,
    private void permutation(String str, String[] numbers, HashSet<Integer> set, boolean[] isVisited) {
        if(!str.isEmpty() && this.isPrime(Integer.parseInt(str))) set.add(Integer.parseInt(str));

        for(int i = 0; i < numbers.length; i++){
            if(str.length() < numbers.length && !isVisited[i]) {
                isVisited[i] = true;
                this.permutation(str + numbers[i], numbers, set, isVisited);
                isVisited[i] = false;
            }
        }
    }

    private int getCountPrimes(String[] numbers) {
        int len = numbers.length;
        HashSet<Integer> set = new HashSet<>();
        boolean[] isVisited = new boolean[len];

        this.permutation("", numbers, set, isVisited);

        return set.size();
    }

    public static void main(String[] args) {
        SearchingForPrimeNumber main = new SearchingForPrimeNumber();    // output 6; [3, 13, 31, 41, 43, 431]

        System.out.println(main.getCountPrimes("143".split("")));
    }
}
