package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Unfinished {
    static String hash(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hash = new HashMap<>();

        for(String player : participant) {
            hash.put(player, hash.getOrDefault(player, 0) + 1);
        }

        for(String player : completion) {
            hash.put(player, hash.get(player) - 1);
        }

        Iterator<Map.Entry<String, Integer>> iter = hash.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

    static String sort(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++) {
            if(participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }

    public static void main(String[] args) {
        String[] p = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] c = {"josipa", "filipa", "marina", "nikola"};

        String result = sort(p, c);
        System.out.println(result);
    }
}
