package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] split = s.split("-");
        int sum = 0;
        String[] init = split[0].split("\\+");
        for (String s2 : init) {
            sum += Integer.parseInt(s2);
        }


        for (int i = 1; i < split.length; i++) {
            int temp = 0;
            String s1 = split[i];
            String[] split1 = s1.split("\\+");
            for (String s2 : split1) {
                temp += Integer.parseInt(s2);
            }
            sum -= temp;
        }
        System.out.println(sum);
    }
}