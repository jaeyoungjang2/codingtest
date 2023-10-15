package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int cycle = Integer.parseInt(st.nextToken());

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        int count = 1;
        while (!q.isEmpty()) {
            if (count == cycle) {
                Integer popedNumber = q.pop();
                sb.append(popedNumber + ", ");
                count = 1;
            } else {
                count++;
                q.add(q.pop());
            }
        }

        System.out.println("<" + sb.substring(0, sb.length() - 2).toString() + ">");
    }
}
