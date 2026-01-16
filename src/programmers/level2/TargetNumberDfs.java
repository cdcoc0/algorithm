package programmers.level2;

/**
 * 타겟 넘버 (DFS)
 */
public class TargetNumberDfs {
    private int dfs(int[] numbers, int target, int sum, int idx) {
        if(idx == numbers.length) {
            if(sum == target) return 1;
            else return 0;
        }

        return dfs(numbers, target, sum+numbers[idx], idx+1) + dfs(numbers, target, sum-numbers[idx], idx+1);
    }

    private int solution(int[] numbers, int target) {
        return this.dfs(numbers, target, 0, 0);
    }

    public static void main(String[] args) {
        TargetNumberDfs main = new TargetNumberDfs();
        int[] numbers = {};
        int target = 4;

        main.solution(numbers, target);
    }
}

