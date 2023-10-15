package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {

            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                stack.pop();
            }
            else {
                stack.push(N);
            }
        }
        //stack 완성!
        System.out.println("HI");
        int sum = 0;
        for (int j: stack){
            sum += j;
        }
        System.out.println(sum);
    }
}
