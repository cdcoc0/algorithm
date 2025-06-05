package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 압축 */
public class Compression {
    private void initDictionary(Map<String, Integer> dictionary) {
        dictionary.clear();

        for(int i = 'A'; i <= 'Z'; i++) {
            dictionary.put(Character.toString(i), i - 'A' + 1);
        }
    }

    private int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        initDictionary(dictionary);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < msg.length();) {
            sb.setLength(0);
            int index = dictionary.get(Character.toString(msg.charAt(i)));
            sb.append(msg.charAt(i));

            while(true) {
                i++;
                if(i >= msg.length()) break;

                sb.append(msg.charAt(i));
                int tmp = dictionary.getOrDefault(sb.toString(), 0);
                if(tmp > 0) {
                    index = tmp;
                } else {
                    dictionary.put(sb.toString(), dictionary.size() + 1);
                    break;
                }
            }

            answer.add(index);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Compression main = new Compression();
        String msg = "KAKAO";
        main.solution(msg);
    }
}
