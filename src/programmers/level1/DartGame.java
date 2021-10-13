package programmers.level1;

public class DartGame {
    static int solution(String dartResult) {
        //점수, 보너스, (옵션)
        int answer = 0;

        //자르기
        int[] score = new int[3];
        int cnt = 0;

        for(int i = 0; i < dartResult.length(); i++) {
            char current = dartResult.charAt(i);

            if(current == 'S' || current == 'D' || current == 'T') {
                int prev = dartResult.charAt(i - 1) - '0';
                if(prev == 0 && i - 1 != 0 && dartResult.charAt(i - 2) == '1')
                    prev = 10;
                char next = i == dartResult.length() - 1 ? '0' : dartResult.charAt(i + 1);

                if(current == 'S') {
                    score[cnt] = prev;
                } else if(current == 'D') {
                    score[cnt] = prev * prev;
                } else {
                    score[cnt] = prev * prev * prev;
                }

                if(next == '*' || next == '#') {
                    if(next == '*') {
                        score[cnt] *= 2;
                        if(cnt != 0)
                            score[cnt - 1] *= 2;
                    } else {
                        score[cnt] *= -1;
                    }
                }

                cnt++;
            }
        }

        /*for(int i = 0; i < score.length; i++) {
            answer += score[i];
        }*/
        answer = score[0] + score[1] + score[2];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("0D0S#0S"));
    }
}
