package programmers.level1;

import java.util.*;

public class SortStrings2 {
    private static String[] solution(String[] strings, int n) {
        Map<String, String> mapString = new HashMap<>();
        for (String string : strings) {
            mapString.put(string, String.valueOf(string.charAt(n)));
        }

        Map<String, String> sortedStringsMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int lengthDifference = mapString.get(o1).compareTo(mapString.get(o2));
                if (lengthDifference != 0) return lengthDifference;
                return o1.compareTo(o2);
            }
        });

        sortedStringsMap.putAll(mapString);

        return sortedStringsMap.keySet().toArray(String[]::new);
        // 굳이 map으로 변환할 필요가 없었음..!

//        흥미로운 답
//        public String[] solution(String[] strings, int n) {
//            String[] answer = {};
//            ArrayList<String> arr = new ArrayList<>();
//            for (int i = 0; i < strings.length; i++) {
//                arr.add("" + strings[i].charAt(n) + strings[i]);
//            }
//            Collections.sort(arr);
//            answer = new String[arr.size()];
//            for (int i = 0; i < arr.size(); i++) {
//                answer[i] = arr.get(i).substring(1, arr.get(i).length());
//            }
//            return answer;
//        }

//        Arrays.sort(strings, new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2){
//                if(s1.charAt(n) > s2.charAt(n)) return 1;
//                else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
//                else if(s1.charAt(n) < s2.charAt(n)) return -1;
//                else return 0;
//            }
//        });
//        return strings;    // ---> 속도 더 빠름!

//        public String[] solution(String[] strings, int n) {
//            Arrays.sort(strings);
//            Arrays.sort(strings, Comparator.comparing((s) -> s.substring(n, n + 1)));
//            return strings;
//        }    // ---> 속도가 매우 느림!
    }

    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>();
//        map.put("John", 34);
//        map.put("Jane", 26);
//        map.put("Tom", 27);
//        map.put("Bill", 29);
//
//        Map<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return map.get(o1).compareTo(map.get(o2));
//                int lengthDifference = o1.length() - o2.length();
//                if (lengthDifference != 0) return lengthDifference;
//                return o1.compareTo(o2);
//                {Tom=27, Bill=29, Jane=26, John=34}


//            }
//        });

//        sortedMap.putAll(map);
//
//        System.out.println(sortedMap);
        String[] strings = {"abce", "abcd", "cdx"};
        solution(strings, 2);
    }
}
