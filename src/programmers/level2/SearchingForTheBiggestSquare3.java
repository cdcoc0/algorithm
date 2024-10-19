package programmers.level2;

/* 가장 큰 정사각형 찾기 */
public class SearchingForTheBiggestSquare3 {
    private static int solution(int[][] board)
    {
        int answer = 0;
        int tmpH = board.length;
        int tmpW = board[0].length;
        int[][] tmp = new int[tmpH + 1][tmpW + 1];

        for(int i = 1; i < tmpH + 1; i++) {
            for(int j = 1; j < tmpW + 1; j++) {
                if(board[i - 1][j - 1] != 0) {
                    int min = Math.min(Math.min(tmp[i][j - 1], tmp[i - 1][j]), tmp[i - 1][j - 1]);
                    tmp[i][j] = min + 1;
                    answer = Math.max(answer, min + 1);
                }
            }
        }


        return answer * answer;
    }

    public static void main(String[] args) {
        int[][] board = {{1,1,0,0},{1,1,0,0},{1,1,1,1},{0,0,1,1}};
        System.out.println(solution(board));
    }
}
