package programmers.level1;

public class OrderStringDesc {
    static void swap(String[] a, int idx1, int idx2) {
        String r = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = r;
    }

    static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sp = s.split("");
        for(int i = 1; i < sp.length; i++) {
            for(int j = 0; j < sp.length - i; j++) {
                if(sp[j].charAt(0) < sp[j + 1].charAt(0))
                    swap(sp, j, j + 1);
            }
        }
//        Arrays.sort(sp,  Collections.reverseOrder());

        for(String str : sp) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }
}

/*
Stream.of(str.split(""))
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.joining());
*/

/*
toCharArray();
Arrays.sort(ch);
reverse
*/
