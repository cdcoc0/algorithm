package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/* 캐시-arraylist */
public class CacheArrayList {
    private int solution(int cacheSize, String[] cities) {
//        if(cacheSize == 0) return cities.length * 5;

        int answer = 0;
        List<String> cache = new ArrayList<>();

        for(String city : cities) {
            city = city.toUpperCase();

            if(cache.contains(city)) {
                cache.remove(city);
                answer++;
            } else {
                answer += 5;
            }

            cache.add(city);

            if(cache.size() > cacheSize) {
                cache.remove(0);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        CacheArrayList main = new CacheArrayList();
        main.solution(cacheSize, cities);
    }
}
