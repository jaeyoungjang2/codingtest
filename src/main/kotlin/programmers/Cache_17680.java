package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Cache_17680 {
    public static void main(String[] args) {
        int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        int answer = 0;
        HashMap<String, Integer> cache = new HashMap<>();

        LinkedList<String> cityCacheList = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (cityCacheList.remove(city)) {
                answer += 1;
                cityCacheList.add(city);
                continue;
            }

            answer += 5;
            cityCacheList.add(city);
            if (cityCacheList.size() > cacheSize) {
                cityCacheList.pollFirst();
            }
        }
    }
}
