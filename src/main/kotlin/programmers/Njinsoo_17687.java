package programmers;

import java.util.Locale;

public class Njinsoo_17687 {
    public static void main(String[] args) {
//        int n = 2; // 진법
//        int t = 4; // 미리 구할 숫자의 갯수
//        int m = 2; // 게임에 참가하는 인원
//        int p = 1; // 튜브의 순서

        int n = 16; // 진법
        int t = 16; // 미리 구할 숫자의 갯수
        int m = 2; // 게임에 참가하는 인원
        int p = 2; // 튜브의 순서

        String answer = "";

        int number = 0;
        // 순서
        int index = 1;
        // 미리 구한 숫자의 갯수
        int count = 0;

        while (count < t) {
            String s = Integer.toString(number, n);
            for (int i = 0; i < s.length(); i++) {
                if (count >= t) {
                    break;
                }

                // 튜브의 차례
                if (index == p) {
                    answer += s.charAt(i);
                    count ++;
                }

                index ++;

                // 한바퀴 돌면 차례는 처음부터
                if (index > m) {
                    index = 1;
                }
            }
            number ++;
        }


        System.out.println(answer.toUpperCase(Locale.ROOT));
    }
}
