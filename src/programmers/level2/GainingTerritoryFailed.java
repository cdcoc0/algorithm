package programmers.level2;

/* 땅따먹기_실패 */
public class GainingTerritoryFailed {
    static int solution(int[][] land) {
        int answer = 0;
        int excludeIndex = 4;

        for(int[] row : land) {
            if(excludeIndex < row.length) {
                row[excludeIndex] = 0;
            }

            int max = 0;
            for(int i = 0; i < row.length; i++) {
                if(row[i] > max) {
                    max = row[i];
                    excludeIndex = i;
                }
            }

            answer += max;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(solution(land));
    }
}
