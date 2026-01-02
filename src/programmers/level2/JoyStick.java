package programmers.level2;

/**
 * 조이스틱 (탐욕법, Greedy)
 */
public class JoyStick {
    private int solution(String name) {
        int answer = 0, prev = 0, cnt = Integer.MAX_VALUE;
        for (int i = 0; i < name.length(); i++) {
            // 유턴 방향 앞 -> 뒤, 뒤 -> 앞 cnt 비교
            char c = name.charAt(i);
            if (c != 'A') {
                answer += Math.min(c-'A', 'Z'-c+1);

                if (i == 0) continue;
                int forward = prev * 2 + (name.length()-i);
                int reverse = prev + (name.length()-i) * 2;

                cnt = Math.min(cnt, Math.min(forward, reverse));
                prev = i;
            }
        }

        cnt = Math.min(cnt, prev);   // 커서가 이동하지 않는 케이스 (문자열 길이가 0이거나 등)

        return answer+cnt;
    }

    public static void main(String[] args) {
        JoyStick main = new JoyStick();

//        String name = "AABAAABAA";  //7
        String name = "JEROEN";  //7
        main.solution(name);
    }
}