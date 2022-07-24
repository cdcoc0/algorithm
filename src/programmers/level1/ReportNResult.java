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


/**
 *
 * 1.
 * class Solution {
 *     public int[] solution(String[] id_list, String[] report, int k) {
 *         List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
 *         HashMap<String, Integer> count = new HashMap<>();
 *         for (String s : list) {
 *             String target = s.split(" ")[1];
 *             count.put(target, count.getOrDefault(target, 0) + 1);
 *         }
 *
 *         return Arrays.stream(id_list).map(_user -> {
 *             final String user = _user;
 *             List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
 *             return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
 *         }).mapToInt(Long::intValue).toArray();
 *     }
 * }
 *
 *
 * 2.
 * class Solution {
 *     public int[] solution(String[] id_list, String[] report, int k) {
 *         int[] answer = new int[id_list.length];
 *         ArrayList<User> users = new ArrayList<>();
 *         HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름>
 *         HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
 *         int idx = 0;
 *
 *         for(String name : id_list) {
 *             idIdx.put(name,idx++);
 *             users.add(new User(name));
 *         }
 *
 *         for(String re : report){
 *             String[] str = re.split(" ");
 *             //suspendedCount.put(str[0], suspendedCount.getOrDefault(str[0],0)+1);
 *             users.get( idIdx.get(str[0])).reportList.add(str[1]);
 *             users.get( idIdx.get(str[1])).reportedList.add(str[0]);
 *         }
 *
 *         for(User user : users){
 *             if(user.reportedList.size() >= k)
 *                 suspendedList.put(user.name,1);
 *         }
 *
 *          for(User user : users){
 *              for(String nameReport : user.reportList){
 *                  if(suspendedList.get(nameReport) != null){
 *                      answer[idIdx.get(user.name)]++;
 *                  }
 *
 *              }
 *         }
 *
 *
 *
 *
 *         return answer;
 *     }
 * }
 *
 * class User{
 *     String name;
 *     HashSet<String> reportList;
 *     HashSet<String> reportedList;
 *     public User(String name){
 *         this.name = name;
 *         reportList = new HashSet<>();
 *         reportedList = new HashSet<>();
 *     }
 * }
 *
 *
 * 3.
 * class Solution {
 *  public int[] solution(String[] id_list, String[] report, int k) {
 *         // key: 신고당한놈, value: 몇명한테 당했는지
 *         Map<String, Set<String>> map = new HashMap<>();
 *
 *         for (String rep : report) {
 *             String[] arr = rep.split(" ");
 *             Set<String> set = map.getOrDefault(arr[1], new HashSet<>());
 *             set.add(arr[0]);
 *             map.put(arr[1], set);
 *         }
 *
 *         // key: 알림받을 놈, value: 몇번 알림받을지
 *         Map<String, Integer> countMap = new LinkedHashMap<>();
 *
 *         for (String id : id_list) {
 *             countMap.put(id, 0);
 *         }
 *
 *         for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
 *             if (entry.getValue().size() >= k) { // 정지당할놈
 *                 for (String value : entry.getValue()) {
 *                     countMap.put(value, countMap.getOrDefault(value, 0) + 1);
 *                 }
 *             }
 *         }
 *
 *         return countMap.values().stream().mapToInt(Integer::intValue).toArray();
 *     }
 * }
 *
 *
 * 4.
 * class Solution {
 *     public int[] solution(String[] id_list, String[] report, int k) {
 *         int[] answer = new int[id_list.length];
 *         Map<String, Integer> idIndex = new HashMap<>();
 *         Map<String, List<String>> reportMap = new HashMap<>();
 *
 *         for (int i = 0; i < id_list.length; i++) {
 *             idIndex.put(id_list[i], i);
 *             reportMap.put(id_list[i], new ArrayList<>());
 *         }
 *
 *         for (String reported : report) {
 *             String[] temp = reported.split(" ");
 *             if (!reportMap.get(temp[1]).contains(temp[0])) {
 *                 reportMap.get(temp[1]).add(temp[0]);
 *             }
 *         }
 *
 *         for (String id : reportMap.keySet()) {
 *             if (k <= reportMap.get(id).size()) {
 *                 for (String reporter : reportMap.get(id)) {
 *                     answer[idIndex.get(reporter)]++;
 *                 }
 *             }
 *         }
 *
 *         return answer;
 *     }
 * }
 *
 *
 *
 */