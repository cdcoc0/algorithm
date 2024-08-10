package programmers.level1;

/* 옹알이(2) */
public class Babble {
    private static int solution(String[] babbling) {
        int answer = 0;

        String[] possible = {"aya", "ye", "woo", "ma"};

        for(String babble : babbling) {
            String word = babble;
            boolean repeat = false;

            for(String s : possible) {
                if(word.contains(s+s)) {
                    repeat = true;
                    break;
                }
            }

            if(!repeat) {
                for(String s : possible) {
                    word = word.replaceAll(s, " ");
                }

                if(word.isBlank()) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(solution(babbling));
    }
}
