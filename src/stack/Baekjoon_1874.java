package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stk = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        int start = 0;

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {

            int k = Integer.parseInt(br.readLine());

            if (k > start) {

                for (int i = start + 1; i <= k; i++) {
                    stk.push(i);
                    sb.append('+').append('\n');
                }
                start = k;
            } else if (stk.peek() != k) {
                System.out.println("NO");
                return;
            }

            stk.pop();
            sb.append('-').append('\n');

        }

        System.out.println(sb);
    }

}
