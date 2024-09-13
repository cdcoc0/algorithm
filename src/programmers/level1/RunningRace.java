package programmers.level1;

import java.util.*;

/* 달리기 경주 */
public class RunningRace {
    private static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        Map<String, Integer> findByName = new HashMap<>();
        Map<Integer, String> findByRank = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            findByName.put(players[i], i);
            findByRank.put(i, players[i]);
        }

        for(String p : callings) {
            int idx = findByName.get(p);
            String front = findByRank.get(idx - 1);

            findByName.compute(p, (key, oldValue) -> oldValue - 1);
            findByName.compute(front, (key, oldValue) -> oldValue + 1);
            findByRank.put(idx, front);
            findByRank.put(idx - 1, p);
        }

//        List<String> playersList = new ArrayList<>(Arrays.asList(players));
//
//        for(String p : callings) {
//            int idx = playersList.indexOf(p);
//            playersList.remove(p);
//            playersList.add(idx - 1, p);
//        }

        for(int i = 0; i < answer.length; i++) {
            answer[i] = findByRank.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        solution(players, callings);
    }
}
