package programmers.level2;

/**
 * 방문 길이 (Summer/Winter Coding(~2018)
 * comment : Map, Set 활용하면 가독성, 효율성 향상
 */
public class VisitedPathLength {
    private int solution(String dirs) {
        int answer = 0;

        int x = 0;
        int y = 0;

        int[][] path = new int[dirs.length()+1][2];
        path[0][0] = x;
        path[0][1] = y;

        for(int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            switch(dir) {
                case 'U' :
                    y = Math.max(y-1, -5);
                    break;
                case 'D' :
                    y = Math.min(y+1, 5);
                    break;
                case 'L' :
                    x = Math.max(x-1, -5);
                    break;
                case 'R' :
                    x = Math.min(x+1, 5);
                    break;
                default : break;
            }

            path[i+1][0] = x;
            path[i+1][1] = y;

            if(path[i][0] == x && path[i][1] == y) continue;

            int prevX = path[i][0];
            int prevY = path[i][1];

            for(int j = 0; j < i; j++) {
                if(path[j][0] == x && path[j][1] == y &&
                        ((path[j+1][0] == prevX && path[j+1][1] == prevY) || (j > 0 && path[j-1][0] == prevX && path[j-1][1] == prevY))) {
                    answer--;
                    break;
                }
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        VisitedPathLength main = new VisitedPathLength();

//        String dirs = "LULLLLLLU";  //7
        String dirs = "ULURRDLLU";  //7
//        String dirs = "URULDD";  //5
        System.out.println(main.solution(dirs));
    }
}
