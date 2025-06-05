package programmers.level2;

import java.time.Duration;
import java.time.LocalTime;

/* 방금그곡 */
public class TheSongJustNow {
    private String replaceSharp(String n) {
        String[] notes = {"C#", "D#", "F#", "G#", "A#", "E#", "B#"};
        String[] replaceNotes = {"c", "d", "f", "g", "a", "e", "b"};

        for(int i = 0; i < notes.length; i++) {
            n = n.replace(notes[i], replaceNotes[i]);
        }

        return n;
    }

    private String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        long timeComp = 0;

        m = replaceSharp(m);

        for(String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            long time = Duration.between(LocalTime.parse(split[0]), LocalTime.parse(split[1])).toMinutes();

            if(time > timeComp) {
                String tmp = replaceSharp(split[3]);
                String note = tmp.repeat((int) (time / tmp.length())) + tmp.substring(0, (int) (time % tmp.length()));

                if(note.contains(m)) {
                    timeComp = time;
                    answer = split[2];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String m = "ABC#";
        // 시작 시각, 끝난 시각, 제목, 악보
        String[] musicinfos = {"04:00,04:03,NAME,ABC#D"};

        TheSongJustNow main = new TheSongJustNow();
        main.solution(m, musicinfos);
    }
}
