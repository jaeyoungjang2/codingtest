package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Solution3_3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        scan.nextLine();
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < N; i++ ){
            String str = scan.nextLine();
            int length = str.length();

            for(int k = 0; k < length; k++) {
                char ch = str.charAt(k);

                switch (ch){
                    case '(':
                        stack.push(ch);
                        break;

                    case ')':
                        int size = stack.size();
                        if(size == 0) {
                           stack.push('(');
                           break;
                        }else{
                            stack.pop();
                        }
                        break;
                }
            }
            if(stack.isEmpty()){
                System.out.println("Yes");
            }else
                System.out.println("No");

            stack.clear();
        }

    }
}