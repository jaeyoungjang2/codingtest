package programmers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Dart2 {

    private static final List<String> OPERATORS = new ArrayList<>(Arrays.asList("S", "D", "T"));
    private static final List<String> ADDITIONAL_OPERATORS = new ArrayList<>(Arrays.asList("*", "#"));

    public static void main(String[] args) {
//        String dartResult = "1S2D*3T"; // 37
        String dartResult = "1S*2T*3S";
        Integer answer = 0;

        String temp = "";
        Integer tempScore = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c == 'S' || c == 'D' || c == 'T') {
                tempScore = Integer.valueOf(temp);
                if (c == 'S') {
                    stack.push(Integer.valueOf(temp));
                }
                if (c == 'D') {
                    stack.push(tempScore * tempScore);
                }
                if (c == 'T') {
                    stack.push(tempScore * tempScore * tempScore);
                }
                temp = "";
                continue;
            }

            if (c == '#') {
                Integer number1 = stack.pop();
                stack.push(number1 * -1);
                continue;
            }
            if (c == '*') {
                Integer number1 = stack.pop();
                if (!stack.isEmpty()) {
                    Integer number2 = stack.pop();
                    stack.push(number2 * 2);
                }
                stack.push(number1 * 2);
                continue;
            }

            temp += c;
        }
        for (Integer integer : stack) {
            answer += integer;
        }
        System.out.println(answer);
    }
}
