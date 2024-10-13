package programmers.level2;

/* 가장 큰 정사각형 찾기 */
public class SearchingForTheBiggestSquare1 {

    private int[][] board;
//    boolean[][] visited;
    int hLen;
    int wLen;

    private SearchingForTheBiggestSquare1(int[][] board) {
        this.board = board;
        this.hLen = board.length;
        this.wLen = board[0].length;
//        this.visited = new boolean[hLen + 1][wLen + 1];
    }

    private int getSizeOfSquare(int[] info, int distance) {
        int infoH = info[0];
        int infoW = info[1];
        int count = info[2];
        int endH = infoH + distance;
        int endW = infoW + distance;

        if(endH < hLen && endW < wLen) {
            if(board[infoH][endW] == 0) {    // 시작점
                return count;
            }

            for(int i = 1; i <= distance; i++) {
                if(board[infoH + i][endW] == 0 || board[endH][endW - i] == 0) {
                    return count;
                }
            }

            count += distance * 2 + 1;
//            visited[infoH][endW] = true;
            return getSizeOfSquare(new int[]{infoH, infoW, count}, distance + 1);
        }

        return count;
    }
    private static int solution(int[][] board)
    {
        SearchingForTheBiggestSquare1 search = new SearchingForTheBiggestSquare1(board);

        int answer = 0;

        for(int i = 0; i < search.hLen; i++) {
            for(int j = 0; j < search.wLen; j++) {
                if(search.board[i][j] == 1) {
                    int[] info = new int[]{i, j, 1};
//                    search.visited[i][j] = true;
                    answer = Math.max(answer, search.getSizeOfSquare(info, 1));

                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{1,1,0,0},{1,1,0,0},{1,1,1,1},{0,0,1,1}};
        System.out.println(solution(board));
    }
}
