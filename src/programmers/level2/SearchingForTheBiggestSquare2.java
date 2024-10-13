package programmers.level2;

/* 가장 큰 정사각형 찾기 */
public class SearchingForTheBiggestSquare2 {
    private static int getSizeOfSquare(int[] info, int[][] board) {
        int h = info[0];
        int w = info[1];
        int count = info[2];
        int hLen = info[3];
        int wLen = info[4];

        for(int i = 1; i < wLen; i++) {
            int endH = h + i;
            int endW = w + i;

            if(endW >= wLen || endH >= hLen) {
                return count;
            }

            if(board[h][endW] == 0 || board[endH][w] == 0) {
                return count;
            }

            for(int j = 1; j <= i; j++) {
                if(board[h + j][endW] == 0 || board[endH][endW - j] == 0) {
                    return count;
                }
            }

            count += 1 + i * 2;
        }
        return count;
    }
    private static int solution(int[][] board)
    {
        int answer = 0;

        int hLen = board.length;
        int wLen = board[0].length;

        for(int i = 0; i < hLen; i++) {
            for(int j = 0; j < wLen; j++) {
                if(board[i][j] == 1) {
                    int result = getSizeOfSquare(new int[]{i, j, 1, hLen, wLen}, board);
                    answer = Math.max(answer, result);
                    if(Math.sqrt(answer) > wLen - j) {
                        break;
                    }
                }
            }
            if(Math.sqrt(answer) > hLen - i) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{1,1,0,0},{1,1,0,0},{1,1,1,1},{0,0,1,1}};
        System.out.println(solution(board));
    }
}
