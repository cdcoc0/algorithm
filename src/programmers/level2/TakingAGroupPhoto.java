package programmers.level2;

/* 단체사진 찍기 */
public class TakingAGroupPhoto {
    String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
    boolean[] visited = new boolean[8];
    String[] tmp = new String[8];
    String[] data;
    int answer = 0;

    private boolean validate(String group) {
        boolean check = false;
        for(String d : data) {
            int distance = Math.abs(group.indexOf(d.charAt(0)) - group.indexOf(d.charAt(2))) - 1;

            switch(d.charAt(3)) {
                case '=' -> {
                    if (distance == d.charAt(4) - '0') check = true;
                    else check = false;
                }
                case '<' -> {
                    if (distance < d.charAt(4) - '0') check = true;
                    else check = false;
                }
                case '>' -> {
                    if (distance > d.charAt(4) - '0') check = true;
                    else check = false;
                }
            }

            if(!check) return false;
        }

        return true;
    }

    private void dfs(int level) {
        if(level == 8) {
            if(validate(tmp[0] + tmp[1] + tmp[2] + tmp[3] + tmp[4] + tmp[5] + tmp[6] + tmp[7])) answer++;
        } else {
            for(int i = 0; i < 8; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    tmp[level] = members[i];
                    dfs(level+1);
                    visited[i] = false;
                }
            }
        }
    }

    private int solution(int n, String[] data) {
        this.data = data;
        dfs(0);

        return answer;
    }

    public static void main(String[] args) {
        TakingAGroupPhoto main = new TakingAGroupPhoto();
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        main.solution(n, data);
    }
}
