package lec10.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());
        int index = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cycle; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number >= index) { // num이 스택의 마지막 값보다 크다면 들어가고, 스택의 마지막 값이 num과 같을때 가지 넣고, 마지막은 빼준다.
                for (int j = index; j < number + 1; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                index = number + 1;
                stack.pop();
                sb.append("-\n");
            } else if (number == stack.peek()) { // num이 스택의 마지막 값과 같다면 스택에서 빠져야 하고
                Integer pop = stack.pop();
                sb.append("-\n");
            } else {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }
        System.out.println("안녕");
        System.out.println(sb.toString());
    }
}
