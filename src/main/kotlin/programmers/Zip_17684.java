package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Zip_17684 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";

        ArrayList<Integer> list = new ArrayList<>();

        Map<String, Integer> alphabetMap = makeAlphabetMap();
        int number = 27;

        // 처음 글자
        String currentString = msg.substring(0, 1);
        int index = 1;
        while (index < msg.length()) {
            // 다음 글자
            char nextChar = msg.charAt(index);

            // 현재 글자 + 다음 글자가 map에 존재하면 (현재 글자 = 현재 글자 + 다음글자) & continue
            if (alphabetMap.containsKey(currentString + String.valueOf(nextChar))) {
                currentString += nextChar;
                index ++;
                continue;
            }
            // 출력 값 저장
            list.add(alphabetMap.get(currentString));

            // 사전 추가
            alphabetMap.put(currentString + nextChar, number);
            number++;
            // 현재 글자 = 다음 글자
            currentString = String.valueOf(nextChar);
            // 다음 글자를 찾기 위한 인덱스 ++;
            index++;
        }
        // 마지막 출력 값 저장
        list.add(alphabetMap.get(currentString));

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
    }

    private static Map<String, Integer> makeAlphabetMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("I", 9);
        map.put("J", 10);
        map.put("K", 11);
        map.put("L", 12);
        map.put("M", 13);
        map.put("N", 14);
        map.put("O", 15);
        map.put("P", 16);
        map.put("Q", 17);
        map.put("R", 18);
        map.put("S", 19);
        map.put("T", 20);
        map.put("U", 21);
        map.put("V", 22);
        map.put("W", 23);
        map.put("X", 24);
        map.put("Y", 25);
        map.put("Z", 26);
        return map;
    }
}
