package programmers.level2;

/* n진수 게임 */
public class RadixNGame {
    private String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sbTmp = new StringBuilder();
        sb.append(0);
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
//        String[] numbers = new String[n];
        int len = p + (t - 1) * m;

//        for(int i = 0; i < n; i++) {
//            if(i < 10) {
//                numbers[i] = String.valueOf(i);
//            } else {
//                numbers[i] = Character.valueOf((char) (i - 10 + 'A')).toString();
//            }
//        }

        //Integer.toString() 함수 안쓰고
        int cnt = 1;
        while(sb.length() < len) {
            int tmp = cnt;
            sbTmp.setLength(0);
            while(tmp >= n) {
                sbTmp.insert(0, numbers[tmp % n]);
                tmp /= n;
            }
            sb.append(numbers[tmp]).append(sbTmp);
            cnt++;
        }

        for(int i = p; answer.length() < t; i += m) {
            answer += sb.charAt(i - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        RadixNGame main = new RadixNGame();
        int n = 16; // 진수
        int t = 16; // 구할 숫자 갯수
        int m = 2;  // 게임 참가 인원
        int p = 2;  // 튜브의 순서

        main.solution(n, t, m, p);
    }
}
