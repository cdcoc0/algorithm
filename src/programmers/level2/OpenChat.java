package programmers.level2;

import java.util.HashMap;

/**
 * 오픈채팅방 (kakao blind recruitment)
 */
public class OpenChat {
    private String[] solution(String[] record) {
        String[][] arrSplit = new String[record.length][];
        final String ENTER = "Enter", CHANGE = "Change", LEAVE = "Leave";
        int cntChange = 0;

        // Enter, Change check, record the last nickname
        HashMap<String, String> nickNameMap = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            arrSplit[i] = record[i].split(" ");

            if(!LEAVE.equals(arrSplit[i][0])) {
                nickNameMap.put(arrSplit[i][1], arrSplit[i][2]);
                if(CHANGE.equals(arrSplit[i][0])) cntChange++;
            }
        }

        String[] answer = new String[record.length-cntChange];
        final String ENTER_SUFFIX = "님이 들어왔습니다.", LEAVE_SUFFIX = "님이 나갔습니다.";
        int ptr = 0;
        for(String[] arrRecord : arrSplit) {
            if(CHANGE.equals(arrRecord[0])) continue;
            answer[ptr++] = nickNameMap.get(arrRecord[1]) + (LEAVE.equals(arrRecord[0]) ? LEAVE_SUFFIX : ENTER_SUFFIX);
        }

        return answer;
    }

    public static void main(String[] args) {
        OpenChat main = new OpenChat();

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        main.solution(record);
    }
}
