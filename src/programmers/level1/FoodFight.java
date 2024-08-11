package programmers.level1;

/* 푸드 파이트 대회 */
public class FoodFight {
    private static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(int i = 1; i < food.length; i++) {
            sb.append(Integer.toString(i).repeat(food[i] / 2));
        }

        result.append(sb);
        result.append(0);
        result.append(sb.reverse());

        return result.toString();
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }
}
