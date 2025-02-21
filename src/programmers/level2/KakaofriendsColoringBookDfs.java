package programmers.level2;

public class KakaofriendsColoringBookDfs {
    private int count;
    private boolean[][] visited;
    private int[] move = {0, 0, 1, -1};

    private void dfs(int row, int col, int[][] picture) {
        visited[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int moveX = row + move[i];
            int moveY = col + move[3 - i];

            if(moveX < 0 ||  moveY < 0 || moveX >= picture.length || moveY >= picture[0].length) continue;  // 배열 범위 밖 인덱스

            if(!visited[moveX][moveY] && picture[moveX][moveY] == picture[row][col]) {
                count++;
                dfs(moveX, moveY, picture);
            }
        }
    }

    private int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 0) {
                    visited[i][j] = true;
                    continue;
                }

                if(!visited[i][j]) {
                    count = 1;  // count 초기화 하구
                    numberOfArea++; // visited 안했으니까 area 추가
                    this.dfs(i, j, picture);

                    maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }

    public static void main(String[] args) {
        KakaofriendsColoringBookDfs coloringBookDfs = new KakaofriendsColoringBookDfs();

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},{0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        coloringBookDfs.solution(m, n, picture);
    }
}
