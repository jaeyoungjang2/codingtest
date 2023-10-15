package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SecretMap2 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = new int[]{46, 33, 33, 22, 31, 50};
        int[] arr2 = new int[]{27, 56, 19, 14, 14, 10};
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
            answer[i] = answer[i].replaceAll("1", "#").replaceAll("0", " ");
        }

        System.out.println(Arrays.stream(answer).collect(Collectors.joining("\", \"", "[\"", "\"]")));
    }
}
