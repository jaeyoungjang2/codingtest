package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SecretMap {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = new int[]{46, 33, 33, 22, 31, 50};
        int[] arr2 = new int[]{27, 56, 19, 14, 14, 10};
//        int[] arr1 = new int[]{65536, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[] arr2 = new int[]{65536, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int i1 = arr1[i];
            int i2 = arr2[i];
            Long i3 = Long.parseLong(Integer.toBinaryString(i1)) + Long.parseLong(Integer.toBinaryString(i2));
            System.out.println(i3);
//            Integer i3 = Integer.parseInt(Integer.toBinaryString(65536)) + Integer.parseInt(Integer.toBinaryString(65536));
            String temp = "";
            int numberLength = String.valueOf(i3).length();

            if (numberLength < n) {
                temp += " ".repeat(n - numberLength);
            }

            String s = String.valueOf(i3);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    temp += ' ';
                    continue;
                }
                temp += '#';
            }
            answer[i] = temp;
        }
        System.out.println(Arrays.stream(answer).collect(Collectors.joining("\", \"", "[\"", "\"]")));
    }
}
