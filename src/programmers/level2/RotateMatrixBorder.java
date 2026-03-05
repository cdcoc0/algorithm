package programmers.level2;

/**
 * 행렬 테두리 회전하기 (2021 Dev-Matching: 웹 백엔드 개발자(상반기))
 * comment : 완전 탐색 사용
 */
public class RotateMatrixBorder {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        main.solution(rows, columns, queries);
    }

    static class main {
        static int moveAndGetMin(int[][] matrix, int[] query) {
            int x1 = query[0]-1, y1 = query[1]-1, x2 = query[2]-1, y2 = query[3]-1;
            int min = matrix[x1][y1], prev = matrix[x1][y1];

            for(int i = y1+1; i <= y2; i++) {
                int tmp = matrix[x1][i];
                min = Math.min(min, tmp);
                matrix[x1][i] = prev;
                prev = tmp;
            }

            for(int i =x1+1; i <= x2; i++) {
                int tmp = matrix[i][y2];
                min = Math.min(min, tmp);
                matrix[i][y2] = prev;
                prev = tmp;
            }

            for(int i = y2-1; i >= y1; i--) {
                int tmp = matrix[x2][i];
                min = Math.min(min, tmp);
                matrix[x2][i] = prev;
                prev = tmp;
            }

            for(int i = x2-1; i >= x1; i--) {
                int tmp = matrix[i][y1];
                min = Math.min(min, tmp);
                matrix[i][y1] = prev;
                prev = tmp;
            }

            return min;
        }

        static int[] solution(int rows, int columns, int[][] queries) {
            int[][] matrix = new int[rows][columns];
            int[] answer = new int[queries.length];

            int num = 1;
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    matrix[i][j] = num++;
                }
            }

            for(int i = 0; i < queries.length; i++) {
                answer[i] = moveAndGetMin(matrix, queries[i]);
            }

            return answer;
        }
    }
}
