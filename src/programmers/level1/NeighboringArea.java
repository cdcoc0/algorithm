package programmers.level1;

/* 이웃한 칸 */
public class NeighboringArea {
    private static int solution(String[][] board, int h, int w) {
        int answer = 0;

        int len = board.length;
        String color = board[h][w];

        if(h > 0) {
            if(color.equals(board[h-1][w])) {
                answer++;
            }
        }

        if(w > 0) {
            if(color.equals(board[h][w-1])) {
                answer++;
            }
        }

        if(h < len-1) {
            if(color.equals(board[h+1][w])) {
                answer++;
            }
        }

        if(w < len-1) {
            if(color.equals(board[h][w+1])) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;

        solution(board, h, w);
    }
}
