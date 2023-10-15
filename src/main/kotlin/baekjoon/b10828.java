package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer cycle = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < cycle; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            if (command.equals("push")) {
                //        push X: 정수 X를 스택에 넣는 연산이다.
                int number = Integer.parseInt(commands[1]);
                stack.add(number);
            } else if (command.equals("pop")) {
                //        pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if (stack.size() >= 1) {
                    sb.append(stack.pop() + "\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (command.equals("size")) {
                //        size: 스택에 들어있는 정수의 개수를 출력한다.
                sb.append(stack.size() + "\n");
            } else if (command.equals("empty")) {
                //        empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
                if (stack.empty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("top")) {
                //        top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if (stack.empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
