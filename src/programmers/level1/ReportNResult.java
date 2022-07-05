package programmers.level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReportNResult {
    static int[] solution(String[] id_list, String[] report, int k) {

        // id_list : 이용자의 ID가 담긴 문자열 배열 ( 2 ~ 1000, 10자이하 )
        // report : 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 ( 1 ~ 200000, 3자 ~ 21자)
        // k : 정지 기준이 되는 신고 횟수 ( 1 ~ 200)


        HashMap<String, String> report_list = new HashMap<>(); //각 유저가 신고한 유저(중복 제외)
        HashMap<String, Integer> mail_list = new HashMap<>(); //계정별 통보 메일 횟수

        HashMap<String, Integer> deleteRepetition = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        // 맵에다 넣어서 중복값 제거
        for(int i = 0; i < report.length; i++) {
            deleteRepetition.put(report[i], 0);
        }

        Iterator<Map.Entry<String, Integer>> iter = deleteRepetition.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            String list = entry.getKey();
            String[] arr = list.split(" ");
            String reporter = arr[0];
            String reported = arr[1];

            // StringBuilder 초기화
            sb.setLength(0);
            sb.append(report_list.getOrDefault(reported, ""));
            sb.append(reporter + " ");

            report_list.put(reported, sb.toString());
        }


        Iterator<Map.Entry<String, String>> list_iter = report_list.entrySet().iterator();
        while(list_iter.hasNext()) {
            Map.Entry<String, String> entry = list_iter.next();
//            System.out.println(entry.getKey() + " : " + entry.getValue());

            String[] reported_list = entry.getValue().split(" ");
            if(reported_list.length >= k) {
                for(int i = 0; i < reported_list.length; i++) {
                    mail_list.put(reported_list[i], mail_list.getOrDefault(reported_list[i], 0 ) + 1);
                }
            }
        }

        int[] result = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            result[i] = mail_list.getOrDefault(id_list[i], 0);
        }

        return result;

    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(solution(id_list, report, k));
    }
}
