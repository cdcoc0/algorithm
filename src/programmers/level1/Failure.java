package programmers.level1;

public class Failure {
    static int[] solution(int N, int[] stages) {
        float[] n = new float[N + 2];
        int[] result = new int[N];

        for(int stage : stages) {
            n[stage]++;
        }

        int sub = stages.length;
        for(int i = 1; i < n.length - 1; i++) {
            float temp = n[i];
            n[i] = temp / sub;
            sub -= temp;
            if(sub == 0)
                break;
        }

        for(int i = 0; i < n.length - 2; i++) {
            int max = 1;
            for(int j = 2; j < n.length - 1; j++) {
                if(n[j] > n[max]) {
                    max = j;
                }
            }
            result[i] = max;
            n[max] = -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] s = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        System.out.println(solution(6, s));
    }
}
