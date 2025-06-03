package programmers.level2;

import java.util.LinkedHashMap;
import java.util.Map;

/* 캐시 */
public class CacheLinkedHashMap {
    final int CACHE_SIZE;
    Map<String, Integer> cacheMap;

    private CacheLinkedHashMap(int cacheSize) {
        CACHE_SIZE = cacheSize;
        cacheMap = new LinkedHashMap<>(CACHE_SIZE, 0.75f, true);
    }

    private int solution(String[] cities) {
        int answer = 0;

        for(String city : cities) {
            city = city.toUpperCase();
            answer += cacheMap.getOrDefault(city, 5);
            cacheMap.put(city, 1);

            if(cacheMap.size() > CACHE_SIZE) {
                cacheMap.remove(cacheMap.keySet().iterator().next());
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        CacheLinkedHashMap cache = new CacheLinkedHashMap(cacheSize);
        System.out.println(cache.solution(cities));
    }
}
