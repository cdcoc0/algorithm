package programmers.level1;

/* 비밀지도 */
public class SecretMap2 {

//    private static String[] getBinary(int n, int[] arr) {
//        String[] result = new String[n];
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 0; i < n; i++) {
//            for(int j = arr[i]; j > 0; j /= 2) {
//                sb.insert(0, j % 2);
//            }
//
//            result[i] = String.format("%"+n+"s", sb).replace(" ", "0");
//            sb.setLength(0);
//        }
//
//        return result;
//    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
//        String[] sArr1 = getBinary(n, arr1);
//        String[] sArr2 = getBinary(n, arr2);
//
//        String[] answer = new String[n];
//        StringBuilder sb = new StringBuilder();
//
//        // 1-벽(#), 0-공백(" ")
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                if(sArr1[i].charAt(j) == '1' || sArr2[i].charAt(j) == '1') {
//                    sb.append("#");
//                } else {
//                    sb.append(" ");
//                }
//            }
//            answer[i] = sb.toString();
//            sb.setLength(0);
//        }
//
//        return answer;

        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);    /* 이 함수를 몰랐음..!!! */
            binary = String.format("%" + n + "s", binary);
            binary = binary.replaceAll("1", "#");
            binary = binary.replaceAll("0", " ");

            answer[i] = binary;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        solution(n, arr1, arr2);
    }
}
