package programmers.level1;

public class SecretMap {
    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int current1 = arr1[i];
            int current2 = arr2[i];
            String sum1 = "";
            String sum2 = "";

            for(int j = 0; j < n; j++) {
                sum1 += current1 % 2;
                current1 /= 2;

                sum2 += current2 % 2;
                current2 /= 2;
            }

//            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
//            replaceAll

            for(int j = 0; j < n; j++) {
                char ptr1 = sum1.charAt(j);
                char ptr2 = sum2.charAt(j);

                if(ptr1 == '1' || ptr2 == '1')
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.reverse().toString();
            sb.setLength(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(solution(5, arr1, arr2));
    }
}

/*
for (int i = 0; i < n; i++) {
    result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
}

for (int i = 0; i < n; i++) {
    result[i] = String.format("%" + n + "s", result[i]);
    result[i] = result[i].replaceAll("1", "#");
    result[i] = result[i].replaceAll("0", " ");
}*/
