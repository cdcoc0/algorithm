package programmers.level1;

import java.util.*;

/* 신고 결과 받기 */
public class ReportNGetResult2 {
    private static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> reportedMap = new HashMap<>();
        Map<String, Integer> cntGetMail = new HashMap<>();

        // 중복 제거
        Set<String> distinctReport = new HashSet<>(Arrays.asList(report));

        // 신고당한 아이디 별 횟수 count
        for(String r : distinctReport) {
            String[] split = r.split(" ");
            String reporter = split[0];
            String reported = split[1];

            List<String> list = reportedMap.getOrDefault(reported, new ArrayList<>());
            list.add(reporter);
            reportedMap.put(reported, list);
        }

        // 정지 계정 확인 및 신고자 알림 count
        for(String key : reportedMap.keySet()) {
            List<String> tmp = reportedMap.get(key);
            if(tmp.size() >= k) {
                for(String s : tmp) {
                    cntGetMail.put(s, cntGetMail.getOrDefault(s, 0) + 1);
                }
            }
        }

        // 리턴 배열 생성
        int len = id_list.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            String reporter = id_list[i];
            answer[i] = cntGetMail.getOrDefault(reporter, 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 0;

        solution(id_list, report, k);
    }
}
